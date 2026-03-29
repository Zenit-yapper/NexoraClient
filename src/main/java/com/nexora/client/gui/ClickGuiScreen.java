package com.nexora.client.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Nexora ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        int w = this.width;
        int h = this.height;

        // Draw the Menu Box
        context.fill(w / 4, h / 4, (w / 4) * 3, (h / 4) * 3, 0xBB000000);
        context.drawText(this.textRenderer, "NEXORA MODS", (w / 2) - 30, (h / 4) + 10, 0x00FFFF, true);

        // Simple Mod Toggles (Visual only for now)
        context.drawText(this.textRenderer, "[✓] Fullbright", (w / 4) + 20, (h / 4) + 40, 0xFFFFFF, false);
        context.drawText(this.textRenderer, "[✓] Keystrokes", (w / 4) + 20, (h / 4) + 60, 0xFFFFFF, false);
        context.drawText(this.textRenderer, "[✓] Motion Blur", (w / 4) + 20, (h / 4) + 80, 0xFFFFFF, false);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false; // Don't pause the game in multiplayer
    }
}

