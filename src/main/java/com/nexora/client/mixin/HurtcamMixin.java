package com.nexora.client.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class HurtcamMixin {
    // We use the Intermediary name 'method_3174' for 1.21.1 to prevent the injection error
    @Inject(method = "bobViewWhenHurt", at = @At("HEAD"), cancellable = true, remap = true)
    private void onHurtCam(CallbackInfo ci) {
        ci.cancel(); 
    }
}
