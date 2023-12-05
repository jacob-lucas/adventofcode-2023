package com.jacoblucas.adventofcode2023.day05;

import com.jacoblucas.adventofcode2023.utils.InputReader;
import com.jacoblucas.adventofcode2023.utils.Pair;

import java.io.IOException;
import java.util.*;
import java.util.stream.LongStream;

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

        // Part 2
        final List<Pair<Long, Long>> seedRanges = new ArrayList<>();
        for (int i = 0; i < seeds.size(); i += 2) {
            seedRanges.add(new Pair<>(seeds.get(i), seeds.get(i+1)));
        }

        // This takes ~30 minutes... :/
        long lowestLocationNumberFromRanges = seedRanges.stream()
                .mapToLong(p -> {
                    System.out.println(p);
                    return LongStream.range(p.first(), p.first() + p.second() + 1)
                            .map(almanac::getLocationForSeed)
                            .min()
                            .getAsLong();
                })
                .min()
                .getAsLong();
        System.out.println(lowestLocationNumberFromRanges);
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
