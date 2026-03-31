package com.nexora.client.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class FastStopMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
        if (player.getVelocity().horizontalLength() < 0.05 && !player.input.pressingForward && !player.input.pressingBack) {
            player.setVelocity(0, player.getVelocity().y, 0);
        }
    }
}

