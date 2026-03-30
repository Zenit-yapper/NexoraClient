package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexoraClient implements ModInitializer, ClientModInitializer {
    public static final String MOD_ID = "nexora_client";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static KeyBinding guiKeyBinding;

    @Override
    public void onInitialize() {
        [span_3](start_span)LOGGER.info("Nexora Client: Main System Initialized!");[span_3](end_span)
    }

    @Override
    public void onInitializeClient() {
        // 1. Create the KeyBinding for Right Shift
        guiKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nexora.open_gui", 
                InputUtil.Type.KEYSYM, 
                GLFW.GLFW_KEY_RIGHT_SHIFT, 
                "category.nexora.client"
        ));

        // 2. Listen for the key press every "Tick"
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (guiKeyBinding.wasPressed()) {
                client.setScreen(new ClickGuiScreen());
            }
        });

        [span_4](start_span)LOGGER.info("Nexora Client: Keybinds and GUI Registered!");[span_4](end_span)
    }
}
