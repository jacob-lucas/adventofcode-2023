package com.jacoblucas.adventofcode2023.day01;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

public class Day01 {
    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day01-input.txt");

        // part 1
        int calibrationValueSumPart1 = getCalibrationValue(input, Day01::getCalibrationValue);
        System.out.println(calibrationValueSumPart1);

        // part 2
        int calibrationValueSumPart2 = getCalibrationValue(input, Day01::getCalibrationValueV2);
        System.out.println(calibrationValueSumPart2);
    }

    public static int getCalibrationValue(final List<String> input, final ToIntFunction<String> valueMapper) {
        return input.stream()
                .mapToInt(valueMapper)
                .filter(i -> i > 0)
                .sum();
    }

    public static int getCalibrationValue(final String string) {
        if (string == null || string.isEmpty()) {
            return -1;
        }

        char firstDigit = findFirstDigit(string);
        if (firstDigit == '\0') {
            return -1;
        }
        char lastDigit = findFirstDigit(new StringBuilder(string).reverse().toString());

        return Integer.parseInt("" + firstDigit + lastDigit);
    }

    private static char findFirstDigit(final String string) {
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                return c;
            }
        }

        return '\0';
    }

    public static int getCalibrationValueV2(final String string) {
        if (string == null || string.isEmpty()) {
            return -1;
        }

        int firstDigit = findDigit(string, 1);
        if (firstDigit == -1) {
            return -1;
        }
        int lastDigit = findDigit(string, 0);

        System.out.println(string + ", first=" + firstDigit + ", last=" + lastDigit);

        return Integer.parseInt("" + firstDigit + lastDigit);
    }

    // handles string representations of numbers as well as digits occurring within the string
    // flag = 1 --> find first, flag = 0 --> find last
    private static int findDigit(final String string, final int flag) {
        final Map<String, Integer> searchSpace = new HashMap<>();
        searchSpace.put("1", 1);
        searchSpace.put("one", 1);
        searchSpace.put("2", 2);
        searchSpace.put("two", 2);
        searchSpace.put("3", 3);
        searchSpace.put("three", 3);
        searchSpace.put("4", 4);
        searchSpace.put("four", 4);
        searchSpace.put("5", 5);
        searchSpace.put("five", 5);
        searchSpace.put("6", 6);
        searchSpace.put("six", 6);
        searchSpace.put("7", 7);
        searchSpace.put("seven", 7);
        searchSpace.put("8", 8);
        searchSpace.put("eight", 8);
        searchSpace.put("9", 9);
        searchSpace.put("nine", 9);

        int value = -1;
        if (flag == 1) {
            int earliest = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> s : searchSpace.entrySet()) {
                int i = string.indexOf(s.getKey());
                if (i >= 0 && i < earliest) {
                    earliest = i;
                    value = s.getValue();
                }
            }
        } else {
            int latest = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> s : searchSpace.entrySet()) {
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
