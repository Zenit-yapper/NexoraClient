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
    private void onLoadPostProcessor(Identifier id, CallbackInfo ci) {
        // If the game tries to load the 'blur' or 'phosphor' shader, we stop it.
        // This keeps the GUI 100% clear and saves FPS on Mali GPUs.
        if (id.getPath().contains("blur")) {
            ci.cancel();
        }
    }
}
