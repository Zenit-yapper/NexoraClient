package com.nexora.client.mixin;

import com.nexora.client.gui.ClickGuiScreen;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class ReachMixin {
    @Inject(method = "getEntityInteractionRange", at = @At("HEAD"), cancellable = true)
    private void modifyReach(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue((double) ClickGuiScreen.reachDistance);
    }
}
