package com.jacoblucas.adventofcode2023.day01;

import com.google.common.collect.ImmutableList;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.jacoblucas.adventofcode2023.day01.Day01.SEARCH_SPACE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Day01Part1Test {
    @BeforeClass
    public static void setUp() {
        SEARCH_SPACE.put("1", 1);
        SEARCH_SPACE.put("2", 2);
        SEARCH_SPACE.put("3", 3);
        SEARCH_SPACE.put("4", 4);
        SEARCH_SPACE.put("5", 5);
        SEARCH_SPACE.put("6", 6);
        SEARCH_SPACE.put("7", 7);
        SEARCH_SPACE.put("8", 8);
        SEARCH_SPACE.put("9", 9);
    }

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
        assertThat(Day01.getCalibrationValue("ac9bbbbbbb5de"), is(95));
    }

    @Test
    public void testRepeatedValues() {
        assertThat(Day01.getCalibrationValue("9seveneightltwo59rnqh"), is(99));
    }

    @Test
    public void testPart1Input() {
        final List<String> input = ImmutableList.of(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet");
        assertThat(Day01.sum(input, Day01::getCalibrationValue), is(142));
    }
}
