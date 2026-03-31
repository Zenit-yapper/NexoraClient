package com.nexora.client.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class HurtcamMixin {
    // Fixed method name for 1.21.1
    @Inject(method = "bobView", at = @At("HEAD"), cancellable = true)
    private void onBobView(CallbackInfo ci) {
        ci.cancel(); // This disables the screen shake
    }
}
