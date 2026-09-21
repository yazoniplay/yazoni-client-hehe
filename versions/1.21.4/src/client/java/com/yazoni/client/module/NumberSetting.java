package com.yazoni.client.module;
public final class NumberSetting extends Setting<Double>{private final double min,max,step;
public NumberSetting(String id,String name,double def,double min,double max,double step){super(id,name,def);this.min=min;this.max=max;this.step=step;}
@Override public void value(Double v){super.value(Math.max(min,Math.min(max,v)));}public double min(){return min;}public double max(){return max;}public double step(){return step;}}
