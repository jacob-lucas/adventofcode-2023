package com.jacoblucas.adventofcode2023.day04;

import com.google.common.collect.Sets;
import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Day04 {
    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day04-input.txt");

        // ID -> Scratchcard
        final Map<Integer, Scratchcard> scratchcardMap = new HashMap<>();

        // Scratchcard -> count
        final Map<Scratchcard, Integer> pile = new HashMap<>();

        // Part 1
        int points = 0;
        for (String str : input) {
            final Scratchcard sc = Scratchcard.parse(str);
            scratchcardMap.put(sc.id(), sc);
            points += sc.score(toIntList(str.split("\\|")[1]));
        }
        System.out.println(points);

        // Part 2 -- this can be optimised to not store copies of all the cards
        final Deque<Scratchcard> scratchcardQueue = new ArrayDeque<>();
        IntStream.range(1, input.size() + 1).forEach(i -> scratchcardQueue.add(scratchcardMap.get(i)));
        while (!scratchcardQueue.isEmpty()) {
            Scratchcard scratchcard = scratchcardQueue.poll();
            pile.put(scratchcard, pile.getOrDefault(scratchcard, 0) + 1);

            int copies = Sets.intersection(
                    new HashSet<>(scratchcard.winningNumbers()),
                    new HashSet<>(toIntList(input.get(scratchcard.id() - 1).split("\\|")[1]))).size();
            for (int i = scratchcard.id() + copies; i > scratchcard.id(); i--) {
                scratchcardQueue.addFirst(scratchcardMap.get(i));
            }
        }
        System.out.println(pile.values().stream().mapToInt(Integer::valueOf).sum());
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
