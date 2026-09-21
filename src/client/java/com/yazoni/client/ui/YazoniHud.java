package com.yazoni.client.ui;

import com.yazoni.client.YazoniClient;
import com.yazoni.client.module.Module;
import net.fabricmc.fabric.api.client.rendering.v1.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.VanillaHudElements;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.player.LocalPlayer;

import java.util.ArrayDeque;
import java.util.Deque;

public final class YazoniHud {
    private static final Deque<Long> CLICKS = new ArrayDeque<>();
    private static long sessionStart = System.currentTimeMillis();
    private static boolean lastAttack;
    private static boolean lastUse;

    private YazoniHud() {}

    public static void register() {
        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                net.minecraft.resources.Identifier.fromNamespaceAndPath(YazoniClient.MOD_ID, "hud"),
                YazoniHud::render
        );
    }

    public static void tick(Minecraft client) {
        if (client.player == null) return;

        boolean attack = client.options.keyAttack.isDown();
        if (attack && !lastAttack) CLICKS.addLast(System.currentTimeMillis());
        lastAttack = attack;
        lastUse = client.options.keyUse.isDown();

        long cutoff = System.currentTimeMillis() - 1000L;
        while (!CLICKS.isEmpty() && CLICKS.peekFirst() < cutoff) CLICKS.removeFirst();
    }

    private static void render(GuiGraphicsExtractor graphics, DeltaTracker delta) {
        Minecraft client = Minecraft.getInstance();
        if (client.options.hideGui || client.player == null) return;

        LocalPlayer player = client.player;
        int x = 8;
        int y = 8;

        y = line(graphics, client, "fps-hud", "FPS " + client.getFps(), x, y, false);
        y = line(graphics, client, "ping-hud", "PING " + ping(client), x, y, false);
        y = line(graphics, client, "memory-hud", "RAM " + memoryMb() + " MB", x, y, false);
        y = line(graphics, client, "coordinates", String.format("XYZ %.1f %.1f %.1f", player.getX(), player.getY(), player.getZ()), x, y, true);
        y = line(graphics, client, "direction-hud", "DIR " + player.getDirection().getName(), x, y, true);
        y = line(graphics, client, "cps-counter", "CPS " + CLICKS.size(), x, y, false);
        y = line(graphics, client, "armor-hud", "ARMOR " + player.getArmorValue(), x, y, false);
        y = line(graphics, client, "potion-hud", "EFFECTS " + player.getActiveEffects().size(), x, y, false);
        y = line(graphics, client, "session-timer", "SESSION " + sessionTime(), x, y, true);
        y = line(graphics, client, "server-info", serverInfo(client), x, y, true);

        if (enabled("keystrokes")) {
            int baseX = client.getWindow().getGuiScaledWidth() - 104;
            int baseY = client.getWindow().getGuiScaledHeight() - 80;
            key(graphics, client, "W", client.options.keyUp.isDown(), baseX + 34, baseY);
            key(graphics, client, "A", client.options.keyLeft.isDown(), baseX, baseY + 27);
            key(graphics, client, "S", client.options.keyDown.isDown(), baseX + 34, baseY + 27);
            key(graphics, client, "D", client.options.keyRight.isDown(), baseX + 68, baseY + 27);
            key(graphics, client, "LMB", client.options.keyAttack.isDown(), baseX, baseY + 54);
            key(graphics, client, "RMB", lastUse, baseX + 50, baseY + 54);
        }

        if (enabled("custom-crosshair")) {
            int cx = client.getWindow().getGuiScaledWidth() / 2;
            int cy = client.getWindow().getGuiScaledHeight() / 2;
            graphics.fill(cx - 1, cy - 5, cx + 1, cy + 6, 0xFFFF9B4A);
            graphics.fill(cx - 5, cy - 1, cx + 6, cy + 1, 0xFFFF9B4A);
        }
    }

    private static int line(GuiGraphicsExtractor graphics, Minecraft client, String id, String text, int x, int y, boolean accent) {
        if (!enabled(id)) return y;
        int width = Math.max(82, client.font.width(text) + 10);
        graphics.fill(x - 4, y - 4, x + width, y + 12, 0xB010141A);
        graphics.text(client.font, text, x, y, accent ? 0xFFFF9B4A : 0xFFFFFFFF, false);
        return y + 18;
    }

    private static void key(GuiGraphicsExtractor graphics, Minecraft client, String text, boolean pressed, int x, int y) {
        graphics.fill(x, y, x + 32, y + 22, pressed ? 0xE0FF6900 : 0xC0202026);
        graphics.text(client.font, text, x + (32 - client.font.width(text)) / 2, y + 7, 0xFFFFFFFF, true);
    }

    private static boolean enabled(String id) {
        Module module = YazoniClient.MODULES.get(id);
        return module != null && module.enabled();
    }

    private static int ping(Minecraft client) {
        if (client.getConnection() == null || client.player == null) return 0;
        var info = client.getConnection().getPlayerInfo(client.player.getUUID());
        return info == null ? 0 : info.getLatency();
    }

    private static long memoryMb() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
    }

    private static String sessionTime() {
        long seconds = (System.currentTimeMillis() - sessionStart) / 1000L;
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }

    private static String serverInfo(Minecraft client) {
        if (client.getCurrentServer() != null) return client.getCurrentServer().name;
        return client.hasSingleplayerServer() ? "SINGLEPLAYER" : "MENU";
    }
}
