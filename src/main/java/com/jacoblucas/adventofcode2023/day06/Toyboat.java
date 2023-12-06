package com.jacoblucas.adventofcode2023.day06;

import java.util.stream.IntStream;

public record Toyboat(int speed) {
    public int distance(final int holdMs, final Race race) {
        int raceTime = race.time();
        int velocity = speed * holdMs;
        return (raceTime - holdMs) * velocity;
    }

    public long getWaysToWin(final Race race) {
        return IntStream.range(0, race.time() + 1)
                .map(i -> distance(i, race))
                .filter(i -> i > race.recordDistance())
                .count();
    }
}
