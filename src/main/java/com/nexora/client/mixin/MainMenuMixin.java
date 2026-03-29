package com.nexora.client.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MainMenuMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        int width = context.getScaledWindowWidth();
        int height = context.getScaledWindowHeight();

        // Background Overlay (Dark & Smooth)
        context.fill(0, 0, width, height, 0x90000000);

        // Nexora Title
        context.drawText(context.getMatrices().peek().getPositionMatrix(), "NEXORA CLIENT", 
            (width / 2) - 40, (height / 2) - 50, 0x00FFFF, true);
        
        context.drawText(context.getMatrices().peek().getPositionMatrix(), 
            Formatting.GRAY + "Logged in as: " + Formatting.WHITE + "Pratik", 
            10, height - 20, 0xFFFFFF, true);
    }
}

