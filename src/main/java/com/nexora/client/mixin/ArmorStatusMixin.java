package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class ArmorStatusMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void renderArmorStatus(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.options.hudHidden) return;

        int y = context.getScaledWindowHeight() / 2 - 40;
        for (ItemStack stack : client.player.getArmorItems()) {
            if (!stack.isEmpty()) {
                context.drawItem(stack, 5, y);
                // Correct 1.21.1 method to draw durability and stack counts
                context.drawItemInGuiWithOverrides(client.textRenderer, stack, 5, y);
                y += 20;
            }
        }
    }
}
