package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, this.width, this.height, 0xCC000000);
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        
        // Saturn Title
        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA CLIENT", centerX, centerY - 80, 0xFFFFFFFF);
        context.fill(centerX - 50, centerY - 70, centerX + 50, centerY - 69, 0xFFCC00FF);

        // Module List
        drawRow(context, "Auto Sprint", centerY - 50);
        drawRow(context, "No Fall", centerY - 25);
        drawRow(context, "Fast Place", centerY);
        drawRow(context, "No Slowdown", centerY + 25);
        drawRow(context, "Fast Stop", centerY + 50);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void drawRow(DrawContext context, String name, int y) {
        int centerX = this.width / 2;
        context.fill(centerX - 100, y, centerX + 100, y + 20, 0x30FFFFFF);
        context.drawTextWithShadow(this.textRenderer, name, centerX - 90, y + 6, 0xFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "§aON", centerX + 70, y + 6, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() { return false; }
}
