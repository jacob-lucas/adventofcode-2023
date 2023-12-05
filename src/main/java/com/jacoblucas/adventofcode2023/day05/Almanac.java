package com.jacoblucas.adventofcode2023.day05;

import com.google.common.collect.ImmutableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record Almanac(Map<Category, List<Mapping>> categoryMap) {
    // Given the mapping defined in the records provided, map the provided integer to the destination integer
    public long map(final Category source, final long from) {
        final List<Mapping> mappings = categoryMap.getOrDefault(source, ImmutableList.of());

        // Find the relevant mapping -- one where source range start <= from <= source range start + range length
        final Mapping mapping = mappings.stream()
                .filter(m -> m.sourceRangeStart() <= from && from <= m.sourceRangeStart() + m.rangeLength())
                .findFirst()
                .orElse(null);

        if (mapping == null) {
            // Any source numbers that aren't mapped correspond to the same destination number.
            return from;
        } else {
            // Map the source number onto the destination range
            return mapping.destinationRangeStart() + (from - mapping.sourceRangeStart());
        }
    }

    public long getLocationForSeed(final long seed) {
        Category category = Category.SEED;
        long from = seed;
        while (category != null) {
            from = map(category, from);
            category = category.next();
        }
        return from;
    }

    public static Almanac parse(final List<List<String>> input) {
        final Map<Category, List<Mapping>> categoryMap = new HashMap<>();
        for (int i = 1; i < input.size(); i++) {
            categoryMap.put(
                    Category.values()[i-1],
                    input.get(i).stream()
                            .filter(str -> !str.contains(":"))
                            .map(Mapping::parse)
                            .toList());
        }
        return new Almanac(categoryMap);
    }
}
