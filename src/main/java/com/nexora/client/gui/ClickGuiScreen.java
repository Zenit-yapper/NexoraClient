package com.nexora.client.gui;

import com.nexora.client.NexoraClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    // Standard Minecraft Defaults
    public static float reachDistance = 3.0f; 
    public static double hitboxSize = 0.0; 

    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        context.fill(50, 50, 190, 160, 0xCC000000); 
        context.fill(50, 50, 190, 65, 0xFF00E5FF); 
        context.drawText(textRenderer, "NEXORA SETTINGS", 55, 54, 0xFFFFFF, true);

        // Display current values
        drawBtn(context, "Fullbright", 55, 75, NexoraClient.fullbright);
        context.drawText(textRenderer, "Reach: " + reachDistance, 55, 95, 0xFFFFFF, true);
        context.drawText(textRenderer, "Hitbox: " + hitboxSize, 55, 110, 0xFFFFFF, true);
        context.drawText(textRenderer, "§7(Click to add +0.5)", 55, 125, 0xFFFFFF, true);
        context.drawText(textRenderer, "§7(Right-Click to reset)", 55, 135, 0xFFFFFF, true);
    }

    private void drawBtn(DrawContext context, String name, int x, int y, boolean on) {
        context.drawText(textRenderer, name + ": " + (on ? "§aON" : "§cOFF"), x, y, 0xFFFFFF, true);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= 55 && mouseX <= 180) {
            // Toggle Fullbright
            if (mouseY >= 75 && mouseY <= 85) NexoraClient.fullbright = !NexoraClient.fullbright;

            // Adjust Reach (Left click to add, Right click to reset)
            if (mouseY >= 95 && mouseY <= 105) {
                if (button == 0) reachDistance += 0.5f;
                else reachDistance = 3.0f;
            }

            // Adjust Hitbox
            if (mouseY >= 110 && mouseY <= 120) {
                if (button == 0) hitboxSize += 0.1;
                else hitboxSize = 0.0;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override public boolean shouldPause() { return false; }
}
