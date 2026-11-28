package semicoloncolonel.mobilestream.patches.rakuten.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.Compatibility
import app.morphe.patcher.patch.FormFactor
import semicoloncolonel.mobilestream.patches.shared.misc.devTarget

object Constants {
    // The Android TV build of Rakuten TV is a native shell around Rakuten's
    // web app (prod-atv-ui40-app.rakuten.tv). The native code plays the video
    // in ExoPlayer for the web app and has no ad code of its own.
    val COMPATIBILITY = Compatibility(
        name = "Rakuten TV",
        packageName = "tv.wuaki.apptv",
        description = "The Rakuten TV Android TV app.",
        apkFileType = ApkFileType.APKM,
        appIconColor = 0xBF0002,
        targets = listOf(devTarget("4.14.6", versionCode = 4140601)),
        formFactor = FormFactor.TV,
    )
}
