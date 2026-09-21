package com.yazoni.client.module;

public enum Category {
    PERFORMANCE("Performance"),
    PVP("PvP"),
    HUD("HUD"),
    VISUAL("Visual"),
    UTILITY("Utility"),
    MULTIPLAYER("Multiplayer"),
    CLIENT("Client");

    private final String displayName;
    Category(String displayName) { this.displayName = displayName; }
    public String displayName() { return displayName; }
}
