package com.jacoblucas.adventofcode2023.utils;

public record Pair <T, U> (T first, U second) {
    @Override
    public String toString() {
        return "(" + first.toString() + "," + second.toString() + ")";
    }
}
