package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

public class NexoraClient implements ClientModInitializer {
    public static boolean fullbright = false;

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null || client.options.hudHidden) return;

            renderBranding(context, client);
            if (ClickGuiScreen.armorHUD) renderArmor(context, client);
        });
    }

    private void renderBranding(DrawContext context, MinecraftClient client) {
        context.fill(5, 5, 95, 18, 0x88000000);
        context.drawText(client.textRenderer, "§bNEXORA §f" + client.getCurrentFps(), 10, 8, -1, false);
    }

    private void renderArmor(DrawContext context, MinecraftClient client) {
        int ay = 40;
        for (ItemStack stack : client.player.getArmorItems()) {
            if (!stack.isEmpty()) {
                context.drawItem(stack, 5, ay);
                ay += 20;
            }
        }
    }
}
