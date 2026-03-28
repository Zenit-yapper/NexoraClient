package com.nexora.client;

import com.nexora.client.hud.NexoraHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class NexoraClient implements ModInitializer, ClientModInitializer {
    @Override
    public void onInitialize() {
        // Essential safety for PojavLauncher
    }

    @Override
    public void onInitializeClient() {
        // Start the HUD
        NexoraHud.init();
        System.out.println("NexoraClient 1.21.1 is now Active!");
    }
}

