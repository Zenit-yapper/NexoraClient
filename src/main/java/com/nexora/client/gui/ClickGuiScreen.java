package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.awt.Color;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Nexora ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // 1. Darken the background (The BlurMixin handles the actual blur)
        context.fill(0, 0, this.width, this.height, 0x70000000);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // 2. Draw Main Panel (The "Feather" Glass Box)
        // Main Background
        drawRoundedRect(context, centerX - 110, centerY - 80, centerX + 110, centerY + 90, 0x90101010);
        // Thin Outline for that "Pro" look
        drawOutline(context, centerX - 110, centerY - 80, centerX + 110, centerY + 90, 0xFF444444);

        // 3. Title with Pink/Purple Glow (Like your reference)
        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", centerX, centerY - 72, 0xFF55FF);

        // 4. Render Module Buttons (Examples)
        drawModule(context, "Auto Sprint", centerX - 100, centerY - 50, true);
        drawModule(context, "No Hurtcam", centerX - 100, centerY - 25, true);
        drawModule(context, "Fullbright", centerX - 100, centerY, false);
        drawModule(context, "Motion Blur", centerX - 100, centerY + 25, true);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void drawModule(DrawContext context, String name, int x, int y, boolean enabled) {
        int width = 200;
        int height = 20;
        
        // Button Background (Semi-transparent white/grey)
        context.fill(x, y, x + width, y + height, 0x30FFFFFF);
        
        // Module Name
        context.drawTextWithShadow(this.textRenderer, name, x + 10, y + 6, 0xFFFFFF);
        
        // Toggle Switch (Right Side)
        String status = enabled ? "ON" : "OFF";
        int statusColor = enabled ? 0xFF55FF55 : 0xFFFF5555;
        context.drawTextWithShadow(this.textRenderer, status, x + width - 30, y + 6, statusColor);
    }

    // Helper methods for professional styling
    private void drawRoundedRect(DrawContext context, int x1, int y1, int x2, int y2, int color) {
        context.fill(x1, y1, x2, y2, color);
    }

    private void drawOutline(DrawContext context, int x1, int y1, int x2, int y2, int color) {
        context.fill(x1, y1, x2, y1 + 1, color); // Top
        context.fill(x1, y2 - 1, x2, y2, color); // Bottom
        context.fill(x1, y1, x1 + 1, y2, color); // Left
        context.fill(x2 - 1, y1, x2, y2, color); // Right
    }

    @Override
    public boolean shouldPause() {
        return false; // Allows the game to keep running in the background
    }
}
