package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class DirectionHudMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void renderDirection(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        Direction dir = client.player.getHorizontalFacing();
        String text = "§fFacing: §d" + dir.toString().toUpperCase();
        int x = (context.getScaledWindowWidth() - client.textRenderer.getWidth(text)) / 2;
        context.drawTextWithShadow(client.textRenderer, text, x, 20, 0xFFFFFF);
    }
}

