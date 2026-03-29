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

        // Dark Background
        context.fill(0, 0, w, h, 0xAA000000);

        // PERFECTLY CENTERED LOGO
        String title = "NEXORA CLIENT";
        int textWidth = client.textRenderer.getWidth(title);
        context.drawText(client.textRenderer, Formatting.AQUA + title, (w / 2) - (textWidth / 2), (h / 2) - 10, 0xFFFFFF, true);
    }
}
