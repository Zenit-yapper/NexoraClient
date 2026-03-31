package com.nexora.client.mixin;

import com.nexora.client.gui.ClickGuiScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class BlurMixin {
    
    @Inject(method = "init", at = @At("HEAD"))
    private void onInit(CallbackInfo ci) {
        if ((Object) this instanceof ClickGuiScreen) {
            MinecraftClient client = MinecraftClient.getInstance();
            // We use the Accessor here to call the private method
            ((GameRendererAccessor) client.gameRenderer).invokeLoadPostProcessor(
                Identifier.of("minecraft", "shaders/post/blur.json")
            );
        }
    }

    @Inject(method = "removed", at = @At("HEAD"))
    private void onRemoved(CallbackInfo ci) {
        if ((Object) this instanceof ClickGuiScreen) {
            MinecraftClient.getInstance().gameRenderer.disablePostProcessor();
        }
    }
}
