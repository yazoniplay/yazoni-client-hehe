package com.yazoni.client.module;
public final class EnumSetting<E extends Enum<E>> extends Setting<E>{private final E[] values;
public EnumSetting(String id,String name,E def,E[] values){super(id,name,def);this.values=values.clone();}public E[] values(){return values.clone();}}
