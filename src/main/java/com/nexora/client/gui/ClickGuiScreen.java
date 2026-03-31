package com.nexora.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() { super(Text.literal("Nexora")); }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Force the background to be a solid, non-transparent dark grey
        // 0xFF at the start ensures 100% opacity (NO BLUR POSSIBLE)
        context.fill(0, 0, this.width, this.height, 0xFF0D0D0D);

        int cx = this.width / 2;
        int cy = this.height / 2;

        // Main Dashboard Frame
        context.fill(cx - 102, cy - 82, cx + 102, cy + 82, 0xFFCC00FF); // Purple Border
        context.fill(cx - 100, cy - 80, cx + 100, cy + 80, 0xFF121212); // Inner Body

        context.drawCenteredTextWithShadow(this.textRenderer, "§d§lNEXORA §f| §7CLEAR-STABLE", cx, cy - 72, 0xFFFFFFFF);

        // Modules
        drawStaticRow(context, "Auto Sprint", cy - 40);
        drawStaticRow(context, "No Fall", cy - 15);
        drawStaticRow(context, "Clear Water", cy + 10);
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void drawStaticRow(DrawContext context, String name, int y) {
        int cx = this.width / 2;
        context.fill(cx - 90, y, cx + 90, y + 18, 0xFF1A1A1A);
        context.drawTextWithShadow(this.textRenderer, "§f" + name, cx - 84, y + 5, 0xFFFFFF);
        context.drawTextWithShadow(this.textRenderer, "§a§lON", cx + 70, y + 5, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() { return false; }
}
