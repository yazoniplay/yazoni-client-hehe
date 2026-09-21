package com.yazoni.client.ui;

import com.yazoni.client.YazoniClient;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public final class YazoniKeybinds {
    private static KeyMapping menuKey;
    private static KeyMapping hudEditorKey;

    private YazoniKeybinds() {}

    public static void register() {
        KeyMapping.Category category = KeyMapping.Category.register(
                net.minecraft.resources.Identifier.fromNamespaceAndPath(YazoniClient.MOD_ID, "main")
        );

        menuKey = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.yazoni.open_menu",
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                category
        ));

        hudEditorKey = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.yazoni.hud_editor",
                GLFW.GLFW_KEY_RIGHT_CONTROL,
                category
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (menuKey.consumeClick()) {
                if (client.screen == null) client.setScreen(new YazoniScreen());
            }
            while (hudEditorKey.consumeClick()) {
                if (client.screen == null) client.setScreen(new YazoniHudEditorScreen());
            }
            YazoniClient.MODULES.tick();
            YazoniHud.tick(client);
        });
    }
}
