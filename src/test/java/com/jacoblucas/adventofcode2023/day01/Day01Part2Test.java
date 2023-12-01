package com.jacoblucas.adventofcode2023.day01;

import com.google.common.collect.ImmutableList;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.jacoblucas.adventofcode2023.day01.Day01.SEARCH_SPACE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Day01Part2Test {
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
        SEARCH_SPACE.put("one", 1);
        SEARCH_SPACE.put("two", 2);
        SEARCH_SPACE.put("three", 3);
        SEARCH_SPACE.put("four", 4);
        SEARCH_SPACE.put("five", 5);
        SEARCH_SPACE.put("six", 6);
        SEARCH_SPACE.put("seven", 7);
        SEARCH_SPACE.put("eight", 8);
        SEARCH_SPACE.put("nine", 9);
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
        assertThat(Day01.getCalibrationValue("acthreebde"), is(33));
    }

    @Test
    public void testStringTwoNumbers() {
        assertThat(Day01.getCalibrationValue("acthreebdsevene"), is(37));
    }

    @Test
    public void testStringThreeNumbers() {
        assertThat(Day01.getCalibrationValue("acninebbbbbbbfivedtwoe"), is(92));
    }

    @Test
    public void testPart2Examples() {
        assertThat(Day01.getCalibrationValue("two1nine"), is(29));
        assertThat(Day01.getCalibrationValue("eightwothree"), is(83));
        assertThat(Day01.getCalibrationValue("abcone2threexyz"), is(13));
        assertThat(Day01.getCalibrationValue("xtwone3four"), is(24));
        assertThat(Day01.getCalibrationValue("4nineeightseven2"), is(42));
        assertThat(Day01.getCalibrationValue("zoneight234"), is(14));
        assertThat(Day01.getCalibrationValue("7pqrstsixteen"), is(76));
    }

    @Test
    public void testRepeatedValues() {
        assertThat(Day01.getCalibrationValue("9seveneightltwo59rnqh"), is(99));
    }

    @Test
    public void testPart2Input() {
        final List<String> input = ImmutableList.of(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen");
        assertThat(Day01.sum(input, Day01::getCalibrationValue), is(281));
    }
}
