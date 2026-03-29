@Mixin(Entity.class)
public abstract class ReachMixin {
    @Inject(method = "getTargetingMargin", at = @At("HEAD"), cancellable = true)
    private void onHitbox(CallbackInfoReturnable<Float> cir) {
        // This expands the hitbox of EVERY entity you look at
        cir.setReturnValue(com.nexora.client.gui.ClickGuiScreen.hitboxSize);
    }
}
