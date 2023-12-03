package com.jacoblucas.adventofcode2023.day03;

import com.jacoblucas.adventofcode2023.utils.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Schematic(List<String> engine) {
    public int getPartNumberSum() {
        return findParts().stream()
                .map(this::findPartNumbers)
                .flatMap(Set::stream)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Pair<Integer, Integer>> findParts() {
        final List<Pair<Integer, Integer>> parts = new ArrayList<>();
        for (int i=0; i<engine.size(); i++) {
            final String row = engine.get(i);
            for (int j = 0; j<row.length(); j++) {
                final char ch = row.charAt(j);
                if (!Character.isDigit(ch) && ch != '.') {
                    parts.add(new Pair<>(i, j));
                }
            }
        }
        return parts;
    }

    public List<Pair<Integer, Integer>> findGears() {
        return findParts().stream()
                .filter(p -> engine.get(p.first()).charAt(p.second()) == '*')
                .filter(p -> findPartNumbers(p).size() == 2)
                .toList();
    }

    public Set<Integer> findPartNumbers(final Pair<Integer, Integer> part) {
        final Set<Integer> partNumbers = new HashSet<>();
        int row = part.first();
        int col = part.second();

        // Look in all adjacent squares for part numbers
        for (int dx = -1; dx <= 1; dx++){
            for (int dy = -1; dy <= 1; dy++) {
                int x = row + dx;
                int y = col + dy;
                String rowStr = engine.get(x);
                if (x < 0 || y >= engine.size() || (dx == 0 && dy == 0) || rowStr.charAt(y) == '.') continue;

                // Found a part number
                int left = y;
                int right = y;

                while (left > 0 && Character.isDigit(rowStr.charAt(Math.max(left - 1, 0)))) {
                    left--;
                }
                while (right < rowStr.length() - 1 && Character.isDigit(rowStr.charAt(Math.min(right + 1, rowStr.length())))) {
                    right++;
                }

                partNumbers.add(Integer.parseInt(rowStr.substring(left, right + 1)));
            }
        }

        return partNumbers;
    }
}
