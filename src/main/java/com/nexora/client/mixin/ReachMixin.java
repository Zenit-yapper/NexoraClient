package com.nexora.client.mixin;

import com.nexora.client.gui.ClickGuiScreen;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class ReachMixin {
    @Inject(method = "getAbilities().getReachDistance", at = @At("HEAD"), cancellable = true)
    private void onGetReach(CallbackInfoReturnable<Float> cir) {
        // Injects our custom reach from the GUI
        cir.setReturnValue(ClickGuiScreen.reachDistance);
    }
}

