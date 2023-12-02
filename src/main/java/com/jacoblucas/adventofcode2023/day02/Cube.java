package com.jacoblucas.adventofcode2023.day02;

public enum Cube {
    BLUE,
    RED,
    GREEN;

    public static Cube parse(final String str) {
        try {
            return Cube.valueOf(str.toUpperCase());
        } catch (final Throwable t) {
            return null;
        }
    }
}
