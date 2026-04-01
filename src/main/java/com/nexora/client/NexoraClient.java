package com.nexora.client;

import net.fabricmc.api.ClientModInitializer; // Use ClientModInitializer
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora");

    @Override
    public void onInitializeClient() {
        // This is the correct method for ClientModInitializer
        LOGGER.info("Nexora Client Initialized Successfully!");
    }
}
