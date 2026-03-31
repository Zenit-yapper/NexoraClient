package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Nexora ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, this.width, this.height, 0xCC000000);

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        long time = System.currentTimeMillis();

        renderSaturnRings(context, centerX, centerY - 85, time);

        // Main Panel
        context.fill(centerX - 110, centerY - 95, centerX + 110, centerY + 100, 0xFF101010); 
        context.fill(centerX - 110, centerY - 95, centerX + 110, centerY - 93, 0xFFCC00FF); 

        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", centerX, centerY - 82, 0xFFCC00FF);

        // Standard Modules
        drawModule(context, "Auto Sprint", centerX - 100, centerY - 60, true);
        drawModule(context, "No Slowdown", centerX - 100, centerY - 35, true);
        drawModule(context, "Fast Place", centerX - 100, centerY - 10, true);
        
        // Secret Module
        drawModule(context, "Silent Aim", centerX - 100, centerY + 20, true);
        
        // Visuals
        drawModule(context, "Motion Blur", centerX - 100, centerY + 45, true);
        drawModule(context, "Reach Display", centerX - 100, centerY + 70, true);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void renderSaturnRings(DrawContext context, int centerX, int centerY, long time) {
        int stars = 12;
        for (int i = 0; i < stars; i++) {
            double angle = (time / 1100.0 + (i * (Math.PI * 2 / stars)));
            int x = centerX + (int) (Math.cos(angle) * 75);
            int y = centerY + (int) (Math.sin(angle) * 18);
            context.fill(x, y, x + 2, y + 2, 0xFFCC00FF); 
            
            int x2 = centerX + (int) (Math.cos(-angle) * 90);
            int y2 = centerY + (int) (Math.sin(-angle) * 26);
            context.fill(x2, y2, x2 + 1, y2 + 1, 0xFFFFFFFF);
        }
    }

    private void drawModule(DrawContext context, String name, int x, int y, boolean enabled) {
        context.fill(x, y, x + 200, y + 22, 0x25FFFFFF); 
        context.drawTextWithShadow(this.textRenderer, name, x + 10, y + 7, 0xFFFFFF);
        String status = enabled ? "ON" : "OFF";
        context.drawTextWithShadow(this.textRenderer, status, x + 175, y + 7, enabled ? 0xFF55FF55 : 0xFFFF5555);
    }

    @Override
    public boolean shouldPause() { return false; }
}
