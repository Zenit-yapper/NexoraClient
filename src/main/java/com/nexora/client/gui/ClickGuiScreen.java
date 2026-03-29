package com.nexora.client.gui;

import com.nexora.client.NexoraClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public static float reachDistance = 3.0f;
    public static float hitboxSize = 0.0f;
    public static boolean motionBlur = true;
    public static boolean betterHurtcam = true;

    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        renderHUDs(context); // Draw Lunar features while menu is open to preview

        // GUI Panel
        context.fill(50, 50, 210, 180, 0xCC000000);
        context.fill(50, 50, 210, 65, 0xFF00E5FF);
        context.drawText(textRenderer, "NEXORA V2", 55, 54, 0xFFFFFF, true);

        drawBtn(context, "Fullbright", 55, 75, NexoraClient.fullbright);
        drawBtn(context, "Motion Blur", 55, 90, motionBlur);
        drawBtn(context, "Better Hurtcam", 55, 105, betterHurtcam);
        context.drawText(textRenderer, "Reach: " + reachDistance, 55, 125, 0xFFFFFF, true);
        context.drawText(textRenderer, "Hitbox: " + hitboxSize, 55, 140, 0xFFFFFF, true);
    }

    private void renderHUDs(DrawContext context) {
        if (client.player == null) return;
        
        // 1. Armor HUD (Lunar Style)
        int y = 5;
        for (ItemStack stack : client.player.getArmorItems()) {
            if (!stack.isEmpty()) {
                context.drawItem(stack, 5, y);
                context.drawItemInGuiWithOverrides(client.player, stack, 5, y, 0);
                y += 18;
            }
        }

        // 2. Potion HUD
        int py = 5;
        for (StatusEffectInstance effect : client.player.getStatusEffects()) {
            String name = effect.getEffectType().value().getName().getString();
            context.drawText(textRenderer, "§b" + name + " " + (effect.getDuration()/20) + "s", context.getScaledWindowWidth() - 100, py, 0xFFFFFF, true);
            py += 10;
        }
    }

    private void drawBtn(DrawContext context, String name, int x, int y, boolean on) {
        context.drawText(textRenderer, name + ": " + (on ? "§aON" : "§cOFF"), x, y, 0xFFFFFF, true);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= 55 && mouseX <= 200) {
            if (mouseY >= 75 && mouseY <= 85) NexoraClient.fullbright = !NexoraClient.fullbright;
            if (mouseY >= 90 && mouseY <= 100) motionBlur = !motionBlur;
            if (mouseY >= 105 && mouseY <= 115) betterHurtcam = !betterHurtcam;
            if (mouseY >= 125 && mouseY <= 135) reachDistance = (button == 0) ? reachDistance + 0.5f : 3.0f;
            if (mouseY >= 140 && mouseY <= 150) hitboxSize = (button == 0) ? hitboxSize + 0.1f : 0.0f;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
