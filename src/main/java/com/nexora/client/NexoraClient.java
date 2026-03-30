package com.nexora.client;

import com.nexora.client.registry.KeybindRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class NexoraClient implements ModInitializer, ClientModInitializer {
    @Override
    public void onInitialize() {}

    @Override
    public void onInitializeClient() {
        KeybindRegistry.register(); 
    }
}
