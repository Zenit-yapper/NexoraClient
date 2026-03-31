package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // High-contrast background (90% Black)
        context.fill(0, 0, this.width, this.height, 0xE6050505);

        int cx = this.width / 2;
        int cy = this.height / 2;

        // Dashboard Frame
        context.fill(cx - 110, cy - 80, cx + 110, cy + 90, 0xFF0F0F0F); // Body
        context.fill(cx - 110, cy - 80, cx + 110, cy - 78, 0xFFCC00FF); // Purple Accent

        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA §f| §7STABLE", cx, cy - 70, 0xFFFFFFFF);

        // List of Safe Mods
        drawCleanRow(context, "Auto Sprint", cy - 45);
        drawCleanRow(context, "No Fall", cy - 20);
        drawCleanRow(context, "No Overlay", cy + 5);
        drawCleanRow(context, "Clear Water", cy + 30);
        drawCleanRow(context, "Reach Display", cy + 55);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawCleanRow(DrawContext context, String name, int y) {
        int cx = this.width / 2;
        context.fill(cx - 100, y, cx + 100, y + 20, 0x1AFFFFFF); // Subtle row
        context.drawTextWithShadow(this.textRenderer, "§f" + name, cx - 94, y + 6, 0xFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "§dON", cx + 78, y + 6, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() { return false; }
}
