package com.nexora.client.mixin;

import com.nexora.client.gui.ClickGuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class CombatMixin {
    // This handles Hitbox expansion
    @Inject(method = "getTargetingMargin", at = @At("HEAD"), cancellable = true)
    private void onHitbox(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(ClickGuiScreen.hitboxSize);
    }
}

@Mixin(PlayerEntity.class)
class ReachMixin {
    // This handles Reach distance
    @Inject(method = "getEntityInteractionRange", at = @At("HEAD"), cancellable = true)
    private void onReach(CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue((double) ClickGuiScreen.reachDistance);
    }
}

