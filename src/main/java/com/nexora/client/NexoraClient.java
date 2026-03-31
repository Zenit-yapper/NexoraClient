package com.nexora.client;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class NexoraClient implements ModInitializer {
    public static boolean isZooming = false;
    private static KeyBinding zoomKey;

    @Override
    public void onInitialize() {
        // Register the Zoom Key (Default: C)
        zoomKey = new KeyBinding(
            "key.nexora.zoom", 
            InputUtil.Type.KEYSYM, 
            GLFW.GLFW_KEY_C, 
            "category.nexora.client"
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            isZooming = zoomKey.isPressed();
        });

        System.out.println("Nexora Client 1.0.0 Initialized Successfully!");
    }
}
