package com.yazoni.client.module;
public abstract class Setting<T>{private final String id,name;private final T defaultValue;private T value;
protected Setting(String id,String name,T def){this.id=id;this.name=name;defaultValue=def;value=def;}
public String id(){return id;}public String name(){return name;}public T value(){return value;}public T defaultValue(){return defaultValue;}
public void value(T v){value=v;}public void reset(){value=defaultValue;}}
