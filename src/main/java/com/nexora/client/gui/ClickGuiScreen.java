package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // SOLID BLACK background. No transparency = No blur.
        context.fill(0, 0, this.width, this.height, 0xFF080808);

        int cx = this.width / 2;
        int cy = this.height / 2;

        // --- THE ANIMATION LOGIC ---
        // Creates a pulse every 2 seconds
        float pulse = (float) (Math.sin(System.currentTimeMillis() / 300.0) + 1) / 2;
        // Pulse between deep purple and bright neon pink
        int red = (int) (180 + (75 * pulse));
        int blue = 255;
        int pulseColor = (255 << 24) | (red << 16) | (0 << 8) | blue;

        // 1. The Pulsing Logo
        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA", cx, cy - 80, pulseColor);
        
        // 2. Animated Underline (expands and contracts)
        int lineWidth = (int) (30 + (50 * pulse));
        context.fill(cx - lineWidth, cy - 70, cx + lineWidth, cy - 69, pulseColor);

        // 3. Module List
        drawModule(context, "Movement", cx, cy - 40);
        drawModule(context, "Visuals", cx, cy - 15);
        drawModule(context, "Combat", cx, cy + 10);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawModule(DrawContext context, String name, int x, int y) {
        context.fill(x - 90, y, x + 90, y + 20, 0xFF151515); // Solid Row
        context.drawTextWithShadow(this.textRenderer, name, x - 85, y + 6, 0xFFFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "§7[TOGGLE]", x + 40, y + 6, 0xFFFFFFFF);
    }
}
