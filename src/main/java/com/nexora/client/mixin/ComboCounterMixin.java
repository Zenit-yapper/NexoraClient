package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
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

        // Reset combo if you haven't hit anyone in 2.5 seconds
        if (System.currentTimeMillis() - lastHitTime > 2500) {
            comboCount = 0;
        }

        if (comboCount > 0) {
            String text = "Combo: " + comboCount;
            // Positioned near the crosshair like your other HUD elements
            int x = context.getScaledWindowWidth() / 2 + 10;
            int y = context.getScaledWindowHeight() / 2 + 10;
            context.drawTextWithShadow(client.textRenderer, text, x, y, 0xFFCC00FF);
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        // Detects if you successfully landed a hit on an entity
        if (client.attackIndicatorTickCounter > 0 && client.targetedEntity != null) {
            if (System.currentTimeMillis() - lastHitTime > 150) {
                comboCount++;
                lastHitTime = System.currentTimeMillis();
            }
        }
    }
}
