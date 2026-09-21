package com.yazoni.client;

import net.fabricmc.api.ClientModInitializer;

public final class YazoniClient implements ClientModInitializer {
    public static final String MOD_ID = "yazoni";
    @Override public void onInitializeClient() {
        System.out.println("[Yazoni] Client foundation loaded for Minecraft 1.21.1");
    }
}
