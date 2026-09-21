package com.yazoni.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class YazoniClient implements ClientModInitializer {
    public static final String MOD_ID = "yazoni";
    public static final Logger LOGGER = LoggerFactory.getLogger("Yazoni Client");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Yazoni Client foundation initialized.");
    }
}
