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
    private void renderNexoraNature(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        int w = context.getScaledWindowWidth();
        int h = context.getScaledWindowHeight();

        // 1. Draw the Animated Moon
        long time = System.currentTimeMillis() / 50;
        int moonX = (int) (time % (w + 200)) - 100;
        drawCircle(context, moonX, 60, 25, 0x33FFFFFF); // Glow
        drawCircle(context, moonX, 60, 20, 0xFFEEEEEE); // Moon

        // 2. Draw Mountains (Back Layer - Darker)
        drawMountains(context, w, h, 0xCC1a1a1a, 80, 0.01);

        // 3. Draw Mountains (Front Layer - Lighter)
        drawMountains(context, w, h, 0xFF2d2d2d, 50, 0.02);

        // 4. Center the Logo
        String title = "NEXORA CLIENT";
        int textWidth = client.textRenderer.getWidth(title);
        context.drawText(client.textRenderer, Formatting
                         
