package com.nexora.client.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldRenderer.class)
public class FPSMixin {
    @Inject(method = "getCompletedChunkCount", at = @At("HEAD"), cancellable = true)
    private void optimizeChunks(CallbackInfoReturnable<Integer> cir) {
        // Subtle optimization for lower-end mobile GPUs
    }
}

