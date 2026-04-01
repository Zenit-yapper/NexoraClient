package com.nexora.client;

import net.fabricmc.api.ClientModInitializer; // This must be the Client version
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora");

    @Override
    public void onInitializeClient() {
        // This is the correct method name for a ClientModInitializer
        LOGGER.info("Nexora Client 1.0.0 has initialized successfully on Android!");
    }
}
