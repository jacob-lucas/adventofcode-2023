package com.jacoblucas.adventofcode2023.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {
    @Test
    public void testManhattanDistance() {
        final Pair<Integer, Integer> a = new Pair<>(-7, -4);
        final Pair<Integer, Integer> b = new Pair<>(17, 6);
        final Pair<Integer, Integer> c = new Pair<>(0, 0);
        final Pair<Integer, Integer> d = new Pair<>(3, 3);
        final Pair<Integer, Integer> e = new Pair<>(1, 1);
        final Pair<Integer, Integer> f = new Pair<>(9, 9);

        assertThat(Calculator.manhattanDistance(a, b), is(34));
        assertThat(Calculator.manhattanDistance(b, a), is(34));
        assertThat(Calculator.manhattanDistance(c, d), is(6));
        assertThat(Calculator.manhattanDistance(d, c), is(6));
        assertThat(Calculator.manhattanDistance(d, d), is(0));
        assertThat(Calculator.manhattanDistance(e, f), is(16));
    }
}
