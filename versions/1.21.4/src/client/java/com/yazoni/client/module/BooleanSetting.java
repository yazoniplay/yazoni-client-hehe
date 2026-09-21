package com.yazoni.client.module;
public final class BooleanSetting extends Setting<Boolean>{public BooleanSetting(String id,String name,boolean def){super(id,name,def);}public void toggle(){value(!value());}}
