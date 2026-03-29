package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;

public class NexoraClient implements ClientModInitializer {
    public static boolean fullbright = false;
    private static int leftClicks = 0;

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;

            // 1. FPS & CPS Counter
            context.drawText(client.textRenderer, "§bNEXORA §f| " + client.getCurrentFps() + " FPS", 5, 5, -1, true);
            context.drawText(client.textRenderer, "§bCPS: §f" + leftClicks, 5, 15, -1, true);

            // 2. Armor HUD
            if (ClickGuiScreen.armorHUD) {
                int armorY = context.getScaledWindowHeight() - 60;
                for (ItemStack stack : client.player.getArmorItems()) {
                    context.drawItem(stack, 5, armorY);
                    armorY -= 20;
                }
            }
        });
    }
}
