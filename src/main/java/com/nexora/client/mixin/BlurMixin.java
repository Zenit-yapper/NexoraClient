package com.nexora.client.mixin;

import com.nexora.client.gui.ClickGuiScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class BlurMixin {
    
    @Inject(method = "init", at = @At("HEAD"))
    private void onInit(CallbackInfo ci) {
        // Checks if the screen opening is your Nexora ClickGUI
        if ((Object) this instanceof ClickGuiScreen) {
            MinecraftClient client = MinecraftClient.getInstance();
            
            // This loads the internal Minecraft Blur Shader
            // It makes the background look professional like Feather/Lunar
            if (client.gameRenderer.getPostProcessor() == null) {
                client.gameRenderer.loadPostProcessor(
                    Identifier.of("minecraft", "shaders/post/blur.json")
                );
            }
        }
    }

    @Inject(method = "removed", at = @At("HEAD"))
    private void onRemoved(CallbackInfo ci) {
        // This removes the blur when you close the GUI 
        // so your gameplay doesn't stay blurry!
        if ((Object) this instanceof ClickGuiScreen) {
            MinecraftClient.getInstance().gameRenderer.disablePostProcessor();
        }
    }
}
