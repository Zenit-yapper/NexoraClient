package com.nexora.client.mixin;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(EntityRenderer.class)
public class NametagMixin {
    @ModifyVariable(method = "renderLabelIfPresent", at = @At("HEAD"), argsOnly = true)
    private Text addMoonIcon(Text text, Entity entity) {
        if (entity instanceof PlayerEntity) {
            // Adds a yellow moon icon before the player's name
            return Text.literal(Formatting.YELLOW + "☾ " + Formatting.RESET).append(text);
        }
        return text;
    }
}
