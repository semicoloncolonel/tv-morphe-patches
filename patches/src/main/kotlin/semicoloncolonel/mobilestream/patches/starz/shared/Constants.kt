package semicoloncolonel.mobilestream.patches.starz.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility
import app.morphe.patcher.patch.FormFactor

object Constants {
    val COMPATIBILITY = Compatibility(
        name = "Starz",
        packageName = "com.bydeluxe.d3.android.program.starz",
        description = "The Starz app. Patch the 6.12.0 build with version code 9510.",
        apkFileType = ApkFileType.APKM,
        appIconColor = 0x000000,
        // One target by version name matches both builds: the phone and tablet build
        // (version code 4518) and the Android TV build (9510). No version code is
        // pinned, so the Android TV build is accepted too. Skip launch video is the
        // only patch that does not apply to it; it no-ops there (see its patch).
        targets = listOf(AppTarget("6.12.0"), AppTarget("6.12.1", versionCode = 4519), AppTarget("6.11.0")),
        formFactor = FormFactor.TV,
    )
}
