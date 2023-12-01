package com.jacoblucas.adventofcode2023.day01;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Day01Test {
    @Test
    public void testNullString() {
        assertThat(Day01.getCalibrationValue(null), is(-1));
    }
    @Test
    public void testNullStringV2() {
        assertThat(Day01.getCalibrationValueV2(null), is(-1));
    }

    @Test
    public void testEmptyString() {
        assertThat(Day01.getCalibrationValue(""), is(-1));
    }

    @Test
    public void testEmptyStringV2() {
        assertThat(Day01.getCalibrationValueV2(""), is(-1));
    }

    @Test
    public void testStringWithoutNumbers() {
        assertThat(Day01.getCalibrationValue("acbde"), is(-1));
    }

    @Test
    public void testStringWithoutNumbersV2() {
        assertThat(Day01.getCalibrationValueV2("acbde"), is(-1));
    }

    @Test
    public void testStringOneNumber() {
        assertThat(Day01.getCalibrationValue("ac3bde"), is(33));
    }

    @Test
    public void testStringOneNumberV2() {
        assertThat(Day01.getCalibrationValueV2("acthreebde"), is(33));
    }

    @Test
    public void testStringTwoNumbers() {
        assertThat(Day01.getCalibrationValue("ac3bd7e"), is(37));
    }

    @Test
    public void testStringTwoNumbersV2() {
        assertThat(Day01.getCalibrationValueV2("acthreebdsevene"), is(37));
    }

    @Test
    public void testStringThreeNumbers() {
        assertThat(Day01.getCalibrationValue("ac9bbbbbbb5d0e"), is(90));
    }

    @Test
    public void testStringThreeNumbersV2() {
        assertThat(Day01.getCalibrationValueV2("acninebbbbbbbfivedtwoe"), is(92));
    }

    @Test
    public void testPart2Examples() {
        assertThat(Day01.getCalibrationValueV2("two1nine"), is(29));
        assertThat(Day01.getCalibrationValueV2("eightwothree"), is(83));
        assertThat(Day01.getCalibrationValueV2("abcone2threexyz"), is(13));
        assertThat(Day01.getCalibrationValueV2("xtwone3four"), is(24));
        assertThat(Day01.getCalibrationValueV2("4nineeightseven2"), is(42));
        assertThat(Day01.getCalibrationValueV2("zoneight234"), is(14));
        assertThat(Day01.getCalibrationValueV2("7pqrstsixteen"), is(76));
    }

    @Test
    public void testRepeatedValues() {
        assertThat(Day01.getCalibrationValue("9seveneightltwo59rnqh"), is(99));
    }

    @Test
    public void testRepeatedValuesV2() {
        assertThat(Day01.getCalibrationValueV2("9seveneightltwo59rnqh"), is(99));
    }

    @Test
    public void testPart1Input() {
        final List<String> input = ImmutableList.of(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet");
        assertThat(Day01.getCalibrationValue(input, Day01::getCalibrationValue), is(142));
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
        assertThat(Day01.getCalibrationValue(input, Day01::getCalibrationValueV2), is(281));
    }
}
