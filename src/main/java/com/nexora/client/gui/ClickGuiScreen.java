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
        // Dark background to fix the visibility issues from earlier builds
        context.fill(0, 0, this.width, this.height, 0xCC000000);

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        long time = System.currentTimeMillis();

        // 1. Animated Saturn Rings (Purple/White Stars)
        renderSaturnRings(context, centerX, centerY - 95, time);

        // 2. Main GUI Panel (Made taller for the new mods)
        context.fill(centerX - 110, centerY - 110, centerX + 110, centerY + 120, 0xFF101010); 
        context.fill(centerX - 110, centerY - 110, centerX + 110, centerY - 108, 0xFFCC00FF); 

        // 3. Title
        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", centerX, centerY - 95, 0xFFCC00FF);

        // 4. Stable PvP Modules
        drawModule(context, "Auto Sprint", centerX - 100, centerY - 75, true);
        drawModule(context, "No Slowdown", centerX - 100, centerY - 50, true);
        drawModule(context, "Fast Place", centerX - 100, centerY - 25, true);
        
        // 5. Secret PvP Modules
        drawModule(context, "Silent Aim", centerX - 100, centerY + 10, true);
        drawModule(context, "Combo Counter", centerX - 100, centerY + 35, true);
        
        // 6. Visual Modules
        drawModule(context, "Motion Blur", centerX - 100, centerY + 65, true);
        drawModule(context, "Reach Display", centerX - 100, centerY + 90, true);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void renderSaturnRings(DrawContext context, int centerX, int centerY, long time) {
        int stars = 12;
        float rx = 75f;
        float ry = 18f;

        for (int i = 0; i < stars; i++) {
            double angle = (time / 1100.0 + (i * (Math.PI * 2 / stars)));
            int x = centerX + (int) (Math.cos(angle) * rx);
            int y = centerY + (int) (Math.sin(angle) * ry);
            context.fill(x, y, x + 2, y + 2, 0xFFCC00FF); 
            
            // Outer Orbit
            int x2 = centerX + (int) (Math.cos(-angle) * (rx + 15));
            int y2 = centerY + (int) (Math.sin(-angle) * (ry + 8));
            context.fill(x2, y2, x2 + 1, y2 + 1, 0xFFFFFFFF);
        }
    }

    private void drawModule(DrawContext context, String name, int x, int y, boolean enabled) {
        // High-contrast rows for MT Manager builds
        context.fill(x, y, x + 200, y + 22, 0x25FFFFFF); 
        context.drawTextWithShadow(this.textRenderer, name, x + 10, y + 7, 0xFFFFFF);
        
        String status = enabled ? "ON" : "OFF";
        int color = enabled ? 0xFF55FF55 : 0xFFFF5555;
        context.drawTextWithShadow(this.textRenderer, status, x + 175, y + 7, color);
    }

    @Override
    public boolean shouldPause() { return false; }
}
