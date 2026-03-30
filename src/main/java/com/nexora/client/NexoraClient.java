package com.nexora.client;

import com.nexora.client.registry.KeybindingRegistry; // Import your registry folder
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ModInitializer, ClientModInitializer {
    public static final String MOD_ID = "nexora_client";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Nexora Client: Main System Initialized!");
    }

    @Override
    public void onInitializeClient() {
        // This is the missing piece! 
        // It tells your registry folder to start listening for Right Shift.
        KeybindingRegistry.register(); 

        LOGGER.info("Nexora Client: Client-Side Initialized and Registry Loaded!");
    }
}
