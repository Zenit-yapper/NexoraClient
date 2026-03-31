package com.nexora.client.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class NoBlurMixin {
    @Inject(method = "loadPostProcessor", at = @At("HEAD"), cancellable = true)
    private void stopTheBlur(CallbackInfo ci) {
        // This force-stops the game from loading the blur shader 
        // that makes your menu look like a mess.
        ci.cancel();
    }
}

