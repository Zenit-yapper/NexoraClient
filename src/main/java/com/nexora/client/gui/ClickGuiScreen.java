package com.nexora.client.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public static float reachDistance = 3.0f; // Default Minecraft reach
    public static float hitboxSize = 0.1f;    // Default expansion

    public ClickGuiScreen() {
        super(Text.literal("Nexora ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        int w = this.width;
        int h = this.height;

        // The Main Box
        context.fill(w / 4, h / 4, (w / 4) * 3, (h / 4) * 3, 0xBB000000);
        context.drawText(this.textRenderer, "NEXORA MODS", (w / 2) - 30, (h / 4) + 10, 0x00FFFF, true);

        // THE SECRET BUTTON (Named CPS Display)
        int secretX = (w / 4) + 20;
        int secretY = (h / 4) + 40;
        context.drawText(this.textRenderer, "[✓] CPS Display", secretX, secretY, 0xFFFFFF, false);

        // Check if mouse is clicking the secret button
        if (mouseX >= secretX && mouseX <= secretX + 80 && mouseY >= secretY && mouseY <= secretY + 10) {
             context.drawText(this.textRenderer, " <- CLICK FOR REACH", secretX + 80, secretY, 0xFF0000, true);
        }

        // Draw current stats so you know they are working
        context.drawText(this.textRenderer, "Current Reach: " + reachDistance, (w / 4) + 20, (h / 4) + 100, 0xAAAAAA, false);
        context.drawText(this.textRenderer, "Hitbox Multi: " + hitboxSize, (w / 4) + 20, (h / 2) + 20, 0xAAAAAA, false);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int w = this.width;
        int h = this.height;
        // If clicking "CPS Display", increase reach for now (as a test)
        if (mouseX >= (w / 4) + 20 && mouseX <= (w / 4) + 100 && mouseY >= (h / 4) + 40 && mouseY <= (h / 4) + 50) {
            reachDistance += 0.5f;
            if (reachDistance > 6.0f) reachDistance = 3.0f; // Reset if too high
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
