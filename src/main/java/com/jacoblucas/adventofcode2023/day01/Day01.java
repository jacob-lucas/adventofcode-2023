package com.jacoblucas.adventofcode2023.day01;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day01 {
    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day01-input.txt");

        // part 1
        int calibrationValueSum = input.stream()
                .mapToInt(Day01::getCalibrationValue)
                .filter(i -> i > 0)
                .sum();
        System.out.println(calibrationValueSum);
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
}
