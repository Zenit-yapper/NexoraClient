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
public class InGameHudMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void onRender(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && !client.options.hudHidden) {
            String coords = String.format("X: %d, Y: %d, Z: %d", 
                (int)client.player.getX(), (int)client.player.getY(), (int)client.player.getZ());
            
            // Draw sleek white text with shadow at the bottom left
            context.drawTextWithShadow(client.textRenderer, "§dNexora §f| " + coords, 5, context.getScaledWindowHeight() - 15, 0xFFFFFF);
        }
    }
}

