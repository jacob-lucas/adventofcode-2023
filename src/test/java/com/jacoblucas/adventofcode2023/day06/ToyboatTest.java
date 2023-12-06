package com.jacoblucas.adventofcode2023.day06;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ToyboatTest {
    private Toyboat toyboat;

    @Before
    public void setUp() {
        toyboat = new Toyboat(1);
    }

    @Test
    public void testDistance() {
        Race race = Day06Test.RACE1;
        assertThat(toyboat.distance(0, race), is(0L));
        assertThat(toyboat.distance(1, race), is(6L));
        assertThat(toyboat.distance(2, race), is(10L));
        assertThat(toyboat.distance(3, race), is(12L));
        assertThat(toyboat.distance(4, race), is(12L));
        assertThat(toyboat.distance(5, race), is(10L));
        assertThat(toyboat.distance(6, race), is(6L));
        assertThat(toyboat.distance(7, race), is(0L));
    }

    @Test
    public void testGetWaysToWin() {
        assertThat(toyboat.getWaysToWin(Day06Test.RACE1), is(4L));
        assertThat(toyboat.getWaysToWin(Day06Test.RACE2), is(8L));
        assertThat(toyboat.getWaysToWin(Day06Test.RACE3), is(9L));
    }
}
