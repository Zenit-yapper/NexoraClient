package com.nexora.client.registry;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeybindRegistry {
    public static KeyBinding openGuiKey;

    public static void register() {
        // 1. Define the Right Shift key
        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nexora.open_gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.nexora.client"
        ));

        // 2. Listen for the press
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openGuiKey.wasPressed()) {
                // This opens the GUI we made earlier
                client.setScreen(new ClickGuiScreen());
            }
        });
    }
}
