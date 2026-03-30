package com.nexora.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The core class for Nexora Client.
 * Implements both ModInitializer (Main) and ClientModInitializer (Client)
 * to prevent crashes on mobile launchers like Mojo/Pojav.
 */
public class NexoraClient implements ModInitializer, ClientModInitializer {
    public static final String MOD_ID = "nexora_client";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This is the 'Main' entrypoint. 
        // It must exist to prevent the ClassCastException crash.
        LOGGER.info("Nexora Client: [Main] successfully initialized.");
    }

    @Override
    public void onInitializeClient() {
        // This is the 'Client' entrypoint.
        // This is where your HUD, FPS counter, and GUI logic lives.
        LOGGER.info("Nexora Client: [Client-Side] successfully initialized.");
    }
}
