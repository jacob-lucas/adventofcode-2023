package com.jacoblucas.adventofcode2023.day05;

public enum Category {
    SEED,
    SOIL,
    FERTILIZER,
    WATER,
    LIGHT,
    TEMPERATURE,
    HUMIDITY,
    LOCATION;

    public Category next() {
        int next = ordinal() + 1;
        return next < values().length ? Category.values()[next] : null;
    }
}
