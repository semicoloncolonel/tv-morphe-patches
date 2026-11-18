package semicoloncolonel.mobilestream.patches.nbcuott.ads

import app.morphe.patcher.patch.PatchException
import app.morphe.patcher.patch.bytecodePatch
import semicoloncolonel.mobilestream.patches.nbcuott.shared.Constants
import semicoloncolonel.mobilestream.patches.shared.misc.filterWebRequests

// MS NOW 7.10.2 for Android TV. The web app plays each clip through an AWS
// MediaTailor session, which stitches FreeWheel ads into the clip's HLS
// playlists. The clip's own playlist on its origin has no ads. MediaTailor's
// master playlist request is answered with the origin's playlist, and its
// tracking request with no ad breaks, through the WebViewClient's
// shouldInterceptRequest. See ClipAdFilter for the details.
//
// The live stream uses MediaTailor's linear service under another domain and
// is left alone; its ads are part of the broadcast.

private const val CLIP_AD_FILTER =
    "Lsemicoloncolonel/mobilestream/extension/msnow/ClipAdFilter;->filter(Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;"

@Suppress("unused")
val skipAdsPatch = bytecodePatch(
    name = "Skip ads",
    description = "Removes the ads in on-demand clips. Ads in the live stream still play.",
) {
    category("Ads")
    compatibleWith(Constants.MS_NOW)

    extendWith("extensions/extension.mpe")

    execute {
        val client = Constants.WEB_VIEW_CLIENTS.firstOrNull { classDefByOrNull(it) != null }
            ?: throw PatchException("Skip ads: the web app's WebViewClient was not found")
        filterWebRequests(client, CLIP_AD_FILTER)
    }
}
