package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

public class NexoraClient implements ClientModInitializer, ModInitializer {
    // This variable fixes the "cannot find symbol" error in ClickGuiScreen
    public static boolean fullbright = false; 

    @Override
    public void onInitialize() {
        // Required to prevent the 'main' entrypoint crash
    }

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Check for Right Shift (Mojo 6036) to open the menu
            while (client.options.allKeys[GLFW.GLFW_KEY_RIGHT_SHIFT].wasPressed()) {
                if (client.player != null && client.currentScreen == null) {
                    client.setScreen(new ClickGuiScreen());
                }
            }
            
            // Apply Fullbright brightness
            if (fullbright && client.options != null) {
                client.options.getGamma().setValue(10.0);
            }
        });

        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null || client.options.hudHidden) return;
            
            context.fill(5, 5, 105, 18, 0x99000000);
            context.drawText(client.textRenderer, "§b§lNEXORA §8| §f" + client.getCurrentFps(), 10, 8, -1, false);
        });
    }
}
