package com.nexora.client;

import com.nexora.client.hud.NexoraHud;
import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.lwjgl.glfw.GLFW;

public class NexoraClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        NexoraHud.init();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Check if Right Shift is pressed
            if (client.player != null && GLFW.glfwGetKey(client.getWindow().getHandle(), GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS) {
                if (!(client.currentScreen instanceof ClickGuiScreen)) {
                    client.setScreen(new ClickGuiScreen());
                }
            }
        });
    }
}
