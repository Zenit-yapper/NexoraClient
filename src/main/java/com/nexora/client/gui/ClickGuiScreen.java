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
        // Opaque backgrounds prevent GPU rendering glitches on mobile.
        context.fill(0, 0, this.width, this.height, 0xFF101010);

        int centerX = this.width / 2;
        int centerY = this.height / 2;

        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA MENU", centerX, centerY - 60, 0xFFFFFFFF);

        // Simple categories without animations
        drawCategory(context, "Movement", centerX, centerY - 20);
        drawCategory(context, "Combat", centerX, centerY + 10);

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawCategory(DrawContext context, String name, int x, int y) {
        context.fill(x - 60, y, x + 60, y + 15, 0xFF202020);
        context.drawTextWithShadow(this.textRenderer, name, x - 55, y + 4, 0xFFBBBBBB);
    }
}
