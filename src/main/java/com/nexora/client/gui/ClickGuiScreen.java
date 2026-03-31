package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Nexora ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // 1. Background Overlay
        context.fill(0, 0, this.width, this.height, 0x70000000);

        int centerX = this.width / 2;
        int centerY = this.height / 2;
        long time = System.currentTimeMillis();

        // 2. THE ANIMATED RINGS (Saturn Effect)
        renderSaturnRings(context, centerX, centerY - 72, time);

        // 3. Main Panel
        drawStyledBox(context, centerX - 110, centerY - 80, centerX + 110, centerY + 90);

        // 4. Title
        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", centerX, centerY - 72, 0xFF55FF);

        // 5. Render Modules
        drawModule(context, "Auto Sprint", centerX - 100, centerY - 50, true);
        drawModule(context, "No Hurtcam", centerX - 100, centerY - 25, true);
        drawModule(context, "Fullbright", centerX - 100, centerY, false);
        drawModule(context, "Motion Blur", centerX - 100, centerY + 25, true);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void renderSaturnRings(DrawContext context, int centerX, int centerY, long time) {
        int particleCount = 12; // Number of stars in the ring
        float radiusX = 60f;    // Width of the ring
        float radiusY = 15f;    // Height (tilt) of the ring

        for (int i = 0; i < particleCount; i++) {
            // Calculate orbit position using time for smooth movement
            double angle = (time / 1000.0 * 2.0 + (i * (Math.PI * 2 / particleCount)));
            
            int x = centerX + (int) (Math.cos(angle) * radiusX);
            int y = centerY + (int) (Math.sin(angle) * radiusY);

            // Draw a glowing "star" particle
            // We use a small 2x2 square to look like a star
            context.fill(x, y, x + 2, y + 2, 0xCCFF55FF); 
            
            // Add a second
        
