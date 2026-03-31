package com.nexora.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // DISABLE BLENDING - This stops the "fuzziness" on Mali GPUs
        RenderSystem.disableBlend();
        
        // 0xFF000000 is 100% Solid Black. Zero transparency = Zero blur.
        context.fill(0, 0, this.width, this.height, 0xFF000000);

        int cx = this.width / 2;
        int cy = this.height / 2;

        // Main Panel (Onyx & Purple)
        context.fill(cx - 102, cy - 82, cx + 102, cy + 82, 0xFFCC00FF); 
        context.fill(cx - 100, cy - 80, cx + 100, cy + 80, 0xFF0A0A0A); 

        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA §f| §7ULTRA CLEAR", cx, cy - 72, 0xFFFFFFFF);

        drawRow(context, "Auto Sprint", cy - 40);
        drawRow(context, "No Fall", cy - 15);
        drawRow(context, "Clear Water", cy + 10);
        
        RenderSystem.enableBlend(); // Turn it back on for text shadows
        super.render(context, mouseX, mouseY, delta);
    }

    private void drawRow(DrawContext context, String name, int y) {
        int cx = this.width / 2;
        context.fill(cx - 90, y, cx + 90, y + 18, 0xFF151515);
        context.drawTextWithShadow(this.textRenderer, "§f" + name, cx - 84, y + 5, 0xFFFFFF);
    }
}
