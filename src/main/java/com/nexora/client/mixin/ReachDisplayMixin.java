package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ReachDisplayMixin {
    @Inject(method = "attackEntity", at = @At("HEAD"))
    private void onAttack(Entity target, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && target != null) {
            double distance = client.player.distanceTo(target);
            client.player.sendMessage(net.minecraft.text.Text.literal("§dReach: §f" + String.format("%.2f", distance)), true);
        }
    }
}

