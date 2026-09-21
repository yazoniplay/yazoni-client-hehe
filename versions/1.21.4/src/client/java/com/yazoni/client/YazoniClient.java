package com.yazoni.client;

import com.yazoni.client.module.BuiltinModules;
import com.yazoni.client.module.ModuleManager;
import com.yazoni.client.ui.YazoniHud;
import com.yazoni.client.ui.YazoniKeybinds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ClientModInitializer;

public final class YazoniClient implements ClientModInitializer {
    public static final String MOD_ID = "yazoni";
    public static final Logger LOGGER = LoggerFactory.getLogger("Yazoni Client");
    public static final ModuleManager MODULES = new ModuleManager();

    @Override
    public void onInitializeClient() {
        BuiltinModules.registerAll(MODULES);
        YazoniKeybinds.register();
        YazoniHud.register();
        LOGGER.info("Yazoni Client 1.21.4 initialized with {} modules.", MODULES.all().size());
    }
}
