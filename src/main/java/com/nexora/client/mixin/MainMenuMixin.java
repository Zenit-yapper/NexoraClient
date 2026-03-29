
package com.nexora.client.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MainMenuMixin {

    @Inject(method = "render", at = @At("TAIL"))
    private void renderNexoraNature(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        int w = context.getScaledWindowWidth();
        int h = context.getScaledWindowHeight();

        // 1. Draw the Animated Moon (Moves slowly across the sky)
        long time = System.currentTimeMillis() / 50;
        int moonX = (int) (time % (w + 200)) - 100;
        int moonY = 60;
        
        // Moon Glow
        drawCircle(context, moonX, moonY, 25, 0x33FFFFFF); 
        // Moon Body
        drawCircle(context, moonX, moonY, 20, 0xFFEEEEEE);

        // 2. Draw Mountains (Back Layer - Darker)
        drawMountains(context, w, h, 0xCC1a1a1a, 70, 0.01);

        // 3. Draw Mountains (Front Layer - Lighter)
        drawMountains(context, w, h, 0xFF2d2d2d, 40, 0.02);

        // 4. Center the Nexora Logo
        String title = "NEXORA CLIENT";
        int textWidth = client.textRenderer.getWidth(title);
        int textX = (w / 2) - (textWidth / 2);
        int textY = (h / 2) - 10;
        
        // Correct 1.21.1 drawText method
        context.drawText(client.textRenderer, Formatting.AQUA + title, textX, textY, 0xFFFFFF, true);
        
        // Developer Credit at bottom left
        context.drawText(client.textRenderer, "Dev: " + Formatting.AQUA + "Pratik", 10, h - 20, 0xFFFFFF, true);
    }

    /**
     * Draws mountain silhouettes using a Sine wave
     */
    private void drawMountains(DrawContext context, int w, int h, int color, int baseHeight, double frequency) {
        for (int x = 0; x < w; x++) {
            // Generates natural looking peaks
            int mountainY = h - (int) (Math.abs(Math.sin(x * frequency) * 35)) - baseHeight;
            context.fill(x, mountainY, x + 1, h, color);
        }
    }

    /**
     * Draws a pixel-perfect circle for the moon without needing an image file
     */
    private void drawCircle(DrawContext context, int centerX, int centerY, int radius, int color) {
        for (int i = -radius; i <= radius
             
