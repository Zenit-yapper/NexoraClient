package com.nexora.client.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MainMenuMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void renderNexoraMenu(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        int w = context.getScaledWindowWidth();
        int h = context.getScaledWindowHeight();

        // Dark modern overlay
        context.fill(0, 0, w, h, 0xAA000000);

        // Center Title - Fixed for 1.21.1
        String title = Formatting.AQUA + "NEXORA " + Formatting.WHITE + "CLIENT";
        context.drawText(client.textRenderer, title, (w / 2) - 40, (h / 2) - 10, 0xFFFFFF, true);

        // Bottom left user info
        context.drawText(client.textRenderer, "Developer: " + Formatting.AQUA + "Pratik", 10, h - 20, 0xFFFFFF, true);
    }
}
