package com.yazoni.client.module;

public final class BooleanSetting extends Setting<Boolean> {
    public BooleanSetting(String id, String name, boolean defaultValue) {
        super(id, name, defaultValue);
    }
    public void toggle() { value(!value()); }
}
