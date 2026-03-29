package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer; // Added this import
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

// Added "implements ModInitializer" here
public class NexoraClient implements ClientModInitializer, ModInitializer {

    @Override
    public void onInitialize() {
        // This method is required by ModInitializer to prevent the crash
    }

    @Override
    public void onInitializeClient() {
        // Your existing GUI and HUD code
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (client.options.allKeys[GLFW.GLFW_KEY_RIGHT_SHIFT].wasPressed()) {
                if (client.player != null) {
                    client.setScreen(new ClickGuiScreen());
                }
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
