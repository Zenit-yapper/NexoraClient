package com.nexora.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { 
        super(Text.literal("Nexora GUI")); 
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Use a solid dark grey hex color (0xFF101010) to block out the world.
        // This ensures NO blur or transparency glitches occur.
        context.fill(0, 0, this.width, this.height, 0xFF101010);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Static Title - No animations or pulsing to save CPU cycles.
        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA UTILITY", centerX, centerY - 80, 0xFFFFFFFF);

        // Simple Module Categories
        drawCategory(context, "Movement", centerX, centerY - 40);
        drawCategory(context, "Combat", centerX, centerY - 10);
        drawCategory(context, "Visual", centerX, centerY + 20);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawCategory(DrawContext context, String name, int x, int y) {
        // Solid boxes with no border effects.
        context.fill(x - 80, y, x + 80, y + 20, 0xFF202020);
        context.drawTextWithShadow(this.textRenderer, name, x - 75, y + 6, 0xFFBBBBBB);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
