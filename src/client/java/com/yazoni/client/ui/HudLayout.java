package com.yazoni.client.ui;

public final class HudLayout {
    public static int infoX = 8;
    public static int infoY = 8;
    public static int keysX = 0;
    public static int keysY = 0;
    public static int crosshairSize = 5;

    private HudLayout() {}

    public static void clamp(int width, int height) {
        keysX = Math.max(0, Math.min(width - 110, keysX));
        keysY = Math.max(0, Math.min(height - 90, keysY));
        infoX = Math.max(0, Math.min(width - 180, infoX));
        infoY = Math.max(0, Math.min(height - 200, infoY));
    }

    public static void reset(int width, int height) {
        infoX = 8;
        infoY = 8;
        keysX = Math.max(0, width - 104);
        keysY = Math.max(0, height - 80);
    }
}
