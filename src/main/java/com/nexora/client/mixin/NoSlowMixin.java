package com.nexora.client.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerEntity.class)
public class NoSlowMixin {
    @Inject(method = "isUsingItem", at = @At("RETURN"), cancellable = true)
    private void onIsUsingItem(CallbackInfoReturnable<Boolean> cir) {
        // Tricking the game into thinking we aren't "using" an item
        // so it doesn't apply the movement slowdown.
        cir.setReturnValue(false);
    }
}

