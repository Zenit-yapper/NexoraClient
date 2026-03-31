package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class ReachDisplayMixin {
    @Inject(method = "doAttack", at = @At("HEAD"))
    private void onDoAttack(CallbackInfoReturnable<Boolean> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.crosshairTarget != null && client.crosshairTarget.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHit = (EntityHitResult) client.crosshairTarget;
            double distance = client.player.getEyePos().distanceTo(entityHit.getPos());
            
            // Shows reach distance in the action bar (above the hotbar)
            client.player.sendMessage(net.minecraft.text.Text.literal("§dReach: §f" + String.format("%.2f", distance)), true);
        }
    }
}
