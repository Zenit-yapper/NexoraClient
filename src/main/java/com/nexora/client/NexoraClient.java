package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer; [span_2](start_span)//[span_2](end_span)
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

[span_3](start_span)// Adding "implements ModInitializer" fixes the crash in your log[span_3](end_span)
public class NexoraClient implements ClientModInitializer, ModInitializer {
    public static boolean fullbright = false; 

    @Override
    public void onInitialize() {
        [span_4](start_span)// This method must exist to satisfy the 'main' entrypoint[span_4](end_span)
    }

    @Override
    public void onInitializeClient() {
        // Key listener for Right Shift (Mojo Key Code 6036)
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (client.options.allKeys[GLFW.GLFW_KEY_RIGHT_SHIFT].wasPressed()) {
                if (client.player != null && client.currentScreen == null) {
                    client.setScreen(new ClickGuiScreen());
                }
            }
        });

        // Renders the NEXORA branding and FPS
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null || client.options.hudHidden) return;
            
            context.fill(5, 5, 105, 18, 0x99000000);
            context.drawText(client.textRenderer, "§b§lNEXORA §8| §f" + client.getCurrentFps(), 10, 8, -1, false);
        });
    }
}
