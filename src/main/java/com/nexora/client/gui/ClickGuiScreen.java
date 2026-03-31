package com.nexora.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Bewisclient trick: Explicitly disable depth testing for the background
        RenderSystem.disableDepthTest();
        
        // Use a solid, high-contrast background (Bewis uses a dark grey base)
        context.fill(0, 0, this.width, this.height, 0xFF101010); 

        int cx = this.width / 2;
        int cy = this.height / 2;

        // Render the "Nexora" Header with a Bewis-style accent line
        context.fill(cx - 100, cy - 85, cx + 100, cy - 83, 0xFFCC00FF); // Purple Accent
        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNexora Client §7v1.0", cx, cy - 75, 0xFFFFFF);

        // Render Module List (Using Bewis's vertical stack logic)
        renderModule(context, "Movement", cx - 90, cy - 50, true);
        renderModule(context, "Combat", cx - 90, cy - 25, false);
        renderModule(context, "Visuals", cx - 90, cy, true);

        RenderSystem.enableDepthTest();
        super.render(context, mouseX, mouseY, delta);
    }

    private void renderModule(DrawContext context, String name, int x, int y, boolean enabled) {
        // Rounded-look panels
        context.fill(x, y, x + 180, y + 20, 0xFF1A1A1A);
        String color = enabled ? "§a[ON]" : "§c[OFF]";
        context.drawTextWithShadow(this.textRenderer, name, x + 5, y + 6, 0xFFFFFF);
        context.drawTextWithShadow(this.textRenderer, color, x + 140, y + 6, 0xFFFFFF);
    }
}
