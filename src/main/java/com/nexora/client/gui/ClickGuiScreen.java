package com.nexora.client.gui;

import com.nexora.client.NexoraClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    // Shared Global Settings
    public static float reachDistance = 3.0f;
    public static float hitboxSize = 0.0f;
    public static boolean toggleSprint = true;
    public static boolean showKeystrokes = true;
    public static boolean armorHUD = true;

    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        // 1. Main Background Panel
        int x = width / 2 - 200, y = height / 2 - 120, w = 400, h = 240;
        context.fill(x, y, x + w, y + h, 0xCC101010); // Main Dark Body
        context.fill(x, y, x + 100, y + h, 0xFF0D0D0D); // Sidebar

        // 2. Sidebar Tabs
        drawTab(context, "ALL", x + 10, y + 40, true);
        drawTab(context, "HUD", x + 10, y + 60, false);
        drawTab(context, "COMBAT", x + 10, y + 80, false);

        // 3. Mod Grid (Right Side)
        drawModCard(context, "ToggleSprint", x + 110, y + 30, toggleSprint);
        drawModCard(context, "Keystrokes", x + 250, y + 30, showKeystrokes);
        drawModCard(context, "Armor HUD", x + 110, y + 70, armorHUD);
        drawModCard(context, "Fullbright", x + 250, y + 70, NexoraClient.fullbright);
    }

    private void drawTab(DrawContext context, String name, int x, int y, boolean selected) {
        context.drawText(textRenderer, name, x, y, selected ? 0xFF00E5FF : 0xFF777777, false);
    }

    private void drawModCard(DrawContext context, String name, int x, int y, boolean enabled) {
        context.fill(x, y, x + 130, y + 35, 0xFF1A1A1A); // Card
        context.drawText(textRenderer, name, x + 10, y + 12, -1, false);
        context.fill(x + 110, y + 10, x + 125, y + 25, enabled ? 0xFF00FF00 : 0xFF444444); // Toggle
    }

    @Override public boolean shouldPause() { return false; }
}
