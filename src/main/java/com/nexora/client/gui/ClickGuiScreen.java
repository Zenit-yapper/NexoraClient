package com.nexora.client.gui;

import com.nexora.client.NexoraClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        // GUI Box
        context.fill(50, 50, 170, 130, 0xCC000000); 
        context.fill(50, 50, 170, 65, 0xFF00E5FF); // Header
        context.drawText(textRenderer, "NEXORA MODS", 55, 54, 0xFFFFFF, true);

        // Module Buttons
        drawBtn(context, "Fullbright", 55, 70, NexoraClient.fullbright);
        drawBtn(context, "FPS Boost", 55, 85, NexoraClient.fastRender);
        drawBtn(context, "Hitboxes (WIP)", 55, 100, false);
    }

    private void drawBtn(DrawContext context, String name, int x, int y, boolean on) {
        context.drawText(textRenderer, name + ": " + (on ? "§aON" : "§cOFF"), x, y, 0xFFFFFF, true);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // Toggle Fullbright (Simple coordinate check)
        if (mouseX >= 55 && mouseX <= 150) {
            if (mouseY >= 70 && mouseY <= 80) NexoraClient.fullbright = !NexoraClient.fullbright;
            if (mouseY >= 85 && mouseY <= 95) NexoraClient.fastRender = !NexoraClient.fastRender;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override public boolean shouldPause() { return false; }
}
