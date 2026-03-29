package com.nexora.client.registry;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeybindRegistry {
    public static KeyBinding clickGuiKey;

    public static void register() {
        clickGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nexora.clickgui", 
                InputUtil.Type.KEYSYM, 
                GLFW.GLFW_KEY_RIGHT_SHIFT, 
                "category.nexora.client"
        ));
    }
}

