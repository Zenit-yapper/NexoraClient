package com.nexora.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;

public class NexoraClient implements net.fabricmc.api.ModInitializer, net.fabricmc.api.ClientModInitializer {
    public static boolean fullbright = false;

    @Override public void onInitialize() {}

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null || client.options.hudHidden) return;

            // 1. FPS Counter (Top Left)
            context.drawText(client.textRenderer, "§bNEXORA §8| §f" + client.getCurrentFps() + " FPS", 5, 5, -1, true);

            // 2. Armor HUD (Lunar Vertical Style)
            int y = height / 2 - 40;
            for (ItemStack stack : client.player.getArmorItems()) {
                if (!stack.isEmpty()) {
                    context.drawItem(stack, 5, y);
                    y += 20;
                }
            }
        });
    }
}
