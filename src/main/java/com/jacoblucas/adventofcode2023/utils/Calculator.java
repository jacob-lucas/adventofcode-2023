package com.jacoblucas.adventofcode2023.utils;

public class Calculator {
    public static int manhattanDistance(final Pair<Integer, Integer> p1, final Pair<Integer, Integer> p2) {
        return Math.abs(p1.first() - p2.first()) + Math.abs(p1.second() - p2.second());
    }
}
