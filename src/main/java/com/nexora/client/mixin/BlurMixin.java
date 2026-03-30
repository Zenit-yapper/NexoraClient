package com.nexora.client.mixin; // Must be mixin!

import com.nexora.client.gui.ClickGuiScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class BlurMixin {
    @Inject(method = "init", at = @At("HEAD"))
    private void onInit(CallbackInfo ci) {
        // If the screen opening is your Nexora GUI, apply the blur
        if ((Object) this instanceof ClickGuiScreen) {
            MinecraftClient.getInstance().gameRenderer.loadPostProcessor(
                new net.minecraft.util.Identifier("minecraft", "shaders/post/blur.json")
            );
        }
    }
}
