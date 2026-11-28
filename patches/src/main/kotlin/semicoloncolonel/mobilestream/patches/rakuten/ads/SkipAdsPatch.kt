package semicoloncolonel.mobilestream.patches.rakuten.ads

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.AccessFlags
import semicoloncolonel.mobilestream.patches.rakuten.shared.Constants

// Rakuten TV 4.14.6 (Android TV) inserts every ad in its web app, on the
// client. The stream reply lists the ad breaks in data.ad_placements, and live
// channels add a pre-roll of their own; each ad is then fetched as VAST from
// csai.adprxy.rakuten.tv. RakutenAds empties the list and answers the VAST
// requests with no ad (see the extension for both layers).
//
// The app sets no WebViewClient, so the patch gives the web view one when the
// app sets it up. Ads that a live channel's partner stitches into the stream
// itself (Amagi, MediaTailor) are part of the video and still play.

private const val RAKUTEN_ADS = "Lsemicoloncolonel/mobilestream/extension/rakuten/RakutenAds;"

// The web view setup in the app's web view wrapper: it turns on web contents
// debugging for every build flavor but "prodRakutentv", then sets the chrome
// client and the web settings.
internal object WebViewSetupFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PRIVATE, AccessFlags.FINAL),
    returnType = "V",
    parameters = listOf("Landroid/webkit/WebView;"),
    strings = listOf("prodRakutentv"),
)

@Suppress("unused")
val skipAdsPatch = bytecodePatch(
    name = "Skip ads",
    description = "Removes the pre-roll and mid-roll ads from on-demand videos, and the pre-roll from live channels.",
) {
    compatibleWith(Constants.COMPATIBILITY)

    extendWith("extensions/extension.mpe")

    execute {
        WebViewSetupFingerprint.method.addInstructions(
            0,
            // /range: the patcher drops a 4-bit invoke whose register is past v15.
            "invoke-static/range { p1 .. p1 }, $RAKUTEN_ADS->attach(Landroid/webkit/WebView;)V",
        )
    }
}
