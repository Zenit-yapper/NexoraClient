@Inject(method = "loadPostProcessor", at = @At("HEAD"), cancellable = true)
private void stopAllPostProcessing(CallbackInfo ci) {
    // Bewisclient's performance is high because it avoids heavy shaders.
    // This line ensures the 'blur' shader never touches your GPU.
    ci.cancel();
}
