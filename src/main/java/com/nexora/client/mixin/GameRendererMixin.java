package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Solid background to ensure 100% clarity
        context.fill(0, 0, this.width, this.height, 0xFF0A0A0A);

        int cx = this.width / 2;
        int cy = this.height / 2;

        // Animation pulse logic
        float pulse = (float) (Math.sin(System.currentTimeMillis() / 300.0) + 1) / 2;
        int red = (int) (180 + (75 * pulse));
        int pulseColor = (255 << 24) | (red << 16) | (0 << 8) | 255;

        // Pulsing Logo and Underline
        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA", cx, cy - 80, pulseColor);
        int lineWidth = (int) (30 + (50 * pulse));
        context.fill(cx - lineWidth, cy - 70, cx + lineWidth, cy - 69, pulseColor);

        // Render Utility Modules
        drawRow(context, "Movement", cx, cy - 40);
        drawRow(context, "Visuals", cx, cy - 15);
        drawRow(context, "Combat", cx, cy + 10);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawRow(DrawContext context, String name, int x, int y) {
        context.fill(x - 95, y, x + 95, y + 20, 0xFF151515);
        context.drawTextWithShadow(this.textRenderer, name, x - 88, y + 6, 0xFFFFFFFF);
    }
}
