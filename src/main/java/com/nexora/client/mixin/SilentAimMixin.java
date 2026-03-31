package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class SilentAimMixin {
    @Inject(method = "doAttack", at = @At("HEAD"))
    private void onAttack(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.crosshairTarget != null && client.crosshairTarget.getType() == HitResult.Type.MISS) {
            // Secret Logic: If you miss, try to find a player nearby to "correct" the hit
            for (Entity entity : client.world.getEntities()) {
                if (entity instanceof PlayerEntity && entity != client.player) {
                    if (client.player.distanceTo(entity) <= 3.8) { // Reach limit
                        // This "nudges" the internal target without moving your screen
                        client.crosshairTarget = new EntityHitResult(entity);
                        break;
                    }
                }
            }
        }
    }
}
