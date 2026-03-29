package com.nexora.client.gui;

import com.nexora.client.NexoraClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public static float reachDistance = 3.0f;
    public static float hitboxSize = 0.0f;
    public static boolean armorHUD = true;
    public static boolean showCoords = true;

    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, width, height, 0x88000000); // Transparent Background

        int x = width / 2 - 200, y = height / 2 - 120, w = 400, h = 240;
        context.fill(x, y, x + w, y + h, 0xAA050505); // Glass Body
        context.fill(x, y, x + w, y + 2, 0xFF00E5FF); // Cyan Top Accent

        // Sidebar
        context.fill(x, y, x + 90, y + h, 0x33000000);
        context.drawText(textRenderer, "§b§lNEXORA", x + 15, y + 20, -1, false);

        // Mod Cards
        drawMod(context, "Fullbright", x + 105, y + 40, NexoraClient.fullbright);
        drawMod(context, "Armor HUD", x + 260, y + 40, armorHUD);

        // Sliders
        drawSlider(context, "Reach", reachDistance, x + 105, y + 90, 3.0f, 6.0f);
        drawSlider(context, "Hitbox", hitboxSize, x + 105, y + 130, 0.0f, 2.0f);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void drawMod(DrawContext context, String name, int x, int y, boolean on) {
        context.fill(x, y, x + 140, y + 30, 0x22FFFFFF);
        context.drawText(textRenderer, name, x + 8, y + 10, -1, false);
        context.fill(x + 120, y + 8, x + 135, y + 22, on ? 0xFF00FF00 : 0xFF555555);
    }

    private void drawSlider(DrawContext context, String label, float val, int x, int y, float min, float max) {
        context.drawText(textRenderer, label + ": §b" + String.format("%.1f", val), x, y, -1, false);
        context.fill(x, y + 12, x + 280, y + 14, 0x44FFFFFF);
        int pos = (int) (x + ((val - min) / (max - min)) * 280);
        context.fill(pos - 2, y + 8, pos + 2, y + 18, 0xFF00E5FF);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int x = width / 2 - 200 + 105;
        int y = height / 2 - 120 + 40;

        if (mouseX >= x && mouseX <= x + 140 && mouseY >= y && mouseY <= y + 30) {
            NexoraClient.fullbright = !NexoraClient.fullbright;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override public boolean shouldPause() { return false; }
}
