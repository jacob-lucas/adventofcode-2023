package com.jacoblucas.adventofcode2023.day02;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day02 {
    public static void main(String[] args) throws IOException {
        final List<Game> games = InputReader.read("day02-input.txt")
                .stream()
                .map(Game::parse)
                .toList();

        // Part 1
        final List<Game> possibleGames = games.stream()
                .filter(g -> g.isPossible(12, 13, 14))
                .toList();

        final int idSum = possibleGames.stream().mapToInt(Game::id).sum();
        System.out.println(idSum);

        // Part 2
        final int powerSum = games.stream()
                .mapToInt(Game::power)
                .sum();
        System.out.println(powerSum);
    }
}
