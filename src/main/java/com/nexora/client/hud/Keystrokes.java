package com.nexora.client.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.option.KeyBinding;
import java.util.ArrayList;
import java.util.List;

public class Keystrokes {
    private static final List<Long> leftClicks = new ArrayList<>();

    public static void render(DrawContext context, MinecraftClient client) {
        int x = 10;
        int y = 100; // Positioned below Armor Status
        int size = 20;
        int gap = 2;

        // Render WASD
        drawKey(context, client, client.options.forwardKey, x + size + gap, y, size);
        drawKey(context, client, client.options.leftKey, x, y + size + gap, size);
        drawKey(context, client, client.options.backKey, x + size + gap, y + size + gap, size);
        drawKey(context, client, client.options.rightKey, x + (size + gap) * 2, y + size + gap, size);

        // Render CPS
        long now = System.currentTimeMillis();
        leftClicks.removeIf(time -> now - time > 1000);
        if (client.options.attackKey.isPressed()) {
             if (leftClicks.isEmpty() || now - leftClicks.get(leftClicks.size() - 1) > 50) {
                 leftClicks.add(now);
             }
        }
        context.drawText(client.textRenderer, "CPS: " + leftClicks.size(), x, y + (size + gap) * 2 + 5, 0x00FFFF, true);
    }

    private static void drawKey(DrawContext context, MinecraftClient client, KeyBinding key, int x, int y, int size) {
        int color = key.isPressed() ? 0x80FFFFFF : 0x40000000; // Lights up when pressed
        context.fill(x, y, x + size, y + size, color);
        context.drawText(client.textRenderer, key.getBoundKeyLocalizedText().getString().toUpperCase(), x + (size / 3), y + (size / 3), 0xFFFFFF, false);
    }
}
