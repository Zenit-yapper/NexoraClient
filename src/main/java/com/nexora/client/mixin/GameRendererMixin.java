package com.nexora.client.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "loadPostProcessor", at = @At("HEAD"), cancellable = true)
    private void stopMenuBlur(CallbackInfo ci) {
        // This stops the game from loading ANY post-processing shaders (like blur)
        // when a screen is opened.
        ci.cancel();
    }
}
