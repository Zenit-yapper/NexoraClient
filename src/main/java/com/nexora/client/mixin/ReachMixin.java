package com.nexora.client.mixin;

import com.nexora.client.gui.ClickGuiScreen;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class ReachMixin {
    @Inject(method = "getEntityInteractionRange", at = @At("HEAD"), cancellable = true)
    private void onReach(CallbackInfoReturnable<Double> cir) {
        // Uses the reach value from your ClickGUI
        cir.setReturnValue((double) ClickGuiScreen.reachDistance);
    }
}

