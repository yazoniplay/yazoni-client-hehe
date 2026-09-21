package com.yazoni.client.module;

public final class EnumSetting<E extends Enum<E>> extends Setting<E> {
    private final E[] values;

    public EnumSetting(String id, String name, E defaultValue, E[] values) {
        super(id, name, defaultValue);
        this.values = values.clone();
    }

    public E[] values() { return values.clone(); }
}
