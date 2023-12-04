package com.jacoblucas.adventofcode2023.day04;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day04 {
    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day04-input.txt");

        // Part 1
        int points = 0;
        for (String str : input) {
            final Scratchcard sc = Scratchcard.parse(str);
            points += sc.score(toIntList(str.split("\\|")[1]));
        }
        System.out.println(points);
    }

    public static List<Integer> toIntList(final String input) {
        return Arrays.stream(input.trim().split(" "))
                .map(str -> {
                    try {
                        return Integer.parseInt(str);
                    } catch (NumberFormatException nfe) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .toList();
    }
}
