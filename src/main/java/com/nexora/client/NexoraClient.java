package com.nexora.client;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ModInitializer, ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora-client");

    @Override
    public void onInitialize() {
        LOGGER.info("Nexora Main Initialized");
    }

    @Override
    public void onInitializeClient() {
        LOGGER.info("Nexora Client Initialized");
    }
}
