package com.nexora.client.mixin;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(method = "loadPostProcessor", at = @At("HEAD"), cancellable = true)
    private void stopVanillaBlur(Identifier id, CallbackInfo ci) {
        // This is the core fix. It prevents the 'menu_blur' shader 
        // from ever initializing on your Mali GPU.
        if (id.getPath().contains("blur")) {
            ci.cancel();
        }
    }
}
