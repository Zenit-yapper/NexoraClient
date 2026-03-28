package com.nexora.client.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class NexoraOptimizerMixin {

    @Inject(method = "render", at = @At("HEAD"))
    private void onRenderHead(CallbackInfo ci) {
        // This is where we can force-disable heavy features
        // Such as complex particle calculations or hidden layer rendering
    }

    // This mixin helps stabilize frame times on Android/Pojav
}
