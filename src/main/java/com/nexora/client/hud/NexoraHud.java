package com.nexora.client.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Formatting;

public class NexoraHud {
    public static void init() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            
            // USE THIS LINE ONLY - it works for 1.21.1
            if (client.options.hudHidden || client.currentScreen != null) return;

            String brand = Formatting.AQUA + "NEXORA " + Formatting.WHITE + "CLIENT";
            String fps = Formatting.AQUA + "FPS: " + Formatting.WHITE + client.getCurrentFps();

            drawContext.drawText(client.textRenderer, brand, 10, 10, 0xFFFFFF, true);
            drawContext.drawText(client.textRenderer, fps, 10, 20, 0xFFFFFF, true);
        });
    }
}
