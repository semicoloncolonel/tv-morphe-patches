package semicoloncolonel.mobilestream.patches.shared.misc

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.BytecodePatchContext
import app.morphe.patcher.patch.PatchException
import app.morphe.patcher.util.proxy.mutableTypes.MutableMethod.Companion.toMutable
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.builder.MutableMethodImplementation
import com.android.tools.smali.dexlib2.immutable.ImmutableMethod
import com.android.tools.smali.dexlib2.immutable.ImmutableMethodParameter

// Apps that are a shell around a remote web app (the NBCU news apps and CNN on
// Android TV) send the web app's requests from the WebView itself, so they
// never pass through URL.openConnection or OkHttp. The one place an app can
// see them is WebViewClient.shouldInterceptRequest, which the WebView calls on
// a background thread for every request the page makes.
//
// filterWebRequests() gives the app's WebViewClient that method. The method
// asks the filter first, and returns the filter's response when there is one;
// otherwise it falls through to WebViewClient's own answer, which is null, so
// the WebView loads the request normally. A second call for the same client
// (for example an ads filter after the analytics one) puts its check in front
// of the first.

private const val WEB_VIEW_CLIENT = "Landroid/webkit/WebViewClient;"
private const val INTERCEPT = "shouldInterceptRequest"
private const val RESPONSE = "Landroid/webkit/WebResourceResponse;"
private val INTERCEPT_PARAMETERS = listOf("Landroid/webkit/WebView;", "Landroid/webkit/WebResourceRequest;")

/**
 * Adds [filter] to [client]'s shouldInterceptRequest. [filter] is a full
 * static method reference taking a WebResourceRequest and returning a
 * WebResourceResponse, or null to let the request through.
 */
internal fun BytecodePatchContext.filterWebRequests(client: String, filter: String) {
    val classDef = mutableClassDefBy(client)
    if (classDef.superclass != WEB_VIEW_CLIENT) {
        throw PatchException("$client does not extend WebViewClient")
    }
    val check = """
        invoke-static { p2 }, $filter
        move-result-object v0
        if-eqz v0, :pass
        return-object v0
        :pass
    """.trimIndent()

    val existing = classDef.methods.firstOrNull { method ->
        method.name == INTERCEPT && method.returnType == RESPONSE &&
            method.parameterTypes.map { it.toString() } == INTERCEPT_PARAMETERS
    }
    if (existing != null) {
        // Only a method an earlier call added is expected here. Its one local
        // register, v0, is free at the start.
        val implementation = existing.implementation
            ?: throw PatchException("$client.$INTERCEPT has no code")
        if (implementation.registerCount - 3 < 1) {
            throw PatchException("$client.$INTERCEPT has no free register")
        }
        existing.addInstructions(0, "$check\nnop")
        return
    }

    // v0, then p0 (this), p1 (the WebView), and p2 (the request).
    val method = ImmutableMethod(
        client,
        INTERCEPT,
        INTERCEPT_PARAMETERS.map { ImmutableMethodParameter(it, null, null) },
        RESPONSE,
        AccessFlags.PUBLIC.value,
        null,
        null,
        MutableMethodImplementation(4),
    ).toMutable()
    method.addInstructions(
        0,
        """
            $check
            invoke-super { p0, p1, p2 }, $WEB_VIEW_CLIENT->$INTERCEPT(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)$RESPONSE
            move-result-object v0
            return-object v0
        """.trimIndent(),
    )
    classDef.methods.add(method)
}
