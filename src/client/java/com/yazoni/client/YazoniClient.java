package com.yazoni.client;

import com.yazoni.client.module.BuiltinModules;
import com.yazoni.client.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class YazoniClient implements ClientModInitializer {
    public static final String MOD_ID = "yazoni";
    public static final Logger LOGGER = LoggerFactory.getLogger("Yazoni Client");
    public static final ModuleManager MODULES = new ModuleManager();

    @Override
    public void onInitializeClient() {
        BuiltinModules.registerAll(MODULES);
        LOGGER.info("Yazoni Client initialized with {} built-in modules.", MODULES.all().size());
    }
}
