package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // 1. Dark, clean background (No blur)
        context.fill(0, 0, this.width, this.height, 0xFF0A0A0A);

        int cx = this.width / 2;
        int cy = this.height / 2;

        // --- ANIMATION LOGIC ---
        // We use System time to create a value that goes smoothly from 0 to 1
        float tick = (System.currentTimeMillis() % 2000) / 2000f;
        float opacity = MathHelper.sin(tick * (float)Math.PI * 2) * 0.5f + 0.5f;
        
        // Calculate a color that pulses between Dark Purple and Neon Pink
        int pulseColor = (0xFF << 24) | ((int)(150 + (105 * opacity)) << 16) | (0 << 8) | 255;

        // 2. The Animated Header
        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA", cx, cy - 80, pulseColor);
        
        // Decorative pulsing line under the logo
        int lineWidth = (int)(40 + (60 * opacity)); 
        context.fill(cx - lineWidth, cy - 70, cx + lineWidth, cy - 69, pulseColor);

        // 3. Module Rendering
        renderModule(context, "Movement", cx, cy - 40);
        renderModule(context, "Combat", cx, cy - 15);
        renderModule(context, "Visuals", cx, cy + 10);

        super.render(context, mouseX, mouseY, delta);
    }

    private void renderModule(DrawContext context, String text, int x, int y) {
        context.fill(x - 90, y, x + 90, y + 20, 0xFF151515);
        context.drawTextWithShadow(this.textRenderer, text, x - 85, y + 6, 0xFFFFFFFF);
    }
}
