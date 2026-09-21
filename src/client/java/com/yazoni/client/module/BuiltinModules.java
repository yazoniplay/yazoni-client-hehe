package com.yazoni.client.module;

public final class BuiltinModules {
    private BuiltinModules() {}
    public static void registerAll(ModuleManager manager) {
        add(manager,"fps-boost","FPS Boost",Category.PERFORMANCE,"General client-side performance optimizations.",new BooleanSetting("aggressive","Aggressive",true));
        add(manager,"render-optimizer","Render Optimizer",Category.PERFORMANCE,"Reduces unnecessary rendering work.",new BooleanSetting("skip-far","Skip Far Detail",true));
        add(manager,"entity-optimizer","Entity Optimizer",Category.PERFORMANCE,"Optimizes entity rendering and visibility.",new NumberSetting("distance","Entity Distance",1,0.5,2,0.1));
        add(manager,"particle-optimizer","Particle Optimizer",Category.PERFORMANCE,"Controls particle work.",new NumberSetting("amount","Particle Amount",75,0,100,5));
        add(manager,"animation-optimizer","Animation Optimizer",Category.PERFORMANCE,"Reduces animation updates.",new BooleanSetting("fast","Fast Animations",true));
        add(manager,"dynamic-render-distance","Dynamic Render Distance",Category.PERFORMANCE,"Adjusts render distance around a target.",new NumberSetting("target-fps","Target FPS",120,30,360,10));
        add(manager,"chunk-optimizer","Chunk Optimizer",Category.PERFORMANCE,"Optimizes chunk-related client work.",new NumberSetting("threads","Worker Budget",2,1,8,1));
        add(manager,"memory-optimizer","Memory Optimizer",Category.PERFORMANCE,"Keeps client memory usage under control.",new BooleanSetting("gc","GC Assist",true));
        add(manager,"fast-world-loading","Fast World Loading",Category.PERFORMANCE,"Improves client loading behavior.",new BooleanSetting("preload","Preload Chunks",true));
        add(manager,"smart-fps-limit","Smart FPS Limit",Category.PERFORMANCE,"Applies an adaptive FPS cap.",new NumberSetting("limit","FPS Limit",240,30,1000,10));
        add(manager,"low-end-mode","Low-End Mode",Category.PERFORMANCE,"Conservative performance profile.",new BooleanSetting("extra","Extra Savings",true));
        add(manager,"performance-profile","Performance Profiles",Category.PERFORMANCE,"Switch between profiles.",new EnumSetting<>("profile","Profile",Profile.PERFORMANCE,Profile.values()));

        add(manager,"keystrokes","Keystrokes",Category.PVP,"Displays movement and mouse inputs.",new NumberSetting("scale","Scale",1,0.5,2,0.1));
        add(manager,"cps-counter","CPS Counter",Category.PVP,"Displays clicks per second.",new NumberSetting("scale","Scale",1,0.5,2,0.1));
        add(manager,"armor-hud","Armor HUD",Category.PVP,"Displays equipped armor and durability.",new BooleanSetting("durability","Show Durability",true));
        add(manager,"potion-hud","Potion HUD",Category.PVP,"Displays active potion effects.",new BooleanSetting("icons","Show Icons",true));
        add(manager,"direction-hud","Direction HUD",Category.PVP,"Displays facing direction.",new BooleanSetting("axis","Show Axis",true));
        add(manager,"coordinates","Coordinates",Category.PVP,"Displays player coordinates.",new NumberSetting("decimals","Decimals",1,0,3,1));
        add(manager,"combo-counter","Combo Counter",Category.PVP,"Tracks consecutive hits.",new BooleanSetting("reset","Reset On Damage",true));
        add(manager,"hit-effects","Hit Effects",Category.PVP,"Visual feedback for hits.",new NumberSetting("duration","Duration",300,50,1000,50));
        add(manager,"damage-numbers","Damage Numbers",Category.PVP,"Displays combat damage information.",new BooleanSetting("critical","Critical Only",false));
        add(manager,"custom-crosshair","Custom Crosshair",Category.PVP,"Provides a configurable crosshair.",new NumberSetting("size","Size",5,1,12,1),new NumberSetting("gap","Gap",2,0,8,1));
        add(manager,"toggle-sprint","Toggle Sprint",Category.PVP,"Toggles sprint.",new BooleanSetting("double-tap","Double Tap",false));
        add(manager,"toggle-sneak","Toggle Sneak",Category.PVP,"Toggles sneak.",new BooleanSetting("double-tap","Double Tap",false));
        add(manager,"target-hud","Target HUD",Category.PVP,"Displays target information.",new NumberSetting("scale","Scale",1,0.5,2,0.1));
        add(manager,"item-durability","Item Durability",Category.PVP,"Displays held-item durability.",new BooleanSetting("percent","Show Percent",true));
        add(manager,"tnt-timer","TNT Timer",Category.PVP,"Displays nearby TNT timing information.",new BooleanSetting("ticks","Show Ticks",true));

        add(manager,"fps-hud","FPS",Category.HUD,"Displays current FPS.",new BooleanSetting("shadow","Text Shadow",true));
        add(manager,"ping-hud","Ping",Category.HUD,"Displays network latency.",new BooleanSetting("shadow","Text Shadow",true));
        add(manager,"memory-hud","Memory",Category.HUD,"Displays client memory usage.",new BooleanSetting("shadow","Text Shadow",true));
        add(manager,"session-stats","Session Stats",Category.HUD,"Displays session statistics.",new BooleanSetting("compact","Compact",true));
        add(manager,"clock","Clock",Category.HUD,"Displays the local clock.",new EnumSetting<>("format","Format",ClockFormat.TWENTY_FOUR_HOUR,ClockFormat.values()));
        add(manager,"server-info","Server Info",Category.HUD,"Displays server information.",new BooleanSetting("address","Show Address",false));

        add(manager,"zoom","Zoom",Category.VISUAL,"Smooth configurable camera zoom.",new NumberSetting("zoom","Zoom Level",3,1.5,10,0.5));
        add(manager,"fullbright","Fullbright",Category.VISUAL,"Improves visibility in dark areas.",new NumberSetting("brightness","Brightness",1,0.5,5,0.1));
        add(manager,"no-hurt-cam","No Hurt Cam",Category.VISUAL,"Removes camera hurt movement.",new BooleanSetting("all","Remove All",true));
        add(manager,"no-fog","No Fog",Category.VISUAL,"Reduces environmental fog.",new NumberSetting("strength","Strength",100,0,100,5));
        add(manager,"block-highlight","Block Highlight",Category.VISUAL,"Highlights the targeted block.",new NumberSetting("width","Line Width",1,1,5,1));
        add(manager,"player-highlight","Player Highlight",Category.VISUAL,"Highlights selected players.",new BooleanSetting("through-walls","Through Walls",false));
        add(manager,"weather-control","Weather Control",Category.VISUAL,"Controls local weather visuals.",new EnumSetting<>("mode","Mode",WeatherMode.DEFAULT,WeatherMode.values()));
        add(manager,"time-changer","Time Changer",Category.VISUAL,"Changes local visual time.",new NumberSetting("time","Time",6000,0,24000,100));
        add(manager,"custom-sky","Custom Sky",Category.VISUAL,"Provides configurable sky visuals.",new NumberSetting("intensity","Intensity",100,0,100,5));

        add(manager,"chat-cleaner","Chat Cleaner",Category.UTILITY,"Filters chat clutter.",new BooleanSetting("duplicate","Hide Duplicates",true));
        add(manager,"chat-timestamps","Chat Timestamps",Category.UTILITY,"Adds timestamps to chat.",new EnumSetting<>("format","Format",ClockFormat.TWENTY_FOUR_HOUR,ClockFormat.values()));
        add(manager,"auto-gg","Auto GG",Category.UTILITY,"Sends a configurable end-of-game message.",new BooleanSetting("enabled","Enabled",true));
        add(manager,"screenshot-manager","Screenshot Manager",Category.UTILITY,"Improves screenshot organization.",new BooleanSetting("open-folder","Open Folder",true));
        add(manager,"session-timer","Session Timer",Category.UTILITY,"Tracks the current play session.",new BooleanSetting("seconds","Show Seconds",true));
        add(manager,"fps-graph","FPS Graph",Category.UTILITY,"Displays FPS history.",new NumberSetting("seconds","History Seconds",10,3,30,1));
        add(manager,"ping-graph","Ping Graph",Category.UTILITY,"Displays latency history.",new NumberSetting("seconds","History Seconds",10,3,30,1));
        add(manager,"config-manager","Config Manager",Category.UTILITY,"Saves and loads configurations.",new BooleanSetting("autosave","Auto Save",true));

        add(manager,"server-switcher","Server Switcher",Category.MULTIPLAYER,"Quickly switch saved servers.",new BooleanSetting("confirm","Confirm Switch",false));
        add(manager,"server-favorites","Server Favorites",Category.MULTIPLAYER,"Keeps favorite servers.",new NumberSetting("slots","Slots",8,3,30,1));
        add(manager,"quick-connect","Quick Connect",Category.MULTIPLAYER,"Fast access to saved connections.",new BooleanSetting("last-server","Remember Last",true));
        add(manager,"player-counter","Player Counter",Category.MULTIPLAYER,"Displays online player counts.",new BooleanSetting("friends","Show Friends",true));

        add(manager,"notifications","Notifications",Category.CLIENT,"Shows compact notifications.",new NumberSetting("duration","Duration",3000,500,10000,500));
        add(manager,"module-search","Module Search",Category.CLIENT,"Searches all modules.",new BooleanSetting("descriptions","Show Descriptions",true));
        add(manager,"theme-engine","Theme Engine",Category.CLIENT,"Controls Yazoni visual style.",new EnumSetting<>("theme","Theme",Theme.ORANGE,Theme.values()));
        add(manager,"hud-editor","HUD Editor",Category.CLIENT,"Drag and position HUD elements.",new NumberSetting("grid","Grid Size",16,4,64,4));
        add(manager,"profiles","Profiles",Category.CLIENT,"Switch between configurations.",new EnumSetting<>("profile","Profile",Profile.DEFAULT,Profile.values()));
    }
    private static void add(ModuleManager m,String id,String name,Category c,String desc,Setting<?>... settings){Module x=new Module(id,name,c,desc){};for(Setting<?> s:settings)x.setting(s);m.register(x);}
    private enum Profile{DEFAULT,PERFORMANCE,PVP,CASUAL}
    private enum ClockFormat{TWENTY_FOUR_HOUR,TWELVE_HOUR}
    private enum WeatherMode{DEFAULT,CLEAR,RAIN,THUNDER}
    private enum Theme{ORANGE,BLUE,PURPLE,MONO}
}
