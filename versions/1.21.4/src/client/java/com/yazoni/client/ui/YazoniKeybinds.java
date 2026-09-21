package com.yazoni.client.ui;
import com.mojang.blaze3d.platform.InputConstants;import com.yazoni.client.YazoniClient;import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;import net.fabricmc.fabric.api.client.keybinding.v1.KeyMappingHelper;import net.minecraft.client.KeyMapping;
public final class YazoniKeybinds{private static KeyMapping menuKey,hudEditorKey;private YazoniKeybinds(){}
public static void register(){KeyMapping.Category category=KeyMapping.Category.register(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(YazoniClient.MOD_ID,"main"));
menuKey=KeyMappingHelper.registerKeyMapping(new KeyMapping("key.yazoni.open_menu",InputConstants.Type.KEYSYM,InputConstants.KEY_RIGHT_SHIFT,category));
hudEditorKey=KeyMappingHelper.registerKeyMapping(new KeyMapping("key.yazoni.hud_editor",InputConstants.Type.KEYSYM,InputConstants.KEY_RIGHT_CONTROL,category));
ClientTickEvents.END_CLIENT_TICK.register(c->{while(menuKey.consumeClick()){if(c.screen==null)c.setScreen(new YazoniScreen());}while(hudEditorKey.consumeClick()){if(c.screen==null)c.setScreen(new YazoniHudEditorScreen());}YazoniClient.MODULES.tick();YazoniHud.tick(c);});}}
