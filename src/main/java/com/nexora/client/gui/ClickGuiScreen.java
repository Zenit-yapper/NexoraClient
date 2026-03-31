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
        // Much darker overlay to fix the "too blurry" issue
        context.fill(0, 0, this.width, this.height, 0xCC000000);

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        long time = System.currentTimeMillis();

        // Saturn Rings (Spinning Stars)
        renderSaturnRings(context, centerX, centerY - 72, time);

        // Main Box
        context.fill(centerX - 110, centerY - 85, centerX + 110, centerY + 95, 0xFF101010); 
        context.fill(centerX - 110, centerY - 85, centerX + 110, centerY - 83, 0xFFCC00FF); 

        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", centerX, centerY - 72, 0xFFCC00FF);

        drawModule(context, "Auto Sprint", centerX - 100, centerY - 50, true);
        drawModule(context, "No Hurtcam", centerX - 100, centerY - 25, true);
        drawModule(context, "Fullbright", centerX - 100, centerY, false);
        drawModule(context, "Motion Blur", centerX - 100, centerY + 25, true);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void renderSaturnRings(DrawContext context, int centerX, int centerY, long time) {
        int stars = 10;
        for (int i = 0; i < stars; i++) {
            double angle = (time / 1000.0 + (i * (Math.PI * 2 / stars)));
            int x = centerX + (int) (Math.cos(angle) * 72);
            int y = centerY + (int) (Math.sin(angle) * 16);
            context.fill(x, y, x + 2, y + 2, 0xFFCC00FF); 
        }
    }

    private void drawModule(DrawContext context, String name, int x, int y, boolean enabled) {
        context.fill(x, y, x + 200, y + 20, 0x25FFFFFF); 
        context.drawTextWithShadow(this.textRenderer, name, x + 10, y + 6, 0xFFFFFF);
        String status = enabled ? "ON" : "OFF";
        context.drawTextWithShadow(this.textRenderer, status, x + 175, y + 6, enabled ? 0xFF55FF55 : 0xFFFF5555);
    }

    @Override
    public boolean shouldPause() { return false; }
}
