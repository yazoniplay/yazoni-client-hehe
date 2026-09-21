package com.yazoni.client.module;

public final class NumberSetting extends Setting<Double> {
    private final double min;
    private final double max;
    private final double step;

    public NumberSetting(String id, String name, double defaultValue, double min, double max, double step) {
        super(id, name, defaultValue);
        this.min = min;
        this.max = max;
        this.step = step;
    }

    @Override
    public void value(Double value) {
        super.value(Math.max(min, Math.min(max, value)));
    }

    public double min() { return min; }
    public double max() { return max; }
    public double step() { return step; }
}
