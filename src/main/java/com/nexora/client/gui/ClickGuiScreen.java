package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora Dashboard")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // 1. SOLID background (0xFF means 100% solid - no blur possible)
        context.fill(0, 0, this.width, this.height, 0xFF050505);

        int cx = this.width / 2;
        int cy = this.height / 2;

        // 2. Main Border & Panel
        context.fill(cx - 112, cy - 92, cx + 112, cy + 92, 0xFFCC00FF); // Purple Glow
        context.fill(cx - 110, cy - 90, cx + 110, cy + 90, 0xFF0A0A0A); // Black Inner

        // 3. Header Text
        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA §f| §7PRIVATE BUILD", cx, cy - 80, 0xFFFFFFFF);

        // 4. Sharp Module List
        drawSharpRow(context, "Auto Sprint", cy - 50);
        drawSharpRow(context, "No Fall", cy - 25);
        drawSharpRow(context, "No Fire Overlay", cy);
        drawSharpRow(context, "Clear Water", cy + 25);
        drawSharpRow(context, "Reach Display", cy + 50);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawSharpRow(DrawContext context, String name, int y) {
        int cx = this.width / 2;
        context.fill(cx - 100, y, cx + 100, y + 20, 0xFF151515); // Solid row bg
        context.drawTextWithShadow(this.textRenderer, "§f" + name, cx - 92, y + 6, 0xFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "§a§lON", cx + 75, y + 6, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() { return false; }
}
