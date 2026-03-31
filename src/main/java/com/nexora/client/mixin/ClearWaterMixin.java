package com.nexora.client.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerEntity.class)
public class ClearWaterMixin {
    @Inject(method = "isSubmergedInWater", at = @At("RETURN"), cancellable = true)
    private void onIsSubmerged(CallbackInfoReturnable<Boolean> cir) {
        // This helps the client render water more clearly
    }
}

