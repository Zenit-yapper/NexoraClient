package com.nexora.client;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora-client");

    @Override
    public void onInitialize() {
        LOGGER.info("Nexora Client initialized successfully!");
    }
}
