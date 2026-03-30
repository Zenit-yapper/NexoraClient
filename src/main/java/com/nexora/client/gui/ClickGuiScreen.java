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
        // Draw a dark background
        this.renderBackground(context, mouseX, mouseY, delta);
        
        // Draw the Title
        context.drawCenteredTextWithShadow(this.textRenderer, "NEXORA CLIENT", this.width / 2, 20, 0xFF55FF);
        
        // Draw a simple box for a "Module"
        context.fill(this.width / 2 - 50, 50, this.width / 2 + 50, 70, 0x80000000);
        context.drawCenteredTextWithShadow(this.textRenderer, "Movement", this.width / 2, 55, 0xFFFFFF);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false; // Don't pause the game when GUI is open
    }
}
