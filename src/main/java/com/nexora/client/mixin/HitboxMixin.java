@Mixin(Entity.class)
public class HitboxMixin {
    @Inject(method = "getTargetingMargin", at = @At("HEAD"), cancellable = true)
    private void onHitbox(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(ClickGuiScreen.hitboxSize);
    }
}
