package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import com.nexora.client.registry.KeybindRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class NexoraClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeybindRegistry.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Check if our key is pressed and no other screen is open
            if (KeybindRegistry.clickGuiKey.wasPressed() && client.currentScreen == null) {
                client.setScreen(new ClickGuiScreen());
            }
        });
    }
}
