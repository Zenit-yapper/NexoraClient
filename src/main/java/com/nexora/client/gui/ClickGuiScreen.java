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
        // 0xFF101010 is a solid, non-transparent dark grey.
        // Using a solid color prevents the GPU from trying to render blur shaders.
        context.fill(0, 0, this.width, this.height, 0xFF101010);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA UTILITY", centerX, centerY - 80, 0xFFFFFFFF);

        // Simple, solid buttons
        drawButton(context, "Combat", centerX, centerY - 40);
        drawButton(context, "Movement", centerX, centerY - 10);
        drawButton(context, "Visuals", centerX, centerY + 20);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawButton(DrawContext context, String name, int x, int y) {
        context.fill(x - 70, y, x + 70, y + 20, 0xFF252525);
        context.drawTextWithShadow(this.textRenderer, name, x - 65, y + 6, 0xFFDDDDDD);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
