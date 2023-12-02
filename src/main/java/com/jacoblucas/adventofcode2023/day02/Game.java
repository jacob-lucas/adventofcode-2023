package com.jacoblucas.adventofcode2023.day02;

import com.jacoblucas.adventofcode2023.utils.Pair;

import java.util.Arrays;
import java.util.List;

public record Game(int id, List<List<Pair<Integer, Cube>>> cubeSets) {
    // Returns true if the game is possible given the count of red, green, and blue cubes provided.
    public boolean isPossible(int redCount, int greenCount, int blueCount) {
        return cubeSets.stream()
                .allMatch(cs -> cs.stream()
                        .allMatch(p -> switch (p.second()) {
                            case RED -> p.first() <= redCount;
                            case GREEN -> p.first() <= greenCount;
                            case BLUE -> p.first() <= blueCount;
                        }));
    }

    public int getMinimumCubes(final Cube cube) {
        int max = Integer.MIN_VALUE;
        for (List<Pair<Integer, Cube>> handful : cubeSets) {
            for (Pair<Integer, Cube> cubes : handful) {
                if (cubes.second() == cube) {
                    if (cubes.first() > max) {
                        max = cubes.first();
                    }
                }
            }
        }
        return max;
    }

    public int power() {
        return getMinimumCubes(Cube.RED) * getMinimumCubes(Cube.GREEN) * getMinimumCubes(Cube.BLUE);
    }

    // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    public static Game parse(final String str) {
        try {
            final String[] parts = str.split(":");
            final int id = Integer.parseInt(parts[0].split(" ")[1]);

            final List<List<Pair<Integer, Cube>>> cubeSets =
                    Arrays.stream(parts[1].trim().split(";"))
                            .map(String::trim)
                            .map(Game::parseHandfulOfCubes)
                            .toList();

            return new Game(id, cubeSets);
        } catch (final Throwable t) {
            return null;
        }
    }

    // 3 blue, 4 red
    private static List<Pair<Integer, Cube>> parseHandfulOfCubes(final String str) {
        final String[] parts = str.split(",");
        return Arrays.stream(parts)
                .map(String::trim)
                .map(p -> {
                    final String[] ps = p.split(" ");
                    final int count = Integer.parseInt(ps[0]);
                    final Cube cube = Cube.parse(ps[1]);
                    return new Pair<>(count, cube);
                })
                .toList();
    }
}
