package com.jacoblucas.adventofcode2023.day04;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScratchcardTest {
    @Test
    public void testParse() {
        Scratchcard sc = Scratchcard.parse("Card   1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        assertThat(sc, is(new Scratchcard(1, ImmutableList.of(41, 48, 83, 86, 17))));
    }

    @Test
    public void testScore() {
        assertThat(new Scratchcard(1, ImmutableList.of(41, 48, 83, 86, 17)).score(ImmutableList.of(83, 86, 6, 31, 17, 9, 48, 53)), is(8));
        assertThat(new Scratchcard(2, ImmutableList.of(13, 32, 20, 16, 61)).score(ImmutableList.of(61, 30, 68, 82, 17, 32, 24, 19)), is(2));
        assertThat(new Scratchcard(3, ImmutableList.of(1, 21, 53, 59, 44)).score(ImmutableList.of(69, 82, 63, 72, 16, 21, 14, 1)), is(2));
        assertThat(new Scratchcard(4, ImmutableList.of(41, 92, 73, 84, 69)).score(ImmutableList.of(59, 84, 76, 51, 58, 5, 54, 83)), is(1));
        assertThat(new Scratchcard(5, ImmutableList.of(87, 83, 26, 28, 32)).score(ImmutableList.of(88, 30, 70, 12, 93, 22, 82, 36)), is(0));
        assertThat(new Scratchcard(6, ImmutableList.of(31, 18, 13, 56, 72)).score(ImmutableList.of(74, 77, 10, 23, 35, 67, 36, 11)), is(0));
    }
}
