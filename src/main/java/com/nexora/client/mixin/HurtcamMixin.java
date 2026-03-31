package com.nexora.client.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class HurtcamMixin {
    // We use the intermediary name 'method_3174' so the launcher can find it
    @Inject(method = "method_3174", at = @At("HEAD"), cancellable = true)
    private void onHurtcam(CallbackInfo ci) {
        ci.cancel();
    }
}
