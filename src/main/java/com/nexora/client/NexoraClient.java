package com.nexora.client;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// You MUST implement both for your current fabric.mod.json to work
public class NexoraClient implements ModInitializer, ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexora-client");
    
    // Toggles for ClickGUI features
    public static boolean fullbright = false;
    public static boolean fastRender = true;

    @Override
    public void onInitialize() {
        LOGGER.info("Nexora Main Entrypoint Initialized");
    }

    @Override
    public void onInitializeClient() {
        LOGGER.info("Nexora Client Entrypoint Initialized");
    }
}
