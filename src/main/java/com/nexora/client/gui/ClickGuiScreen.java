package com.nexora.client.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ClickGuiScreen extends Screen {
    public static float reachDistance = 3.0f;
    public static float hitboxSize = 0.1f;
    private boolean showingSecretMenu = false;

    public ClickGuiScreen() {
        super(Text.literal("Nexora ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        int w = this.width;
        int h = this.height;

        // Main Background Box
        context.fill(w / 4, h / 4, (w / 4) * 3, (h / 4) * 3, 0xDD000000);

        if (!showingSecretMenu) {
            // --- MAIN MENU ---
            context.drawText(this.textRenderer, Formatting.AQUA + "NEXORA HUD SETTINGS", (w / 2) - 50, (h / 4) + 10, 0xFFFFFF, true);
            
            // The Trigger Button
            int btnY = (h / 4) + 40;
            context.fill((w / 4) + 10, btnY - 2, (w / 4) + 120, btnY + 12, 0x44FFFFFF);
            context.drawText(this.textRenderer, "[>] CPS Display Settings", (w / 4) + 15, btnY, 0xFFFFFF, false);
            
            context.drawText(this.textRenderer, Formatting.GRAY + "(Click to open sub-menu)", (w / 4) + 15, btnY + 15, 0xFFFFFF, false);
        } else {
            // --- SECRET HACK MENU ---
            context.drawText(this.textRenderer, Formatting.RED + "CPS & PERFORMANCE ENGINE", (w / 2) - 60, (h / 4) + 10, 0xFFFFFF, true);
            
            // Reach Setting
            int reachY = (h / 4) + 40;
            String reachColor = reachDistance > 3.8f ? "§c" : "§a";
            context.drawText(this.textRenderer, "Custom Reach: " + reachColor + String.format("%.2f", reachDistance), (w / 4) + 20, reachY, 0xFFFFFF, false);
            context.drawText(this.textRenderer, Formatting.DARK_GRAY + "[+] Click to Increase | [-] Right-Click to Reset", (w / 4) + 20, reachY + 12, 0xFFFFFF, false);

            // Hitbox Setting
            int hbY = (h / 4) + 80;
            context.drawText(this.textRenderer, "Hitbox Expand: §b" + String.format("%.2f", hitboxSize), (w / 4) + 20, hbY, 0xFFFFFF, false);
            
            // Back Button
            context.drawText(this.textRenderer, Formatting.YELLOW + "<- BACK", (w / 4) + 10, (h / 4) * 3 - 20, 0xFFFFFF, true);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int w = this.width;
        int h = this.height;

        if (!showingSecretMenu) {
            // Click to enter secret menu
            if (mouseX >= (w / 4) + 10 && mouseX <= (w / 4) + 120 && mouseY >= (h / 4) + 38 && mouseY <= (h / 4) + 52) {
                showingSecretMenu = true;
                return true;
            }
        } else {
            // Reach Adjustment
            if (mouseY >= (h / 4) + 40 && mouseY <= (h / 4) + 60) {
                if (button == 0) reachDistance += 0.1f; // Left Click Up
                else reachDistance = 3.0f;             // Right Click Reset
                if (reachDistance > 5.0f) reachDistance = 5.0f;
                return true;
            }
            // Hitbox Adjustment
            if (mouseY >= (h / 4) + 80 && mouseY <= (h / 4) + 100) {
                hitboxSize += 0.05f;
                if (hitboxSize > 1.0f) hitboxSize = 0.1f;
                return true;
            }
            // Back Button
            if (mouseY >= (h / 4) * 3 - 25) {
                showingSecretMenu = false;
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
