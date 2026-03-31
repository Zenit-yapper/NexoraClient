package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora Dashboard")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Professional Dark Tint (75% Opacity)
        context.fill(0, 0, this.width, this.height, 0xBF000000);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Main Panel: Deep Charcoal with a Purple Glow Border
        context.fill(centerX - 122, centerY - 102, centerX + 122, centerY + 102, 0xFFCC00FF); // Purple Border
        context.fill(centerX - 120, centerY - 100, centerX + 120, centerY + 100, 0xFF0D0D0D); // Main Body

        // Header Section
        context.fill(centerX - 120, centerY - 100, centerX + 120, centerY - 75, 0xFF151515);
        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA §f| §7v1.0", centerX, centerY - 92, 0xFFFFFFFF);

        // Sidebar Divider
        context.fill(centerX - 120, centerY - 75, centerX - 60, centerY + 100, 0xFF111111);
        context.drawTextWithShadow(this.textRenderer, "§dCombat", centerX - 110, centerY - 60, 0xFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "Visual", centerX - 110, centerY - 40, 0xAAAAAA);
        context.drawTextWithShadow(this.textRenderer, "Player", centerX - 110, centerY - 20, 0xAAAAAA);

        // Module Rows (Professional spacing)
        drawModuleRow(context, "Auto Sprint", centerX - 55, centerY - 65, true);
        drawModuleRow(context, "No Fall", centerX - 55, centerY - 40, true);
        drawModuleRow(context, "Fast Place", centerX - 55, centerY - 15, true);
        drawModuleRow(context, "Motion Blur", centerX - 55, centerY + 10, true);
        drawModuleRow(context, "Reach Display", centerX - 55, centerY + 35, true);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void drawModuleRow(DrawContext context, String name, int x, int y, boolean active) {
        // High-end Row Styling
        context.fill(x, y, x + 170, y + 20, 0x1AFFFFFF);
        context.drawTextWithShadow(this.textRenderer, name, x + 8, y + 6, 0xFFFFFF);
        
        String statusText = active ? "§a[ON]" : "§c[OFF]";
        context.drawTextWithShadow(this.textRenderer, statusText, x + 162 - this.textRenderer.getWidth(statusText), y + 6, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() { return false; }
}
