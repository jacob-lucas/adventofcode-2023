package com.jacoblucas.adventofcode2023.day04;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.List;

public record Scratchcard(int id, List<Integer> winningNumbers) {
    public int score(final List<Integer> numbers) {
        int hits = Sets.intersection(new HashSet<>(winningNumbers), new HashSet<>(numbers)).size();
        return hits == 0 ? 0 : (int) Math.pow(2, hits - 1);
    }

    public static Scratchcard parse(final String input) {
        final String[] parts = input.split(":");
        int id = Integer.parseInt(parts[0].substring(4).trim());
        List<Integer> winningNumbers = Day04.toIntList(parts[1].split("\\|")[0]);
        return new Scratchcard(id, winningNumbers);
    }
}
