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

        // 1. Draw the Animated Moon
        long time = System.currentTimeMillis() / 50;
        int moonX = (int) (time % (w + 200)) - 100;
        drawCircle(context, moonX, 60, 25, 0x33FFFFFF); // Glow
        drawCircle(context, moonX, 60, 20, 0xFFEEEEEE); // Moon

        // 2. Draw Mountains (Back Layer)
        drawMountains(context, w, h, 0xCC1a1a1a, 80, 0.01);

        // 3. Draw Mountains (Front Layer)
        drawMountains(context, w, h, 0xFF2d2d2d, 50, 0.02);

        // 4. Center the Logo (The line that was broken)
        String title = "NEXORA CLIENT";
        int textWidth = client.textRenderer.getWidth(title);
        context.drawText(client.textRenderer, Formatting.AQUA + title, (w / 2) - (textWidth / 2), (h / 2) - 10, 0xFFFFFF, true);
        
        context.drawText(client.textRenderer, "Dev: " + Formatting.AQUA + "Pratik", 10, h - 20, 0xFFFFFF, true);
    }

    private void drawMountains(DrawContext context, int w, int h, int color, int baseHeight, double frequency) {
        for (int x = 0; x < w; x++) {
            int mountainY = h - (int) (Math.abs(Math.sin(x * frequency) * 40)) - baseHeight;
            context.fill(x, mountainY, x + 1, h, color);
        }
    }

    private void drawCircle(DrawContext context, int centerX, int centerY, int radius, int color) {
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if (i * i + j * j <= radius * radius) {
                    context.fill(centerX + i, centerY + j, centerX + i + 1, centerY + j + 1, color);
                }
            }
        }
    }
}
