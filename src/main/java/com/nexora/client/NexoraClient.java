package com.nexora.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ModInitializer, ClientModInitializer {
    public static final String MOD_ID = "nexora_client";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This satisfies the 'main' entrypoint requirement
        LOGGER.info("Nexora Client: Main System Initialized!");
    }

    @Override
    public void onInitializeClient() {
        // This is where your HUD and Client-side features start
        LOGGER.info("Nexora Client: Client Graphics Initialized!");
    }
}
