package com.nexora.client.mixin;

import net.minecraft.client.util.NarratorManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NarratorManager.class)
public class NoNarratorMixin {
    @Inject(method = "isActive", at = @At("HEAD"), cancellable = true)
    private void disableNarrator(CallbackInfoReturnable<Boolean> cir) {
        // This forces the game to think the narrator is always OFF
        // so it never tries to load the broken libflite.so library.
        cir.setReturnValue(false);
    }
}

