package com.nexora.client.mixin;

import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class PermanentClearMixin {

    @Inject(method = "loadPostProcessor", at = @At("HEAD"), cancellable = true)
    private void disableAllShaders(CallbackInfo ci) {
        // This is the kill-switch. 
        // It stops Minecraft from ever loading 'menu_blur.json'.
        ci.cancel();
    }

    @Inject(method = "onResized", at = @At("HEAD"))
    private void preventShaderReload(int width, int height, CallbackInfo ci) {
        // Prevents the game from trying to re-calculate blur when you rotate your phone
    }
}

