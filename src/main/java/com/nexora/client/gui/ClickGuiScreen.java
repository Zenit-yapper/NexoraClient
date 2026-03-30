package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Nexora ClickGUI"));
    }

    @Override
    protected void init() {
        // This is where you would add actual buttons later
        super.init();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // 1. Draw the "Feather" style blur background
        // We use a dark semi-transparent overlay to simulate the depth
        context.fill(0, 0, this.width, this.height, 0x90000000);

        // 2. Draw the Main Container (The Glass Box)
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        
        // Background of the menu
        drawStyledBox(context, centerX - 100, centerY - 80, centerX + 100, centerY + 80);

        // 3. Draw Title with Glow
        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", centerX, centerY - 70, 0xFF55FF);
        
        // 4. Draw Modules (Example: Auto Sprint)
        drawModuleButton(context, "Auto Sprint", centerX - 90, centerY - 50, true);
        drawModuleButton(context, "No Hurtcam", centerX - 90, centerY - 25, true);
        drawModuleButton(context, "Fullbright", centerX - 90, centerY, false);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawStyledBox(DrawContext context, int x1, int y1, int x2, int y2) {
        // Outline
        context.fill(x1 - 1, y1 - 1, x2 + 1, y2 + 1, 0xFF333333); 
        // Inner Glass
        context.fill(x1, y1, x2, y2, 0x951A1A1A); 
    }

    private void drawModuleButton(DrawContext context, String name, int x, int y, boolean enabled) {
        int width = 180;
        int height = 20;
        int color = enabled ? 0xAA00FF00 : 0xAAFF0000; // Green if ON, Red if OFF
        
        // Button Background
        context.fill(x, y, x + width, y + height, 0x50FFFFFF);
        // Indicator Light
        context.fill(x + width - 25, y + 4, x + width - 5, y + height - 4, color);
        // Module Name
        context.drawTextWithShadow(this.textRenderer, name, x + 10, y + 6, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
