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
        // 1. Darken background
        context.fill(0, 0, this.width, this.height, 0x70000000);

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        long time = System.currentTimeMillis();

        // 2. ANIMATED SATURN RINGS
        renderSaturnRings(context, centerX, centerY - 72, time);

        // 3. MAIN PANEL
        drawStyledBox(context, centerX - 110, centerY - 80, centerX + 110, centerY + 90);

        // 4. CLIENT TITLE
        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", centerX, centerY - 72, 0xFF55FF);

        // 5. MODULE LIST
        drawModule(context, "Auto Sprint", centerX - 100, centerY - 50, true);
        drawModule(context, "No Hurtcam", centerX - 100, centerY - 25, true);
        drawModule(context, "Fullbright", centerX - 100, centerY, false);
        drawModule(context, "Motion Blur", centerX - 100, centerY + 25, true);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void renderSaturnRings(DrawContext context, int centerX, int centerY, long time) {
        int particleCount = 10; 
        float radiusX = 65f;
        float radiusY = 12f;

        for (int i = 0; i < particleCount; i++) {
            double angle = (time / 800.0 + (i * (Math.PI * 2 / particleCount)));
            
            int x = centerX + (int) (Math.cos(angle) * radiusX);
            int y = centerY + (int) (Math.sin(angle) * radiusY);

            // Draw glowing star
            context.fill(x, y, x + 2, y + 2, 0xCCFF55FF); 
            
            // Outer Ring
            int x2 = centerX + (int) (Math.cos(-angle) * (radiusX + 15));
            int y2 = centerY + (int) (Math.sin(-angle) * (radiusY + 5));
            context.fill(x2, y2, x2 + 1, y2 + 1, 0x99FFFFFF);
        }
    }

    private void drawStyledBox(DrawContext context, int x1, int y1, int x2, int y2) {
        context.fill(x1, y1, x2, y2, 0x90101010); 
        context.fill(x1, y1, x2, y1 + 1, 0xFF444444); 
    }

    private void drawModule(DrawContext context, String name, int x, int y, boolean enabled) {
        context.fill(x, y, x + 200, y + 20, 0x30FFFFFF);
        context.drawTextWithShadow(this.textRenderer, name, x + 10, y + 6, 0xFFFFFF);
        String status = enabled ? "ON" : "OFF";
        int color = enabled ? 0xFF55FF55 : 0xFFFF5555;
        context.drawTextWithShadow(this.textRenderer, status, x + 175, y + 6, color);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
