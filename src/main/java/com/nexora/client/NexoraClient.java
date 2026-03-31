package com.nexora.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class NexoraClient implements ClientModInitializer {
    public static boolean isZooming = false;
    private static KeyBinding zoomKey;

    @Override
    public void onInitializeClient() {
        // Register the Zoom Key (Default: C)
        zoomKey = new KeyBinding(
            "key.nexora.zoom", 
            InputUtil.Type.KEYSYM, 
            GLFW.GLFW_KEY_C, 
            "category.nexora.client"
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Update the zooming state every tick
            isZooming = zoomKey.isPressed();
        });
    }
}
