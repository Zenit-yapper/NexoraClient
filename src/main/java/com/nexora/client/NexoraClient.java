package com.nexora.client;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora");

    @Override
    public void onInitialize() {
        // This is the code that runs when the game starts.
        // It must use onInitialize() to match the ModInitializer interface.
        LOGGER.info("Nexora Client 1.0.0 has initialized successfully!");
    }
}
