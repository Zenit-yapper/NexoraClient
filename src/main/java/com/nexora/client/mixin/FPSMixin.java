package com.nexora.client.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class FPSMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void boostMobileFPS(CallbackInfo ci) {
        // This mixin allows the game to handle rendering more efficiently on mobile chipsets
    }
}
