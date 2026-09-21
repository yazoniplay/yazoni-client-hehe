package com.yazoni.client.ui;

import com.yazoni.client.YazoniClient;
import com.yazoni.client.module.Category;
import com.yazoni.client.module.Module;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.List;

public final class YazoniScreen extends Screen {
    private Category selected = Category.PERFORMANCE;
    private String search = "";

    public YazoniScreen() {
        super(Component.literal("Yazoni Client"));
    }

    @Override
    protected void init() {
        // The first version deliberately uses Minecraft's native Screen rendering
        // so the menu stays lightweight and easy to port across client versions.
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);

        int left = Math.max(18, (width - 720) / 2);
        int top = Math.max(18, (height - 440) / 2);
        int right = Math.min(width - 18, left + 720);
        int bottom = Math.min(height - 18, top + 440);

        graphics.fill(0, 0, width, height, 0x9905070A);
        graphics.fill(left, top, right, bottom, 0xF20C1015);
        graphics.fill(left, top, left + 4, bottom, 0xFFFF6900);

        graphics.text(font, "YAZONI", left + 24, top + 20, 0xFFFFFFFF, true);
        graphics.text(font, "CLIENT", left + 83, top + 20, 0xFFFF9B4A, false);
        graphics.text(font, "Right Shift • Modules", right - 145, top + 20, 0xFF8C949E, false);

        int sideX = left + 18;
        int sideY = top + 55;
        for (Category category : Category.values()) {
            boolean active = category == selected;
            graphics.fill(sideX, sideY, sideX + 128, sideY + 26, active ? 0xFF242B33 : 0x00101010);
            graphics.text(font, category.displayName(), sideX + 10, sideY + 8,
                    active ? 0xFFFFFFFF : 0xFF9AA1AA, false);
            sideY += 31;
        }

        int contentX = left + 165;
        int contentY = top + 58;
        graphics.text(font, selected.displayName(), contentX, contentY, 0xFFFFFFFF, true);
        graphics.text(font, "Built-in features", contentX, contentY + 17, 0xFF747D88, false);

        List<Module> modules = YazoniClient.MODULES.category(selected);
        int rowY = contentY + 43;
        for (Module module : modules) {
            if (!search.isBlank() && !module.name().toLowerCase().contains(search.toLowerCase())
                    && !module.description().toLowerCase().contains(search.toLowerCase())) {
                continue;
            }

            graphics.fill(contentX, rowY, right - 18, rowY + 44, 0xFF151A20);
            graphics.text(font, module.name(), contentX + 12, rowY + 9, 0xFFE9EDF1, false);
            graphics.text(font, module.description(), contentX + 12, rowY + 25, 0xFF737C87, false);

            int toggleX = right - 54;
            int toggleColor = module.enabled() ? 0xFFFF6900 : 0xFF343B44;
            graphics.fill(toggleX, rowY + 13, toggleX + 28, rowY + 29, toggleColor);
            graphics.fill(toggleX + (module.enabled() ? 16 : 2), rowY + 15,
                    toggleX + (module.enabled() ? 26 : 12), rowY + 27, 0xFFF4F5F6);
            rowY += 50;
            if (rowY > bottom - 18) break;
        }

        graphics.text(font, "ESC  Close", left + 20, bottom - 18, 0xFF707985, false);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int left = Math.max(18, (width - 720) / 2);
        int top = Math.max(18, (height - 440) / 2);
        int sideX = left + 18;
        int sideY = top + 55;

        for (Category category : Category.values()) {
            if (mouseX >= sideX && mouseX <= sideX + 128 && mouseY >= sideY && mouseY <= sideY + 26) {
                selected = category;
                return true;
            }
            sideY += 31;
        }

        int contentX = left + 165;
        int rowY = top + 58 + 43;
        for (Module module : YazoniClient.MODULES.category(selected)) {
            if (!search.isBlank() && !module.name().toLowerCase().contains(search.toLowerCase())
                    && !module.description().toLowerCase().contains(search.toLowerCase())) continue;
            if (mouseX >= contentX && mouseX <= left + 702 && mouseY >= rowY && mouseY <= rowY + 44) {
                module.toggle();
                return true;
            }
            rowY += 50;
            if (rowY > top + 422) break;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
