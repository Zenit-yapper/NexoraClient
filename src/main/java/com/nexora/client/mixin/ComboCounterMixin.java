package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class ComboCounterMixin {
    private static int comboCount = 0;
    private static long lastHitTime = 0;

    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.options.hudHidden) return;

        // Reset combo if 2 seconds pass without a hit
        if (System.currentTimeMillis() - lastHitTime > 2000) {
            comboCount = 0;
        }

        if (comboCount > 0) {
            String text = "Combo: " + comboCount;
            int x = context.getScaledWindowWidth() / 2 + 10;
            int y = context.getScaledWindowHeight() / 2 + 10;
            context.drawTextWithShadow(client.textRenderer, text, x, y, 0xFFCC00FF); // Nexora Purple
        }
    }

    // This part records the hit to increase the counter
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.attackIndicatorTickCounter > 0 && client.targetedEntity != null) {
            // We only count it as a combo if it's a fresh hit
            if (System.currentTimeMillis() - lastHitTime > 100) {
                comboCount++;
                lastHitTime = System.currentTimeMillis();
            }
        }
    }
}

