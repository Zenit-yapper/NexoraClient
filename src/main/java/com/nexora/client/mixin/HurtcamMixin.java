@Mixin(GameRenderer.class)
public class HurtcamMixin {
    @Inject(method = "tiltViewWhenHurt", at = @At("HEAD"), cancellable = true)
    private void disableHurtcam(CallbackInfo ci) {
        if (com.nexora.client.gui.ClickGuiScreen.betterHurtcam) {
            ci.cancel(); // Removes that annoying screen shake when you get hit
        }
    }
}

