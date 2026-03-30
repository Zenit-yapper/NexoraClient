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
        // This is the Main Entrypoint
        LOGGER.info("Nexora Client Main Initialized!");
    }

    @Override
    public void onInitializeClient() {
        // This is the Client Entrypoint
        LOGGER.info("Nexora Client Side Initialized!");
    }
}
