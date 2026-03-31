package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // 0xFF000000 = SOLID BLACK. This removes all background smearing.
        context.fill(0, 0, this.width, this.height, 0xFF000000);

        int cx = this.width / 2;
        int cy = this.height / 2;

        // Main Panel with a Solid Purple Border (No transparency = No blur)
        context.fill(cx - 102, cy - 82, cx + 102, cy + 82, 0xFFCC00FF); 
        context.fill(cx - 100, cy - 80, cx + 100, cy + 80, 0xFF0D0D0D); 

        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA §f| §7V1.0 STABLE", cx, cy - 72, 0xFFFFFFFF);

        // Solid, sharp rows
        drawClearRow(context, "Auto Sprint", cy - 45);
        drawClearRow(context, "No Fall", cy - 20);
        drawClearRow(context, "Clear Water", cy + 5);
        drawClearRow(context, "Reach Display", cy + 30);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void drawClearRow(DrawContext context, String name, int y) {
        int cx = this.width / 2;
        // Solid Dark Grey Row
        context.fill(cx - 90, y, cx + 90, y + 18, 0xFF1A1A1A);
        context.drawTextWithShadow(this.textRenderer, "§f" + name, cx - 84, y + 5, 0xFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "§a§lON", cx + 72, y + 5, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() { return false; }
}
