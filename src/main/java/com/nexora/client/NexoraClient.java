package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import org.lwjgl.glfw.GLFW;

public class NexoraClient implements ClientModInitializer, ModInitializer {
    public static boolean fullbright = false;
    private static int cps = 0;
    private static long lastTick = 0;

    @Override
    public void onInitialize() { }

    @Override
    public void onInitializeClient() {
        // 1. Key Listener to open GUI (Right Shift)
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (GLFW.glfwGetKey(client.getWindow().getHandle(), GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS) {
                if (client.currentScreen == null) {
                    client.setScreen(new ClickGuiScreen());
                }
            }
            
            // Fullbright Logic
            if (fullbright && client.options != null) {
                client.options.getGamma().setValue(10.0);
            }
        });

        // 2. Professional HUD Rendering
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null || client.options.hudHidden) return;

            // Branding & FPS
            context.fill(5, 5, 100, 18, 0x99000000);
            context.drawText(client.textRenderer, "§b§lNEXORA §8| §f" + client.getCurrentFps(), 10, 8, -1, false);

            // Armor Status
            if (ClickGuiScreen.armorHUD) {
                int ay = 40;
                for (ItemStack stack : client.player.getArmorItems()) {
                    if (!stack.isEmpty()) {
                        context.drawItem(stack, 5, ay);
                        ay += 20;
                    }
                }
            }

            // Coordinates
            if (ClickGuiScreen.showCoords) {
                String xyz = String.format("§7X: §f%d §7Y: §f%d §7Z: §f%d", 
                    (int)client.player.getX(), (int)client.player.getY(), (int)client.player.getZ());
                context.drawText(client.textRenderer, xyz, 5, context.getScaledWindowHeight() - 15, -1, true);
            }
        });
    }
}
