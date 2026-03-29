package com.nexora.client.gui;

import com.nexora.client.NexoraClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import java.awt.Color;

public class ClickGuiScreen extends Screen {
    public static float reachDistance = 3.0f;
    public static float hitboxSize = 0.0f;
    public static boolean motionBlur = true;

    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // 1. Sleek Gradient Background
        context.fillGradient(0, 0, width, height, 0x77000000, 0xAA000000);

        int x = width / 2 - 150;
        int y = height / 2 - 100;
        int w = 300;
        int h = 200;

        // 2. Main Panel Shadow & Body
        context.fill(x - 1, y - 1, x + w + 1, y + h + 1, 0xFF333333); // Border
        context.fill(x, y, x + w, y + h, 0xFF181818); // Inner Body

        // 3. Side Bar (Lunar Style)
        context.fill(x, y, x + 70, y + h, 0xFF111111);
        drawNexoraLogo(context, x + 35, y + 20);

        // 4. Categories in Sidebar
        context.drawText(textRenderer, "§bCombat", x + 10, y + 50, -1, false);
        context.drawText(textRenderer, "§7Visuals", x + 10, y + 65, -1, false);
        context.drawText(textRenderer, "§7Misc", x + 10, y + 80, -1, false);

        // 5. Module Cards (Right Side)
        drawModuleCard(context, "Fullbright", x + 80, y + 20, NexoraClient.fullbright);
        drawModuleCard(context, "Motion Blur", x + 80, y + 55, motionBlur);
        
        // Sliders for Reach/Hitbox
        drawSlider(context, "Reach", reachDistance, x + 80, y + 90, 3.0f, 6.0f);
        drawSlider(context, "Hitbox", hitboxSize, x + 80, y + 125, 0.0f, 2.0f);
    }

    private void drawNexoraLogo(DrawContext context, int cx, int cy) {
        // Draws a small cyan glow star (Nexora Logo)
        context.fill(cx - 2, cy - 10, cx + 2, cy + 10, 0xFF00E5FF);
        context.fill(cx - 10, cy - 2, cx + 10, cy + 2, 0xFF00E5FF);
    }

    private void drawModuleCard(DrawContext context, String name, int x, int y, boolean on) {
        context.fill(x, y, x + 200, y + 30, 0xFF222222); // Card Background
        context.drawText(textRenderer, name, x + 10, y + 11, -1, false);
        // Toggle Switch
        context.fill(x + 170, y + 10, x + 190, y + 20, on ? 0xFF00FF00 : 0xFF555555);
    }

    private void drawSlider(DrawContext context, String label, float val, int x, int y, float min, float max) {
        context.drawText(textRenderer, label + ": §b" + String.format("%.1f", val), x, y, -1, false);
        context.fill(x, y + 12, x + 200, y + 15, 0xFF333333); // Track
        int sliderX = (int) (x + ((val - min) / (max - min)) * 200);
        context.fill(sliderX - 2, y + 10, sliderX + 2, y + 17, 0xFF00E5FF); // Knob
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int x = width / 2 - 150 + 80;
        int y = height / 2 - 100;

        // Toggle Fullbright Card
        if (mouseX >= x && mouseX <= x + 200 && mouseY >= y + 20 && mouseY <= y + 50) {
            NexoraClient.fullbright = !NexoraClient.fullbright;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
