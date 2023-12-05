package com.jacoblucas.adventofcode2023.day05;

import java.util.List;

public record Mapping(long destinationRangeStart, long sourceRangeStart, long rangeLength) {
    public static Mapping parse(final String str) {
        final List<Long> longs = Day05.toLongList(str);
        try {
            return new Mapping(longs.get(0), longs.get(1), longs.get(2));
        } catch (final Throwable t) {
            System.out.println(str);
            throw t;
        }
    }
}
