package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Nexora ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // 1. Draw a dark transparent background
        this.renderBackground(context, mouseX, mouseY, delta);

        int startX = 50;
        int startY = 50;
        int width = 120;

        // 2. Draw Category Header (Combat)
        context.fill(startX, startY, startX + width, startY + 15, 0xFF00E5FF); // Aqua Header
        context.drawText(this.textRenderer, "COMBAT", startX + 5, startY + 4, 0xFFFFFF, true);

        // 3. Draw Module List Box
        context.fill(startX, startY + 15, startX + width, startY + 80, 0xAA000000); // Semi-transparent black

        // 4. Draw Modules (Example status)
        drawModule(context, "Hitboxes", startX + 5, startY + 22, false);
        drawModule(context, "Reach", startX + 5, startY + 37, false);
        drawModule(context, "Fullbright", startX + 5, startY + 52, true);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawModule(DrawContext context, String name, int x, int y, boolean enabled) {
        int color = enabled ? 0xFF00FF00 : 0xFFFFFFFF; // Green if on, White if off
        context.drawText(this.textRenderer, name, x, y, color, true);
    }

    @Override
    public boolean shouldPause() {
        return false; // Don't pause the game when menu is open
    }
}
