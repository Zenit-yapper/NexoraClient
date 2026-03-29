package com.nexora.client.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ClickGuiScreen extends Screen {
    public static float reachDistance = 3.0f;
    public static float hitboxSize = 0.1f;
    private boolean showingSecretMenu = false;

    public ClickGuiScreen() { super(Text.literal("Nexora ClickGUI")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        int w = this.width;
        int h = this.height;
        context.fill(w / 4, h / 4, (w / 4) * 3, (h / 4) * 3, 0xDD000000);

        if (!showingSecretMenu) {
            context.drawText(this.textRenderer, Formatting.AQUA + "NEXORA SETTINGS", (w / 2) - 45, (h / 4) + 10, 0xFFFFFF, true);
            context.fill((w / 4) + 10, (h / 4) + 38, (w / 4) + 120, (h / 4) + 52, 0x44FFFFFF);
            context.drawText(this.textRenderer, "[>] CPS Display Settings", (w / 4) + 15, (h / 4) + 40, 0xFFFFFF, false);
        } else {
            context.drawText(this.textRenderer, Formatting.RED + "SECRET ENGINE", (w / 2) - 40, (h / 4) + 10, 0xFFFFFF, true);
            String reachColor = reachDistance > 3.8f ? "§c" : "§a";
            context.drawText(this.textRenderer, "Reach: " + reachColor + String.format("%.1f", reachDistance), (w / 4) + 20, (h / 4) + 40, 0xFFFFFF, false);
            context.drawText(this.textRenderer, "Hitbox: §b" + String.format("%.2f", hitboxSize), (w / 4) + 20, (h / 4) + 70, 0xFFFFFF, false);
            context.drawText(this.textRenderer, Formatting.YELLOW + "<- BACK", (w / 4) + 10, (h / 4) * 3 - 20, 0xFFFFFF, true);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int w = this.width; int h = this.height;
        if (!showingSecretMenu) {
            if (mouseX >= (w / 4) + 10 && mouseX <= (w / 4) + 120 && mouseY >= (h / 4) + 38 && mouseY <= (h / 4) + 52) {
                showingSecretMenu = true; return true;
            }
        } else {
            if (mouseY >= (h / 4) + 40 && mouseY <= (h / 4) + 55) { reachDistance += 0.2f; if (reachDistance > 5.0f) reachDistance = 3.0f; return true; }
            if (mouseY >= (h / 4) + 70 && mouseY <= (h / 4) + 85) { hitboxSize += 0.05f; if (hitboxSize > 0.5f) hitboxSize = 0.1f; return true; }
            if (mouseY >= (h / 4) * 3 - 25) { showingSecretMenu = false; return true; }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
