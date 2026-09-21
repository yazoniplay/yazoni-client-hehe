package com.yazoni.client.ui;

import com.yazoni.client.YazoniClient;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public final class YazoniKeybinds {
    private static KeyMapping menuKey;

    private YazoniKeybinds() {}

    public static void register() {
        menuKey = new KeyMapping(
                "key.yazoni.open_menu",
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "key.categories.yazoni"
        );
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (menuKey.consumeClick()) {
                if (client.screen == null) {
                    client.setScreen(new YazoniScreen());
                }
            }
            YazoniClient.MODULES.tick();
        });
    }
}
