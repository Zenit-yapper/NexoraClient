package com.nexora.client;

import net.fabricmc.api.ModInitializer;

public class NexoraClient implements ModInitializer {

    @Override
    public void onInitialize() {
        // All zoom keybinds and logic have been removed.
        System.out.println("Nexora Client: Zoom and restricted mods removed.");
    }
}
