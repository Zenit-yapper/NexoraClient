package com.nexora.client;

import net.fabricmc.api.ClientModInitializer; // This must be ClientModInitializer
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora");

    @Override
    public void onInitializeClient() {
        // This is the specific method name required for a client entrypoint
        LOGGER.info("Nexora Client: System initialized with no blur/effects.");
    }
}
