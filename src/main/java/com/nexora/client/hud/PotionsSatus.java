package com.nexora.client.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Formatting;

public class PotionStatus {
    public static void render(DrawContext context, MinecraftClient client) {
        int y = 10;
        int x = client.getWindow().getScaledWidth() - 100; // Top Right corner

        for (StatusEffectInstance effect : client.player.getStatusEffects()) {
            String name = effect.getEffectType().value().getName().getString();
            int duration = effect.getDuration() / 20; // Convert ticks to seconds
            String timer = String.format("%02d:%02d", duration / 60, duration % 60);
            
            context.drawText(client.textRenderer, Formatting.AQUA + name, x, y, 0xFFFFFF, true);
            context.drawText(client.textRenderer, Formatting.WHITE + timer, x, y + 10, 0xFFFFFF, true);
            y += 25;
        }
    }
}

