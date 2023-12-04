package com.jacoblucas.adventofcode2023.day04;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Day04Test {
    @Test
    public void testToIntList() {
        assertThat(Day04.toIntList(" 41 48 83 86 17 "), is(ImmutableList.of(41, 48, 83, 86, 17)));
        assertThat(Day04.toIntList(" 83 86  6 31 17  9 48 53"), is(ImmutableList.of(83, 86, 6, 31, 17, 9, 48, 53)));
    }
}
