package com.nexora.client.mixin;

import com.nexora.client.gui.ClickGuiScreen;
import net.minecraft.entity.player.PlayerAbilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerAbilities.class)
public class ReachMixin {
    @Inject(method = "getReachDistance", at = @At("HEAD"), cancellable = true)
    private void onGetReach(CallbackInfoReturnable<Float> cir) {
        // This overrides the default reach with your custom slider value
        cir.setReturnValue(ClickGuiScreen.reachDistance);
    }
}
