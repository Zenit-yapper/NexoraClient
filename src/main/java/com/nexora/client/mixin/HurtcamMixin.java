package com.nexora.client.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class HurtcamMixin {
    // method_3174 is the Intermediary name for bobViewWhenHurt
    @Inject(method = "method_3174", at = @At("HEAD"), cancellable = true)
    private void onHurtcam(CallbackInfo ci) {
        ci.cancel();
    }
}
