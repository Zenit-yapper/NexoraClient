package com.nexora.client;

import net.fabricmc.api.ModInitializer; // This must be imported
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ModInitializer { // You MUST add 'implements ModInitializer'
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora-client");

    @Override
    public void onInitialize() {
        // This is where the game looks to start your mod
        LOGGER.info("Nexora Client is starting!");
    }
}
