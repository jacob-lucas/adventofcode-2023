package com.jacoblucas.adventofcode2023.day11;

import com.jacoblucas.adventofcode2023.utils.Calculator;
import com.jacoblucas.adventofcode2023.utils.InputReader;
import com.jacoblucas.adventofcode2023.utils.Pair;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day11 {
    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day11-input.txt");
//        final List<String> input = InputReader.readFile("src/test/resources/", "day11-test-input.txt");
        final Image image = new Image(input);
        image.expand();

        // Part 1
        final List<Galaxy> galaxies = image.getGalaxies();
        Set<Pair<Galaxy, Galaxy>> galaxyPairs = new HashSet<>();
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = 0; j < galaxies.size(); j++) {
                if (i == j) {
                    continue;
                }
                Pair<Galaxy, Galaxy> p1 = new Pair<>(galaxies.get(i), galaxies.get(j));
                Pair<Galaxy, Galaxy> p2 = new Pair<>(galaxies.get(j), galaxies.get(i));
                if (!galaxyPairs.contains(p1) && !galaxyPairs.contains(p2)) {
                    galaxyPairs.add(p1);
                }
            }
        }
        int shortestPathSum = galaxyPairs.stream()
                .mapToInt(gs -> Calculator.manhattanDistance(gs.first().coordinates(), gs.second().coordinates()))
                .sum();
        System.out.println(shortestPathSum);
    }
}
