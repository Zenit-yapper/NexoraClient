package com.nexora.client;

import com.nexora.client.registry.KeybindRegistry; // Fixed name: Keybind (no 'ing')
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class NexoraClient implements ModInitializer, ClientModInitializer {
    @Override
    public void onInitialize() {
        // Main init
    }

    @Override
    public void onInitializeClient() {
        // Start your keybind listener
        KeybindRegistry.register(); 
    }
}
