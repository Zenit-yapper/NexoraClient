package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ReachDisplayMixin {
    // Added the correct descriptor to match the attackEntity method in 1.21.1
    @Inject(method = "attackEntity(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/entity/Entity;)V", at = @At("HEAD"))
    private void onAttack(PlayerEntity player, Entity target, CallbackInfo ci) {
        if (player != null && target != null) {
            double distance = player.distanceTo(target);
            player.sendMessage(net.minecraft.text.Text.literal("§dReach: §f" + String.format("%.2f", distance)), true);
        }
    }
}
