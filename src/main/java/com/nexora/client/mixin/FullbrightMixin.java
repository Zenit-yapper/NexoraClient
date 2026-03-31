package com.nexora.client.mixin;

import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SimpleOption.class)
public class FullbrightMixin {
    @Inject(method = "getValue", at = @At("HEAD"), cancellable = true)
    private void onGetValue(CallbackInfoReturnable<Object> cir) {
        // This forces the brightness value to 10.0 (maximum)
        if (cir.getReturnType() == Double.class) {
            cir.setReturnValue(10.0);
        }
    }
}

