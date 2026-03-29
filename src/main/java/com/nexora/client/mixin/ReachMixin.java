@Mixin(PlayerEntity.class)
public class ReachMixin {
    @Inject(method = "getEntityInteractionRange", at = @At("HEAD"), cancellable = true)
    private void onReach(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue((double) ClickGuiScreen.reachDistance);
    }
}
