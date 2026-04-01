package com.nexora.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora");

    @Override
    public void onInitializeClient() {
        // Removed Zoom, Omni-Sprint, and Fast-Place logic.
        LOGGER.info("Nexora Client: System initialized with no special effects.");
    }
}
