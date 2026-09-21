package com.yazoni.client.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class YazoniHudEditorScreen extends Screen {
    private String dragging = "";
    private int dragOffsetX;
    private int dragOffsetY;

    public YazoniHudEditorScreen() {
        super(Component.literal("Yazoni HUD Editor"));
    }

    @Override
    protected void init() {
        HudLayout.clamp(width, height);
        if (HudLayout.keysX == 0 && HudLayout.keysY == 0) {
            HudLayout.reset(width, height);
        }
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);

        graphics.fill(0, 0, width, height, 0xB005070A);

        int grid = 32;
        for (int x = 0; x < width; x += grid) graphics.fill(x, 0, x + 1, height, 0x251FFFFFF);
        for (int y = 0; y < height; y += grid) graphics.fill(0, y, width, y + 1, 0x251FFFFFF);

        graphics.text(font, "YAZONI HUD EDITOR", 18, 18, 0xFFFFFFFF, true);
        graphics.text(font, "Drag elements • ESC to close • R to reset", 18, 34, 0xFF9AA1AA, false);

        drawBox(graphics, HudLayout.infoX, HudLayout.infoY, 180, 190, "HUD INFO");
        drawBox(graphics, HudLayout.keysX, HudLayout.keysY, 104, 80, "KEYSTROKES");

        graphics.text(font, "INFO", HudLayout.infoX + 8, HudLayout.infoY + 8, 0xFFFF9B4A, true);
        graphics.text(font, "FPS 240", HudLayout.infoX + 8, HudLayout.infoY + 28, 0xFFFFFFFF, false);
        graphics.text(font, "PING 42", HudLayout.infoX + 8, HudLayout.infoY + 46, 0xFFFFFFFF, false);
        graphics.text(font, "XYZ 120.5 64.0 -32.2", HudLayout.infoX + 8, HudLayout.infoY + 64, 0xFFFF9B4A, false);
        graphics.text(font, "SESSION 00:12:34", HudLayout.infoX + 8, HudLayout.infoY + 82, 0xFFFFFFFF, false);

        graphics.text(font, "W", HudLayout.keysX + 44, HudLayout.keysY + 20, 0xFFFFFFFF, true);
        graphics.text(font, "A   S   D", HudLayout.keysX + 20, HudLayout.keysY + 40, 0xFFFFFFFF, true);
        graphics.text(font, "LMB    RMB", HudLayout.keysX + 18, HudLayout.keysY + 60, 0xFFFF9B4A, false);
    }

    private void drawBox(GuiGraphicsExtractor graphics, int x, int y, int w, int h, String title) {
        boolean hovered = mouseXInside(x, y, w, h);
        graphics.fill(x, y, x + w, y + h, hovered ? 0xDD202832 : 0xCC12171D);
        graphics.fill(x, y, x + w, y + 2, 0xFFFF6900);
        graphics.text(font, title, x + 8, y - 12, 0xFF8E97A3, false);
    }

    private boolean mouseXInside(int x, int y, int w, int h) {
        return mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) return super.mouseClicked(mouseX, mouseY, button);

        if (inside(mouseX, mouseY, HudLayout.infoX, HudLayout.infoY, 180, 190)) {
            dragging = "info";
            dragOffsetX = (int) mouseX - HudLayout.infoX;
            dragOffsetY = (int) mouseY - HudLayout.infoY;
            return true;
        }

        if (inside(mouseX, mouseY, HudLayout.keysX, HudLayout.keysY, 104, 80)) {
            dragging = "keys";
            dragOffsetX = (int) mouseX - HudLayout.keysX;
            dragOffsetY = (int) mouseY - HudLayout.keysY;
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (!dragging.equals("info") && !dragging.equals("keys")) return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);

        int x = (int) mouseX - dragOffsetX;
        int y = (int) mouseY - dragOffsetY;

        if (dragging.equals("info")) {
            HudLayout.infoX = x;
            HudLayout.infoY = y;
        } else {
            HudLayout.keysX = x;
            HudLayout.keysY = y;
        }

        HudLayout.clamp(width, height);
        return true;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        dragging = "";
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 82) {
            HudLayout.reset(width, height);
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
