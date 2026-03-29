package com.nexora.client.mixin;

import com.nexora.client.NexoraClient;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class FPSMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void boostFPS(CallbackInfo ci) {
        if (NexoraClient.fastRender) {
            // Logic to reduce unnecessary render updates on mobile
        }
    }
}
