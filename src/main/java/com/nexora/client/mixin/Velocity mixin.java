package com.nexora.client.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class VelocityMixin {
    @Inject(method = "setVelocityClient", at = @At("HEAD"), cancellable = true)
    private void onSetVelocity(double x, double y, double z, CallbackInfo ci) {
        // Reduces knockback by 60% for a "legit" but professional feel
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
        player.setVelocity(x * 0.4, y * 0.4, z * 0.4);
        ci.cancel();
    }
}

