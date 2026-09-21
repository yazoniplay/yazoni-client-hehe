package com.yazoni.client.module;
public final class BuiltinModules{
 private BuiltinModules(){}
 public static void registerAll(ModuleManager m){
  add(m,"fps-boost","FPS Boost",Category.PERFORMANCE,"Client performance optimizations.",new BooleanSetting("aggressive","Aggressive",true));
  add(m,"render-optimizer","Render Optimizer",Category.PERFORMANCE,"Reduces unnecessary rendering work.",new BooleanSetting("skip-far","Skip Far Detail",true));
  add(m,"entity-optimizer","Entity Optimizer",Category.PERFORMANCE,"Optimizes entity rendering.",new NumberSetting("distance","Entity Distance",1,0.5,2,0.1));
  add(m,"particle-optimizer","Particle Optimizer",Category.PERFORMANCE,"Controls particle work.",new NumberSetting("amount","Particle Amount",75,0,100,5));
  add(m,"animation-optimizer","Animation Optimizer",Category.PERFORMANCE,"Reduces animation work.",new BooleanSetting("fast","Fast Animations",true));
  add(m,"dynamic-render-distance","Dynamic Render Distance",Category.PERFORMANCE,"Targets a stable FPS.",new NumberSetting("target-fps","Target FPS",120,30,360,10));
  add(m,"chunk-optimizer","Chunk Optimizer",Category.PERFORMANCE,"Optimizes chunk work.",new NumberSetting("threads","Worker Budget",2,1,8,1));
  add(m,"memory-optimizer","Memory Optimizer",Category.PERFORMANCE,"Memory controls.",new BooleanSetting("gc","GC Assist",true));
  add(m,"fast-world-loading","Fast World Loading",Category.PERFORMANCE,"Loading controls.",new BooleanSetting("preload","Preload Chunks",true));
  add(m,"smart-fps-limit","Smart FPS Limit",Category.PERFORMANCE,"FPS cap.",new NumberSetting("limit","FPS Limit",240,30,1000,10));
  add(m,"low-end-mode","Low-End Mode",Category.PERFORMANCE,"Extra performance savings.",new BooleanSetting("extra","Extra Savings",true));
  add(m,"performance-profile","Performance Profiles",Category.PERFORMANCE,"Client performance preset.",new EnumSetting<>("profile","Profile",Profile.PERFORMANCE,Profile.values()));
  add(m,"keystrokes","Keystrokes",Category.PVP,"Movement and mouse inputs.",new NumberSetting("scale","Scale",1,0.5,2,0.1));
  add(m,"cps-counter","CPS Counter",Category.PVP,"Clicks per second.",new NumberSetting("scale","Scale",1,0.5,2,0.1));
  add(m,"armor-hud","Armor HUD",Category.PVP,"Armor information.",new BooleanSetting("durability","Show Durability",true));
  add(m,"potion-hud","Potion HUD",Category.PVP,"Active effects.",new BooleanSetting("icons","Show Icons",true));
  add(m,"direction-hud","Direction HUD",Category.PVP,"Facing direction.",new BooleanSetting("axis","Show Axis",true));
  add(m,"coordinates","Coordinates",Category.PVP,"Player coordinates.",new NumberSetting("decimals","Decimals",1,0,3,1));
  add(m,"combo-counter","Combo Counter",Category.PVP,"Combo tracking.",new BooleanSetting("reset","Reset On Damage",true));
  add(m,"hit-effects","Hit Effects",Category.PVP,"Hit feedback.",new NumberSetting("duration","Duration",300,50,1000,50));
  add(m,"damage-numbers","Damage Numbers",Category.PVP,"Combat damage display.",new BooleanSetting("critical","Critical Only",false));
  add(m,"custom-crosshair","Custom Crosshair",Category.PVP,"Configurable crosshair.",new NumberSetting("size","Size",5,1,12,1),new NumberSetting("gap","Gap",2,0,8,1));
  add(m,"toggle-sprint","Toggle Sprint",Category.PVP,"Sprint toggle.",new BooleanSetting("double-tap","Double Tap",false));
  add(m,"toggle-sneak","Toggle Sneak",Category.PVP,"Sneak toggle.",new BooleanSetting("double-tap","Double Tap",false));
  add(m,"target-hud","Target HUD",Category.PVP,"Target information.",new NumberSetting("scale","Scale",1,0.5,2,0.1));
  add(m,"item-durability","Item Durability",Category.PVP,"Held item durability.",new BooleanSetting("percent","Show Percent",true));
  add(m,"tnt-timer","TNT Timer",Category.PVP,"TNT timing display.",new BooleanSetting("ticks","Show Ticks",true));
  add(m,"fps-hud","FPS",Category.HUD,"FPS display.",new BooleanSetting("shadow","Text Shadow",true));
  add(m,"ping-hud","Ping",Category.HUD,"Latency display.",new BooleanSetting("shadow","Text Shadow",true));
  add(m,"memory-hud","Memory",Category.HUD,"Memory display.",new BooleanSetting("shadow","Text Shadow",true));
  add(m,"session-stats","Session Stats",Category.HUD,"Session statistics.",new BooleanSetting("compact","Compact",true));
  add(m,"clock","Clock",Category.HUD,"Local clock.",new EnumSetting<>("format","Format",ClockFormat.TWENTY_FOUR_HOUR,ClockFormat.values()));
  add(m,"server-info","Server Info",Category.HUD,"Server information.",new BooleanSetting("address","Show Address",false));
  add(m,"zoom","Zoom",Category.VISUAL,"Camera zoom setting.",new NumberSetting("zoom","Zoom Level",3,1.5,10,0.5));
  add(m,"fullbright","Fullbright",Category.VISUAL,"Visibility setting.",new NumberSetting("brightness","Brightness",1,0.5,5,0.1));
  add(m,"no-hurt-cam","No Hurt Cam",Category.VISUAL,"Removes hurt camera.",new BooleanSetting("all","Remove All",true));
  add(m,"no-fog","No Fog",Category.VISUAL,"Fog strength.",new NumberSetting("strength","Strength",100,0,100,5));
  add(m,"block-highlight","Block Highlight",Category.VISUAL,"Target block highlight.",new NumberSetting("width","Line Width",1,1,5,1));
  add(m,"player-highlight","Player Highlight",Category.VISUAL,"Player highlight.",new BooleanSetting("through-walls","Through Walls",false));
  add(m,"weather-control","Weather Control",Category.VISUAL,"Local weather.",new EnumSetting<>("mode","Mode",WeatherMode.DEFAULT,WeatherMode.values()));
  add(m,"time-changer","Time Changer",Category.VISUAL,"Local time.",new NumberSetting("time","Time",6000,0,24000,100));
  add(m,"custom-sky","Custom Sky",Category.VISUAL,"Sky intensity.",new NumberSetting("intensity","Intensity",100,0,100,5));
  add(m,"chat-cleaner","Chat Cleaner",Category.UTILITY,"Chat cleanup.",new BooleanSetting("duplicate","Hide Duplicates",true));
  add(m,"chat-timestamps","Chat Timestamps",Category.UTILITY,"Chat timestamps.",new EnumSetting<>("format","Format",ClockFormat.TWENTY_FOUR_HOUR,ClockFormat.values()));
  add(m,"auto-gg","Auto GG",Category.UTILITY,"End-of-game message.",new BooleanSetting("enabled","Enabled",true));
  add(m,"screenshot-manager","Screenshot Manager",Category.UTILITY,"Screenshot organization.",new BooleanSetting("open-folder","Open Folder",true));
  add(m,"session-timer","Session Timer",Category.UTILITY,"Session timer.",new BooleanSetting("seconds","Show Seconds",true));
  add(m,"fps-graph","FPS Graph",Category.UTILITY,"FPS history.",new NumberSetting("seconds","History Seconds",10,3,30,1));
  add(m,"ping-graph","Ping Graph",Category.UTILITY,"Ping history.",new NumberSetting("seconds","History Seconds",10,3,30,1));
  add(m,"config-manager","Config Manager",Category.UTILITY,"Configuration saving.",new BooleanSetting("autosave","Auto Save",true));
  add(m,"server-switcher","Server Switcher",Category.MULTIPLAYER,"Server switching.",new BooleanSetting("confirm","Confirm Switch",false));
  add(m,"server-favorites","Server Favorites",Category.MULTIPLAYER,"Favorite servers.",new NumberSetting("slots","Slots",8,3,30,1));
  add(m,"quick-connect","Quick Connect",Category.MULTIPLAYER,"Saved connections.",new BooleanSetting("last-server","Remember Last",true));
  add(m,"player-counter","Player Counter",Category.MULTIPLAYER,"Online counts.",new BooleanSetting("friends","Show Friends",true));
  add(m,"notifications","Notifications",Category.CLIENT,"Client notifications.",new NumberSetting("duration","Duration",3000,500,10000,500));
  add(m,"module-search","Module Search",Category.CLIENT,"Module search.",new BooleanSetting("descriptions","Show Descriptions",true));
  add(m,"theme-engine","Theme Engine",Category.CLIENT,"Yazoni theme.",new EnumSetting<>("theme","Theme",Theme.ORANGE,Theme.values()));
  add(m,"hud-editor","HUD Editor",Category.CLIENT,"HUD positioning.",new NumberSetting("grid","Grid Size",16,4,64,4));
  add(m,"profiles","Profiles",Category.CLIENT,"Configuration profiles.",new EnumSetting<>("profile","Profile",Profile.DEFAULT,Profile.values()));
 }
 private static void add(ModuleManager m,String id,String n,Category c,String d,Setting<?>...s){Module x=new Module(id,n,c,d){};for(Setting<?> a:s)x.setting(a);m.register(x);}
 private enum Profile{DEFAULT,PERFORMANCE,PVP,CASUAL} private enum ClockFormat{TWENTY_FOUR_HOUR,TWELVE_HOUR} private enum WeatherMode{DEFAULT,CLEAR,RAIN,THUNDER} private enum Theme{ORANGE,BLUE,PURPLE,MONO}
}
