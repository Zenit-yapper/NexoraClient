package com.nexora.client.gui;

import com.nexora.client.NexoraClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    // These fix the build errors in your Hitbox and Reach Mixins
    public static double hitboxSize = 0.5;
    public static float reachDistance = 3.0f;

    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        // Main Box
        context.fill(50, 50, 180, 150, 0xCC000000); 
        context.fill(50, 50, 180, 65, 0xFF00E5FF); 
        context.drawText(textRenderer, "NEXORA CONTROLS", 55, 54, 0xFFFFFF, true);

        // Buttons
        drawBtn(context, "Fullbright", 55, 75, NexoraClient.fullbright);
        drawBtn(context, "FPS Boost", 55, 95, NexoraClient.fastRender);
        context.drawText(textRenderer, "Hitbox: " + hitboxSize, 55, 115, 0xFFFFFF, true);
    }

    private void drawBtn(DrawContext context, String name, int x, int y, boolean on) {
        context.drawText(textRenderer, name + ": " + (on ? "§aON" : "§cOFF"), x, y, 0xFFFFFF, true);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= 55 && mouseX <= 150) {
            if (mouseY >= 75 && mouseY <= 85) NexoraClient.fullbright = !NexoraClient.fullbright;
            if (mouseY >= 95 && mouseY <= 105) NexoraClient.fastRender = !NexoraClient.fastRender;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override public boolean shouldPause() { return false; }
}
