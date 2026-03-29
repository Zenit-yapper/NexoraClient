package com.nexora.client.gui;

import com.nexora.client.NexoraClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    // Combat Stats
    public static float reachDistance = 3.0f;
    public static float hitboxSize = 0.0f;
    
    // HUD Toggles
    public static boolean toggleSprint = true;
    public static boolean showKeystrokes = true;
    public static boolean armorHUD = true;
    public static boolean showCPS = true;
    public static boolean showCoords = true;
    public static boolean smoothZoom = true;

    public ClickGuiScreen() { super(Text.literal("Nexora Professional")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Full screen transparent wash
        context.fill(0, 0, width, height, 0x66000000); 

        int x = width / 2 - 220;
        int y = height / 2 - 130;
        int w = 440;
        int h = 260;

        // Main Glass Panel
        context.fill(x, y, x + w, y + h, 0xAA050505); 
        context.fill(x, y, x + w, y + 2, 0xFF00E5FF); // Accent Top

        // Sidebar Categories
        context.fill(x, y, x + 100, y + h, 0x33000000);
        context.drawText(textRenderer, "§b§lNEXORA", x + 15, y + 20, -1, false);
        
        String[] tabs = {"General", "Combat", "Visuals", "HUD"};
        for(int i = 0; i < tabs.length; i++) {
            context.drawText(textRenderer, tabs[i], x + 15, y + 55 + (i * 20), -1, false);
        }

        // Mod Grid (Example Row 1)
        drawMod(context, "Sprint", x + 110, y + 40, toggleSprint);
        drawMod(context, "Keystrokes", x + 270, y + 40, showKeystrokes);
        
        // Mod Grid (Example Row 2)
        drawMod(context, "Armor HUD", x + 110, y + 80, armorHUD);
        drawMod(context, "Fullbright", x + 270, y + 80, NexoraClient.fullbright);

        // Combat Sliders
        drawSlider(context, "Reach", reachDistance, x + 110, y + 140, 3.0f, 6.0f);
        drawSlider(context, "Hitbox", hitboxSize, x + 110, y + 180, 0.0f, 2.0f);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawMod(DrawContext context, String name, int x, int y, boolean on) {
        context.fill(x, y, x + 150, y + 30, 0x22FFFFFF); 
        context.drawText(textRenderer, name, x + 8, y + 10, -1, false);
        context.fill(x + 130, y + 8, x + 145, y + 22, on ? 0xFF00FF00 : 0xFF555555);
    }

    private void drawSlider(DrawContext context, String label, float val, int x, int y, float min, float max) {
        context.drawText(textRenderer, label + ": §b" + String.format("%.1f", val), x, y, -1, false);
        context.fill(x, y + 12, x + 300, y + 14, 0x44FFFFFF);
        int pos = (int) (x + ((val - min) / (max - min)) * 300);
        context.fill(pos - 2, y + 8, pos + 2, y + 18, 0xFF00E5FF);
    }
}
