package com.nexora.client;

import com.nexora.client.gui.ClickGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;

public class NexoraClient implements ClientModInitializer {
    public static boolean fullbright = false;

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((context, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null || client.options.hudHidden) return;

            // 1. Professional Branding
            context.fill(5, 5, 95, 18, 0x88000000);
            context.drawText(client.textRenderer, "§bNEXORA §8| §f" + client.getCurrentFps() + " FPS", 10, 8, -1, false);

            // 2. Armor Status HUD (Lunar Style)
            if (ClickGuiScreen.armorHUD) {
                int ay = 40;
                for (ItemStack stack : client.player.getArmorItems()) {
                    if (!stack.isEmpty()) {
                        context.drawItem(stack, 5, ay);
                        int dur = (int) ((1 - stack.getDamage() / (float) stack.getMaxDamage()) * 100);
                        context.drawText(client.textRenderer, dur + "%", 25, ay + 5, -1, true);
                        ay += 20;
                    }
                }
            }

            // 3. Keystrokes (Simplified Logic)
            if (ClickGuiScreen.showKeystrokes) {
                int kx = context.getScaledWindowWidth() - 60;
                int ky = context.getScaledWindowHeight() - 80;
                drawKey(context, "W", kx + 20, ky, client.options.forwardKey.isPressed());
                drawKey(context, "A", kx, ky + 20, client.options.leftKey.isPressed());
                drawKey(context, "S", kx + 20, ky + 20, client.options.backKey.isPressed());
                drawKey(context, "D", kx + 40, ky + 20, client.options.rightKey.isPressed());
            }

            // 4. Coordinates
            if (ClickGuiScreen.showCoords) {
                String pos = String.format("§7X: §f%d §7Y: §f%d §7Z: §f%d", (int)client.player.getX(), (int)client.player.getY(), (int)client.player.getZ());
                context.drawText(client.textRenderer, pos, 5, context.getScaledWindowHeight() - 15, -1, true);
            }
        });
    }

    private void drawKey(DrawContext context, String name, int x, int y, boolean pressed) {
        context.fill(x, y, x + 18, y + 18, pressed ? 0xAA00E5FF : 0x66000000);
        context.drawText(MinecraftClient.getInstance().textRenderer, name, x + 6, y + 5, -1, false);
    }
}
