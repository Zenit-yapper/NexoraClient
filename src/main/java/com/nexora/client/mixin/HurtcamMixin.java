@Mixin(GameRenderer.class)
public class HurtcamMixin {
    @Inject(method = "bobViewWhenHurt", at = @At("HEAD"), cancellable = true)
    private void onHurtcam(DrawContext context, float tickDelta, CallbackInfo ci) {
        ci.cancel(); // Simply stops the shake
    }
}
