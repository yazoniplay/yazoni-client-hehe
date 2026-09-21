package com.yazoni.client.ui;

import com.yazoni.client.YazoniClient;
import com.yazoni.client.module.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.VanillaHudElements;
import net.minecraft.client.Minecraft;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public final class YazoniHud {
    private YazoniHud() {}

    public static void register() {
        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                net.minecraft.resources.Identifier.fromNamespaceAndPath(YazoniClient.MOD_ID, "hud"),
                YazoniHud::render
        );
    }

    private static void render(GuiGraphicsExtractor graphics, DeltaTracker delta) {
        Minecraft client = Minecraft.getInstance();
        if (client.options.hideGui) return;

        Module fps = YazoniClient.MODULES.get("fps-hud");
        Module coords = YazoniClient.MODULES.get("coordinates");
        Module memory = YazoniClient.MODULES.get("memory-hud");

        int x = 8;
        int y = 8;

        if (fps != null && fps.enabled()) {
            graphics.fill(x - 4, y - 4, x + 76, y + 12, 0xB010141A);
            graphics.text(client.font, "FPS " + client.getFps(), x, y, 0xFFFFFFFF, true);
            y += 18;
        }

        if (coords != null && coords.enabled() && client.player != null) {
            graphics.fill(x - 4, y - 4, x + 132, y + 12, 0xB010141A);
            graphics.text(client.font,
                    String.format("XYZ %.1f %.1f %.1f", client.player.getX(), client.player.getY(), client.player.getZ()),
                    x, y, 0xFFFF9B4A, false);
            y += 18;
        }

        if (memory != null && memory.enabled()) {
            Runtime runtime = Runtime.getRuntime();
            long used = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
            graphics.fill(x - 4, y - 4, x + 105, y + 12, 0xB010141A);
            graphics.text(client.font, "RAM " + used + " MB", x, y, 0xFFFFFFFF, false);
        }
    }
}
