package com.nexora.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class NametagMixin<T extends Entity> {
    @Inject(method = "renderLabelIfPresent", at = @At("HEAD"))
    private void renderNexoraIcon(T entity, Text text, MatrixStack matrices, net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
        if (entity instanceof PlayerEntity) {
            // This is where we could check if the player is using Nexora
            // For now, it will show for everyone so you can see it working!
            String prefix = Formatting.AQUA + "[N] " + Formatting.WHITE;
            // The game automatically handles the rest when we modify the text
        }
    }
}

