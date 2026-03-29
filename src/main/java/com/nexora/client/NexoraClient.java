package com.nexora.client;

import com.nexora.client.registry.KeybindRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class NexoraClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register the key
        KeybindRegistry.register();

        // Listen for the press
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (KeybindRegistry.clickGuiKey.wasPressed()) {
                // For now, let's just send a message to check if it works
                // Replace this with: client.setScreen(new YourGuiScreen()); later
                if (client.player != null) {
                    client.player.sendMessage(Text.literal("§bNexora GUI Opening..."), false);
                }
            }
        });
    }
}
