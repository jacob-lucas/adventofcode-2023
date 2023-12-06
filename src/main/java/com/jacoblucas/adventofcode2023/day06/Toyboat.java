package com.jacoblucas.adventofcode2023.day06;

import java.util.stream.LongStream;

public record Toyboat(int speed) {
    public long distance(final long holdMs, final Race race) {
        long raceTime = race.time();
        long velocity = speed * holdMs;
        return (raceTime - holdMs) * velocity;
    }

    public long getWaysToWin(final Race race) {
        return LongStream.range(0, race.time() + 1)
                .map(l -> distance(l, race))
                .filter(l -> l > race.recordDistance())
                .count();
    }
}
