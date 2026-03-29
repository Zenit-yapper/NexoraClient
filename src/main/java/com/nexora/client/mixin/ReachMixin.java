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
        // Use a default value of 4.5 if you haven't set up the GUI slider yet
        // or use (double) ClickGuiScreen.reachDistance if the GUI is ready
        cir.setReturnValue(4.5); 
    }
}
