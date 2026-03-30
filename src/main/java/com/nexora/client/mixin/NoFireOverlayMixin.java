package com.nexora.client.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class NoFireOverlayMixin {
    @Inject(method = "renderFire", at = @At("HEAD"), cancellable = true)
    private void onRenderFire(CallbackInfo ci) {
        ci.cancel(); // Completely hides the fire effect on the player's view
    }
}

