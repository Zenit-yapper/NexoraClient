package com.nexora.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora-client");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Nexora Client initialized for 1.21.1!");
    }
}
