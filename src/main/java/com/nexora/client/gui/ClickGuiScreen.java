package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Nexora ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Semi-transparent overlay to help see the GUI over the blur
        context.fill(0, 0, this.width, this.height, 0x80000000);

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        long time = System.currentTimeMillis();

        // Animated Saturn Rings around the title
        renderSaturnRings(context, centerX, centerY - 72, time);

        // Main GUI Panel
        drawStyledBox(context, centerX - 110, centerY - 85, centerX + 110, centerY + 95);

        // Client Title
        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", centerX, centerY - 72, 0xFFCC00FF);

        // Render Module Buttons
        drawModule(context, "Auto Sprint", centerX - 100, centerY - 50, true);
        drawModule(context, "No Hurtcam", centerX - 100, centerY - 25, true);
        drawModule(context, "Fullbright", centerX - 100, centerY, false);
        drawModule(context, "Motion Blur", centerX - 100, centerY + 25, true);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void renderSaturnRings(DrawContext context, int centerX, int centerY, long time) {
        int stars = 12;
        float rx = 70f;
        float ry = 15f;

        for (int i = 0; i < stars; i++) {
            double angle = (time / 1000.0 * 1.5 + (i * (Math.PI * 2 / stars)));
            int x = centerX + (int) (Math.cos(angle) * rx);
            int y = centerY + (int) (Math.sin(angle) * ry);
            context.fill(x, y, x + 2, y + 2, 0xFFCC00FF); // Purple stars
            
            // Second outer ring
            int x2 = centerX + (int) (Math.cos(-angle) * (rx + 15));
            int y2 = centerY + (int) (Math.sin(-angle) * (ry + 8));
            context.fill(x2, y2, x2 + 1, y2 + 1, 0xFFFFFFFF); // White stars
        }
    }

    private void drawStyledBox(DrawContext context, int x1, int y1, int x2, int y2) {
        context.fill(x1, y1, x2, y2, 0xC0101010); // Darker box for better visibility
        context.fill(x1, y1, x2, y1 + 1, 0xFFCC00FF); // Purple top border
    }

    private void drawModule(DrawContext context, String name, int x, int y, boolean enabled) {
        context.fill(x, y, x + 200, y + 20, 0x40FFFFFF); 
        context.drawTextWithShadow(this.textRenderer, name, x + 10, y + 6, 0xFFFFFF);
        String status = enabled ? "ON" : "OFF";
        int color = enabled ? 0xFF55FF55 : 0xFFFF5555;
        context.drawTextWithShadow(this.textRenderer, status, x + 175, y + 6, color);
    }

    @Override
    public boolean shouldPause() { return false; }
}
