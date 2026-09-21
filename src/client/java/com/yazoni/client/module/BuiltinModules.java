package com.yazoni.client.module;

public final class BuiltinModules {
    private BuiltinModules() {}

    public static void registerAll(ModuleManager manager) {
        register(manager, "fps-boost", "FPS Boost", Category.PERFORMANCE, "General client-side performance optimizations.");
        register(manager, "render-optimizer", "Render Optimizer", Category.PERFORMANCE, "Reduces unnecessary rendering work.");
        register(manager, "entity-optimizer", "Entity Optimizer", Category.PERFORMANCE, "Optimizes entity rendering and visibility.");
        register(manager, "particle-optimizer", "Particle Optimizer", Category.PERFORMANCE, "Controls and reduces expensive particle work.");
        register(manager, "animation-optimizer", "Animation Optimizer", Category.PERFORMANCE, "Reduces unnecessary animation updates.");
        register(manager, "dynamic-render-distance", "Dynamic Render Distance", Category.PERFORMANCE, "Adjusts render distance around a performance target.");
        register(manager, "chunk-optimizer", "Chunk Optimizer", Category.PERFORMANCE, "Optimizes chunk-related client work.");
        register(manager, "memory-optimizer", "Memory Optimizer", Category.PERFORMANCE, "Keeps client memory usage under control.");
        register(manager, "fast-world-loading", "Fast World Loading", Category.PERFORMANCE, "Improves client loading behavior.");
        register(manager, "smart-fps-limit", "Smart FPS Limit", Category.PERFORMANCE, "Applies an adaptive FPS cap.");
        register(manager, "low-end-mode", "Low-End Mode", Category.PERFORMANCE, "One-click conservative performance profile.");
        register(manager, "performance-profile", "Performance Profiles", Category.PERFORMANCE, "Switch between Balanced, Performance and Custom.");

        register(manager, "keystrokes", "Keystrokes", Category.PVP, "Displays movement and mouse inputs.");
        register(manager, "cps-counter", "CPS Counter", Category.PVP, "Displays clicks per second.");
        register(manager, "armor-hud", "Armor HUD", Category.PVP, "Displays equipped armor and durability.");
        register(manager, "potion-hud", "Potion HUD", Category.PVP, "Displays active potion effects.");
        register(manager, "direction-hud", "Direction HUD", Category.PVP, "Displays the player's facing direction.");
        register(manager, "coordinates", "Coordinates", Category.PVP, "Displays player coordinates.");
        register(manager, "combo-counter", "Combo Counter", Category.PVP, "Tracks consecutive hits.");
        register(manager, "hit-effects", "Hit Effects", Category.PVP, "Adds configurable visual feedback for hits.");
        register(manager, "damage-numbers", "Damage Numbers", Category.PVP, "Displays configurable combat damage information.");
        register(manager, "custom-crosshair", "Custom Crosshair", Category.PVP, "Provides a configurable crosshair.");
        register(manager, "toggle-sprint", "Toggle Sprint", Category.PVP, "Toggles sprint without holding the key.");
        register(manager, "toggle-sneak", "Toggle Sneak", Category.PVP, "Toggles sneak without holding the key.");
        register(manager, "target-hud", "Target HUD", Category.PVP, "Displays information about the current target.");
        register(manager, "item-durability", "Item Durability", Category.PVP, "Displays held-item durability.");
        register(manager, "tnt-timer", "TNT Timer", Category.PVP, "Displays nearby TNT timing information.");

        register(manager, "fps-hud", "FPS", Category.HUD, "Displays current FPS.");
        register(manager, "ping-hud", "Ping", Category.HUD, "Displays network latency.");
        register(manager, "memory-hud", "Memory", Category.HUD, "Displays client memory usage.");
        register(manager, "session-stats", "Session Stats", Category.HUD, "Displays useful session statistics.");
        register(manager, "clock", "Clock", Category.HUD, "Displays the local clock.");
        register(manager, "server-info", "Server Info", Category.HUD, "Displays server and connection information.");

        register(manager, "zoom", "Zoom", Category.VISUAL, "Smooth configurable camera zoom.");
        register(manager, "fullbright", "Fullbright", Category.VISUAL, "Improves visibility in dark areas.");
        register(manager, "no-hurt-cam", "No Hurt Cam", Category.VISUAL, "Removes camera hurt movement.");
        register(manager, "no-fog", "No Fog", Category.VISUAL, "Reduces or removes environmental fog.");
        register(manager, "block-highlight", "Block Highlight", Category.VISUAL, "Highlights the targeted block.");
        register(manager, "player-highlight", "Player Highlight", Category.VISUAL, "Highlights selected players.");
        register(manager, "weather-control", "Weather Control", Category.VISUAL, "Controls local weather visuals.");
        register(manager, "time-changer", "Time Changer", Category.VISUAL, "Changes the local visual time.");
        register(manager, "custom-sky", "Custom Sky", Category.VISUAL, "Provides configurable sky visuals.");

        register(manager, "chat-cleaner", "Chat Cleaner", Category.UTILITY, "Filters unnecessary chat clutter.");
        register(manager, "chat-timestamps", "Chat Timestamps", Category.UTILITY, "Adds timestamps to chat messages.");
        register(manager, "auto-gg", "Auto GG", Category.UTILITY, "Sends a configurable end-of-game message.");
        register(manager, "screenshot-manager", "Screenshot Manager", Category.UTILITY, "Improves screenshot organization.");
        register(manager, "session-timer", "Session Timer", Category.UTILITY, "Tracks the current play session.");
        register(manager, "fps-graph", "FPS Graph", Category.UTILITY, "Displays FPS history.");
        register(manager, "ping-graph", "Ping Graph", Category.UTILITY, "Displays latency history.");
        register(manager, "config-manager", "Config Manager", Category.UTILITY, "Saves and loads Yazoni configurations.");

        register(manager, "server-switcher", "Server Switcher", Category.MULTIPLAYER, "Quickly switch between saved servers.");
        register(manager, "server-favorites", "Server Favorites", Category.MULTIPLAYER, "Keeps a list of favorite servers.");
        register(manager, "quick-connect", "Quick Connect", Category.MULTIPLAYER, "Provides fast access to saved connections.");
        register(manager, "player-counter", "Player Counter", Category.MULTIPLAYER, "Displays online player counts.");

        register(manager, "notifications", "Notifications", Category.CLIENT, "Shows compact Yazoni notifications.");
        register(manager, "module-search", "Module Search", Category.CLIENT, "Searches all Yazoni modules.");
        register(manager, "theme-engine", "Theme Engine", Category.CLIENT, "Controls Yazoni colors, spacing and visual style.");
        register(manager, "hud-editor", "HUD Editor", Category.CLIENT, "Drag and position HUD elements.");
        register(manager, "profiles", "Profiles", Category.CLIENT, "Switch between complete client configurations.");
    }

    private static void register(ModuleManager manager, String id, String name, Category category, String description) {
        manager.register(new Module(id, name, category, description) {});
    }
}
