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
        // Dark overlay for visibility
        context.fill(0, 0, this.width, this.height, 0xCC000000);

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        long time = System.currentTimeMillis();

        // Saturn Rings Animation
        renderSaturnRings(context, centerX, centerY - 80, time);

        // Main Panel (Adjusted size)
        context.fill(centerX - 110, centerY - 90, centerX + 110, centerY + 90, 0xFF101010); 
        context.fill(centerX - 110, centerY - 90, centerX + 110, centerY - 88, 0xFFCC00FF); 

        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", centerX, centerY - 78, 0xFFCC00FF);

        // Modules - Purely the essentials to prevent freezing
        drawModule(context, "Auto Sprint", centerX - 100, centerY - 55, true);
        drawModule(context, "No Slowdown", centerX - 100, centerY - 30, true);
        drawModule(context, "Fast Place", centerX - 100, centerY - 5, true);
        
        // The Secret Aimbot
        drawModule(context, "Silent Aim", centerX - 100, centerY + 25, true);
        
        drawModule(context, "Motion Blur", centerX - 100, centerY + 50, true);
        drawModule(context, "Reach Display", centerX - 100, centerY + 75, true);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void renderSaturnRings(DrawContext context, int centerX, int centerY, long time) {
        for (int i = 0; i < 10; i++) {
            double angle = (time / 1200.0 + (i * (Math.PI * 2 / 10)));
            int x = centerX + (int) (Math.cos(angle) * 70);
            int y = centerY + (int) (Math.sin(angle) * 15);
            context.fill(x, y, x + 2, y + 2, 0xFFCC00FF); 
        }
    }

    private void drawModule(DrawContext context, String name, int x, int y, boolean enabled) {
        context.fill(x, y, x + 200, y + 20, 0x20FFFFFF); 
        context.drawTextWithShadow(this.textRenderer, name, x + 10, y + 6, 0xFFFFFF);
        String status = enabled ? "ON" : "OFF";
        context.drawTextWithShadow(this.textRenderer, status, x + 175, y + 6, enabled ? 0xFF55FF55 : 0xFFFF5555);
    }

    @Override
    public boolean shouldPause() { return false; }
}
