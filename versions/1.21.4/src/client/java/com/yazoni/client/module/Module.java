package com.yazoni.client.module;
import java.util.*;
public abstract class Module {
    private final String id,name,description; private final Category category;
    private final List<Setting<?>> settings=new ArrayList<>(); private boolean enabled; private int keybind;
    protected Module(String id,String name,Category category,String description){this.id=id;this.name=name;this.category=category;this.description=description;}
    public final void setEnabled(boolean enabled){if(this.enabled==enabled)return;this.enabled=enabled;if(enabled)onEnable();else onDisable();}
    public final void toggle(){setEnabled(!enabled);} public void onEnable(){} public void onDisable(){} public void onTick(){}
    protected final <T extends Setting<?>> T setting(T s){settings.add(s);return s;}
    public String id(){return id;} public String name(){return name;} public Category category(){return category;} public String description(){return description;}
    public boolean enabled(){return enabled;} public int keybind(){return keybind;} public void keybind(int k){keybind=k;}
    public List<Setting<?>> settings(){return Collections.unmodifiableList(settings);}
}
