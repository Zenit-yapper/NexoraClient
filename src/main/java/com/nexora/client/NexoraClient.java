package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class NexoraClient implements ModInitializer, ClientModInitializer {
    public static boolean fullbright = false;
    public static KeyBinding guiKey;

    @Override
    public void onInitialize() {
        // Required for 'main' entrypoint
    }

    @Override
    public void onInitializeClient() {
        // Required for 'client' entrypoint
        guiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nexora.gui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "Nexora"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (guiKey.wasPressed()) {
                client.setScreen(new ClickGuiScreen());
            }
        });
    }
}
