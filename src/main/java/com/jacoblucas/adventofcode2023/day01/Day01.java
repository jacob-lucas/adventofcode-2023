package com.jacoblucas.adventofcode2023.day01;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

public class Day01 {
    protected static final Map<String, Integer> SEARCH_SPACE = new HashMap<>();

    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day01-input.txt");

        SEARCH_SPACE.put("1", 1);
        SEARCH_SPACE.put("2", 2);
        SEARCH_SPACE.put("3", 3);
        SEARCH_SPACE.put("4", 4);
        SEARCH_SPACE.put("5", 5);
        SEARCH_SPACE.put("6", 6);
        SEARCH_SPACE.put("7", 7);
        SEARCH_SPACE.put("8", 8);
        SEARCH_SPACE.put("9", 9);

        // part 1
        int calibrationValueSumPart1 = sum(input, Day01::getCalibrationValue);
        System.out.println(calibrationValueSumPart1);

        SEARCH_SPACE.put("one", 1);
        SEARCH_SPACE.put("two", 2);
        SEARCH_SPACE.put("three", 3);
        SEARCH_SPACE.put("four", 4);
        SEARCH_SPACE.put("five", 5);
        SEARCH_SPACE.put("six", 6);
        SEARCH_SPACE.put("seven", 7);
        SEARCH_SPACE.put("eight", 8);
        SEARCH_SPACE.put("nine", 9);

        // part 2
        int calibrationValueSumPart2 = sum(input, Day01::getCalibrationValue);
        System.out.println(calibrationValueSumPart2);
    }

    public static int sum(final List<String> input, final ToIntFunction<String> valueMapper) {
        return input.stream()
                .mapToInt(valueMapper)
                .filter(i -> i > 0)
                .sum();
    }

    public static int getCalibrationValue(final String string) {
        if (string == null || string.isEmpty()) {
            return -1;
        }

        int firstDigit = findDigit(string, 1);
        if (firstDigit == -1) {
            return -1;
        }
        int lastDigit = findDigit(string, 0);

        return Integer.parseInt("" + firstDigit + lastDigit);
    }

    // handles string representations of numbers as well as digits occurring within the string
    // flag = 1 --> find first, flag = 0 --> find last
    private static int findDigit(final String string, final int flag) {
        int value = -1;
        if (flag == 1) {
            int earliest = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> s : SEARCH_SPACE.entrySet()) {
                int i = string.indexOf(s.getKey());
                if (i >= 0 && i < earliest) {
                    earliest = i;
                    value = s.getValue();
                }
            }
        } else {
            int latest = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> s : SEARCH_SPACE.entrySet()) {
                int i = string.lastIndexOf(s.getKey());
                if (i >= 0 && i > latest) {
                    latest = i;
                    value = s.getValue();
                }
            }
        }

        return value;
    }
}
