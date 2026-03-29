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
    private void renderNexoraMenu(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        int w = context.getScaledWindowWidth();
        int h = context.getScaledWindowHeight();

        // Moon
        long time = System.currentTimeMillis() / 50;
        int moonX = (int) (time % (w + 200)) - 100;
        drawCircle(context, moonX, 60, 20, 0xFFEEEEEE);

        // Mountains
        drawMountains(context, w, h, 0xCC1a1a1a, 70, 0.01);
        drawMountains(context, w, h, 0xFF2d2d2d, 40, 0.02);

        // Logo
        String title = "NEXORA CLIENT";
        int textX = (w / 2) - (client.textRenderer.getWidth(title) / 2);
        context.drawText(client.textRenderer, Formatting.AQUA + title, textX, (h / 2) - 10, 0xFFFFFF, true);
    }

    private void drawMountains(DrawContext context, int w, int h, int color, int base, double freq) {
        for (int x = 0; x < w; x++) {
            int mY = h - (int) (Math.abs(Math.sin(x * freq) * 35)) - base;
            context.fill(x, mY, x + 1, h, color);
        }
    }

    private void drawCircle(DrawContext context, int cx, int cy, int r, int col) {
        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++) {
                if (i * i + j * j <= r * r) {
                    context.fill(cx + i, cy + j, cx + i + 1, cy + j + 1, col);
                }
            }
        }
    }
}
