package com.jacoblucas.adventofcode2023.day01;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Day01Test {
    @Test
    public void testNullString() {
        assertThat(Day01.getCalibrationValue(null), is(-1));
    }

    @Test
    public void testEmptyString() {
        assertThat(Day01.getCalibrationValue(""), is(-1));
    }

    @Test
    public void testStringWithoutNumbers() {
        assertThat(Day01.getCalibrationValue("acbde"), is(-1));
    }

    @Test
    public void testStringOneNumber() {
        assertThat(Day01.getCalibrationValue("ac3bde"), is(33));
    }

    @Test
    public void testStringTwoNumbers() {
        assertThat(Day01.getCalibrationValue("ac3bd7e"), is(37));
    }

    @Test
    public void testStringThreeNumbers() {
        assertThat(Day01.getCalibrationValue("ac9bbbbbbb5d0e"), is(90));
    }
}
