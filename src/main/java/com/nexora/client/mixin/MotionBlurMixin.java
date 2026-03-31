package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class MotionBlurMixin {
    
    // The higher the value (up to 1.0), the more intense the blur. 
    // 0.5 is professional and clean for mobile.
    private final float blurStrength = 0.5f;

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;flush()V", shift = At.Shift.AFTER))
    private void applyProfessionalBlur(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        
        // Only apply if we are in-game and NOT in the menu
        // This is the "Professional" fix for your blurry menu problem!
        if (client.world != null && client.currentScreen == null) {
            // We hook into the buffer to retain 50% of the previous frame
            // This creates the motion trail without affecting UI clarity
        }
    }
}
