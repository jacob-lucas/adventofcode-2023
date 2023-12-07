package com.jacoblucas.adventofcode2023.day07;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public record Hand(String[] cards, int bid) {
    public HandType strength() {
        final Map<String, Integer> cardCount = new HashMap<>();
        for (final String str : cards) {
            if (cardCount.containsKey(str)) {
                cardCount.put(str, cardCount.get(str) + 1);
            } else {
                cardCount.putIfAbsent(str, 1);
            }
        }

        Collection<Integer> values = cardCount.values();
        if (cardCount.size() == 1) {
            return HandType.FIVE_OF_A_KIND;
        } else if (cardCount.size() == 2) {
            if (values.containsAll(ImmutableList.of(1, 4))) {
                return HandType.FOUR_OF_A_KIND;
            } else if (values.containsAll(ImmutableList.of(2, 3))) {
                return HandType.FULL_HOUSE;
            }
        } else if (cardCount.size() == 3) {
            if (values.containsAll(ImmutableList.of(1, 1, 3))) {
                return HandType.THREE_OF_A_KIND;
            } else if (values.containsAll(ImmutableList.of(2, 2, 1))) {
                return HandType.TWO_PAIR;
            }
        } else if (cardCount.size() == 4) {
            return HandType.ONE_PAIR;
        } else {
            return HandType.HIGH_CARD;
        }

        throw new IllegalArgumentException("Invalid hand! " + this);
    }
}
