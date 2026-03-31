package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import java.awt.Color;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Nexora Dashboard"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Professional darkened background (90% opacity)
        context.fill(0, 0, this.width, this.height, 0xE6000000);

        int x = this.width / 2 - 120;
        int y = this.height / 2 - 90;
        int width = 240;
        int height = 180;

        // 1. Main Frame Shadow/Glow
        context.fill(x - 1, y - 1, x + width + 1, y + height + 1, 0xFF333333); 
        
        // 2. Main Body
        context.fill(x, y, x + width, y + height, 0xFF0F0F0F);

        // 3. Header with Professional Gradient Logic
        renderHeader(context, x, y, width);

        // 4. Category Sidebar (Static Visual)
        context.fill(x, y + 22, x + 60, y + height, 0xFF151515);
        context.drawTextWithShadow(this.textRenderer, "COMBAT", x + 10, y + 35, 0xBBBBBB);
        context.drawTextWithShadow(this.textRenderer, "VISUAL", x + 10, y + 55, 0xFFCC00FF); // Active category
        context.drawTextWithShadow(this.textRenderer, "PLAYER", x + 10, y + 75, 0xBBBBBB);

        // 5. Module List (High-End Layout)
        int slotY = y + 30;
        drawModule(context, "Motion Blur", x + 70, slotY, true, mouseX, mouseY);
        drawModule(context, "Auto Sprint", x + 70, slotY + 25, true, mouseX, mouseY);
        drawModule(context, "No Fall", x + 70, slotY + 50, true, mouseX, mouseY);
        drawModule(context, "Fast Place", x + 70, slotY + 75, true, mouseX, mouseY);
        drawModule(context, "Reach Display", x + 70, slotY + 100, true, mouseX, mouseY);

        super.render(context, mouseX, mouseY, delta);
    }

    private void renderHeader(DrawContext context, int x, int y, int width) {
        // Purple Accent bar
        context.fill(x, y, x + width, y + 22, 0xFF1A1A1A);
        context.fill(x, y + 20, x + width, y + 22, 0xFFCC00FF);
        
        context.drawTextWithShadow(this.textRenderer, "NEXORA", x + 10, y + 6, 0xFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "v1.0.0-STABLE", x + width - 75, y + 6, 0x777777);
    }

    private void drawModule(DrawContext context, String name, int x, int y, boolean enabled, int mx, int my) {
        boolean hovering = (mx >= x && mx <= x + 160 && my >= y && my <= y + 20);
        
        // Background - highlight if hovering
        int bgColor = hovering ? 0x40FFFFFF : 0x10FFFFFF;
        context.fill(x, y, x + 160, y + 20, bgColor);
        
        // Status indicator dot
        int dotColor = enabled ? 0xFFCC00FF : 0xFF444444;
        context.fill(x + 5, y + 8, x + 9, y + 12, dotColor);

        context.drawTextWithShadow(this.textRenderer, name, x + 15, y + 6, 0xFFFFFF);
        
        if (enabled) {
            context.drawTextWithShadow(this.textRenderer, "ACTIVE", x + 120, y + 6, 0x55FF55);
        }
    }

    @Override
    public boolean shouldPause() { return false; }
}
