package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer; // Required to prevent the crash
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import org.lwjgl.glfw.GLFW;

public class NexoraClient implements ClientModInitializer, ModInitializer {
    public static boolean fullbright = false;

    @Override
    public void onInitialize() {
        [span_5](start_span)// This method must exist to satisfy ModInitializer and prevent the crash[span_5](end_span)
    }

    @Override
    public void onInitializeClient() {
        // Key Listener for Right Shift (Mojo Key Code 6036)
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (client.options.allKeys[GLFW.GLFW_KEY_RIGHT_SHIFT].wasPressed()) {
                if (client.player != null) {
                    client.setScreen(new ClickGuiScreen());
                }
            }
        });

        // HUD Rendering
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null || client.options.hudHidden) return;
            renderBranding(context, client);
        });
    }

    private void renderBranding(DrawContext context, MinecraftClient client) {
        context.fill(5, 5, 100, 18, 0x99000000);
        context.drawText(client.textRenderer, "§b§lNEXORA §8| §f" + client.getCurrentFps(), 10, 8, -1, false);
    }
}
