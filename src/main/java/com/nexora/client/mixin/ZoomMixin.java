package com.nexora.client.mixin;

import com.nexora.client.NexoraClient;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class ZoomMixin {
    @Inject(method = "getFov", at = @At("RETURN"), cancellable = true)
    private void onGetFov(CallbackInfoReturnable<Double> cir) {
        // If Nexora's zoom key is being held
        if (NexoraClient.isZooming) {
            // cir.getReturnValue() / 4.0 makes the zoom 4x stronger
            cir.setReturnValue(20.0); 
        }
    }
}

