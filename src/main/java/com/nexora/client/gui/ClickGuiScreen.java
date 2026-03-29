package com.nexora.client.gui;

import com.nexora.client.NexoraClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    // FIXED: Changed to float to match the Mixin return type
    public static float reachDistance = 3.0f; 
    public static float hitboxSize = 0.0f; 

    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        context.fill(50, 50, 190, 160, 0xCC000000); 
        context.fill(50, 50, 190, 65, 0xFF00E5FF); 
        context.drawText(textRenderer, "NEXORA SETTINGS", 55, 54, 0xFFFFFF, true);

        drawBtn(context, "Fullbright", 55, 75, NexoraClient.fullbright);
        context.drawText(textRenderer, "Reach: " + reachDistance, 55, 95, 0xFFFFFF, true);
        context.drawText(textRenderer, "Hitbox: " + hitboxSize, 55, 110, 0xFFFFFF, true);
        context.drawText(textRenderer, "§b[Click to Edit]", 55, 130, 0xFFFFFF, true);
    }

    private void drawBtn(DrawContext context, String name, int x, int y, boolean on) {
        context.drawText(textRenderer, name + ": " + (on ? "§aON" : "§cOFF"), x, y, 0xFFFFFF, true);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= 55 && mouseX <= 180) {
            if (mouseY >= 75 && mouseY <= 85) NexoraClient.fullbright = !NexoraClient.fullbright;

            // Adjust Reach (Reset on Right Click)
            if (mouseY >= 95 && mouseY <= 105) {
                if (button == 0) reachDistance += 0.5f;
                else reachDistance = 3.0f;
            }

            // Adjust Hitbox (Reset on Right Click)
            if (mouseY >= 110 && mouseY <= 120) {
                if (button == 0) hitboxSize += 0.1f;
                else hitboxSize = 0.0f;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override public boolean shouldPause() { return false; }
}
