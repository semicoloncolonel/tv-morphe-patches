package semicoloncolonel.mobilestream.extension.rakuten;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.Browser;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.ByteArrayInputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Skips the ads in Rakuten TV for Android TV.
 *
 * The app is a shell around Rakuten's web app (prod-atv-ui40-app.rakuten.tv),
 * which inserts every ad on the client. Two layers:
 *
 *   1. The stream reply (POST .../streamings) lists the ad breaks in
 *      data.ad_placements. A script in the page wraps XMLHttpRequest and fetch
 *      and empties that list, which is the web app's own shape for a video
 *      without ads. The stream itself is unchanged.
 *   2. Live channels also get a pre-roll the web app adds on its own. Every
 *      ad is fetched as VAST from Rakuten's ad proxy, csai.adprxy.rakuten.tv,
 *      and those requests are answered with an empty VAST, the standard reply
 *      for "no ad", so the player skips the break.
 *
 * The app sets no WebViewClient, so this class adds one. The script only has
 * to be in place before the first video starts, so it is run when each page
 * starts and again when it finishes loading. It does nothing the second time.
 */
@SuppressWarnings("unused")
public final class RakutenAds {
    private static final String TAG = "MSP-RAKUTEN-ADS";
    private static final String AD_PROXY_HOST = "csai.adprxy.rakuten.tv";

    private static final byte[] EMPTY_VAST =
            "<VAST version=\"4.0\"></VAST>".getBytes(StandardCharsets.UTF_8);

    static final String SCRIPT = "(function () {\n"
            + "  if (window.__msNoAds) return;\n"
            + "  window.__msNoAds = true;\n"
            + "  var STREAM = /\\/streamings(\\?|$)/;\n"
            + "  function isStream(url) {\n"
            + "    try { return STREAM.test(new URL(String(url), location.href).pathname); }\n"
            + "    catch (e) { return false; }\n"
            + "  }\n"
            + "  function strip(text) {\n"
            + "    try {\n"
            + "      var d = JSON.parse(text);\n"
            + "      if (!d || !d.data || !d.data.ad_placements || !d.data.ad_placements.length) return text;\n"
            + "      d.data.ad_placements = [];\n"
            + "      window.__msNoAdsHits = (window.__msNoAdsHits || 0) + 1;\n"
            + "      return JSON.stringify(d);\n"
            + "    } catch (e) {\n"
            + "      return text;\n"
            + "    }\n"
            + "  }\n"
            + "  var origFetch = window.fetch;\n"
            + "  if (origFetch) {\n"
            + "    window.fetch = function (input) {\n"
            + "      var url = typeof input === 'string' ? input : (input && input.url) || '';\n"
            + "      var p = origFetch.apply(this, arguments);\n"
            + "      if (!isStream(url)) return p;\n"
            + "      return p.then(function (res) {\n"
            + "        return res.clone().text().then(function (t) {\n"
            + "          return new Response(strip(t), { status: res.status, statusText: res.statusText, headers: res.headers });\n"
            + "        }, function () { return res; });\n"
            + "      });\n"
            + "    };\n"
            + "  }\n"
            + "  var XHR = window.XMLHttpRequest && window.XMLHttpRequest.prototype;\n"
            + "  if (!XHR) return;\n"
            + "  var origOpen = XHR.open;\n"
            + "  XHR.open = function (method, url) {\n"
            + "    this.__msStream = isStream(url);\n"
            + "    return origOpen.apply(this, arguments);\n"
            + "  };\n"
            + "  ['responseText', 'response'].forEach(function (prop) {\n"
            + "    var desc = Object.getOwnPropertyDescriptor(XHR, prop);\n"
            + "    if (!desc || !desc.get) return;\n"
            + "    Object.defineProperty(XHR, prop, {\n"
            + "      configurable: true,\n"
            + "      get: function () {\n"
            + "        var v = desc.get.call(this);\n"
            + "        if (!this.__msStream || this.readyState !== 4) return v;\n"
            + "        if (typeof v === 'string') return strip(v);\n"
            + "        if (v && typeof v === 'object' && v.data && v.data.ad_placements) {\n"
            + "          return JSON.parse(strip(JSON.stringify(v)));\n"
            + "        }\n"
            + "        return v;\n"
            + "      },\n"
            + "    });\n"
            + "  });\n"
            + "})();";

    private RakutenAds() {
    }

    /** Called from injected smali when the app sets up its web view. */
    public static void attach(WebView webView) {
        try {
            webView.setWebViewClient(new Client());
        } catch (Throwable t) {
            Log.w(TAG, "attach failed: " + t);
        }
    }

    static WebResourceResponse filter(WebResourceRequest request) {
        try {
            if (request == null || request.getUrl() == null) return null;
            Uri url = request.getUrl();
            if (!AD_PROXY_HOST.equalsIgnoreCase(url.getHost())) return null;
            if (!"GET".equalsIgnoreCase(request.getMethod())) return null;
            Log.i(TAG, "No ad from " + url.getHost() + url.getPath());
            return respond(request, EMPTY_VAST);
        } catch (Throwable t) {
            return null;
        }
    }

    private static WebResourceResponse respond(WebResourceRequest request, byte[] body) {
        Map<String, String> headers = new HashMap<>();
        String origin = null;
        Map<String, String> requestHeaders = request.getRequestHeaders();
        if (requestHeaders != null) {
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                if ("origin".equalsIgnoreCase(header.getKey())) origin = header.getValue();
            }
        }
        if (origin != null) {
            headers.put("Access-Control-Allow-Origin", origin);
            headers.put("Access-Control-Allow-Credentials", "true");
        } else {
            headers.put("Access-Control-Allow-Origin", "*");
        }
        headers.put("Cache-Control", "no-store");
        return new WebResourceResponse("text/xml", "utf-8", 200, "OK", headers, new ByteArrayInputStream(body));
    }

    private static void inject(WebView view) {
        try {
            view.evaluateJavascript(SCRIPT, null);
        } catch (Throwable t) {
            Log.w(TAG, "inject failed: " + t);
        }
    }

    static final class Client extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            inject(view);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            inject(view);
        }

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            return filter(request);
        }

        // Without a WebViewClient, a link the page opens is handed to another
        // app when one can show it, and loads in the web view when none can.
        // This is the web view's own default, kept as it was.
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (request == null || request.getUrl() == null || !request.isForMainFrame()) return false;
            String url = request.getUrl().toString();
            if (url.startsWith("about:") || url.startsWith("javascript:")) return false;
            try {
                Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setComponent(null);
                Intent selector = intent.getSelector();
                if (selector != null) {
                    selector.addCategory(Intent.CATEGORY_BROWSABLE);
                    selector.setComponent(null);
                }
                intent.putExtra(Browser.EXTRA_APPLICATION_ID, view.getContext().getPackageName());
                view.getContext().startActivity(intent);
                return true;
            } catch (URISyntaxException | RuntimeException e) {
                return false;
            }
        }
    }
}
