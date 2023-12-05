package com.jacoblucas.adventofcode2023.day05;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day05 {
    public static void main(String[] args) throws IOException {
        final List<List<String>> input = InputReader.readGroups("day05-input.txt");

        final List<Long> seeds = toLongList(input.get(0).get(0).split(":")[1]);
        final Almanac almanac = Almanac.parse(input);

        // Part 1
        long lowestLocationNumber = seeds.stream()
                .mapToLong(almanac::getLocationForSeed)
                .min()
                .getAsLong();
        System.out.println(lowestLocationNumber);
    }

    public static List<Long> toLongList(final String input) {
        return Arrays.stream(input.trim().split(" "))
                .map(str -> {
                    try {
                        return Long.parseLong(str);
                    } catch (NumberFormatException nfe) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .toList();
    }
}
