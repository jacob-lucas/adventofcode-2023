package com.jacoblucas.adventofcode2023.day07;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HandComparator implements Comparator<Hand> {
    public final Map<String, Integer> CARD_STRENGTH;

    public HandComparator() {
        CARD_STRENGTH = new HashMap<>();
        CARD_STRENGTH.put("A", 13);
        CARD_STRENGTH.put("K", 12);
        CARD_STRENGTH.put("Q", 11);
        CARD_STRENGTH.put("J", 10);
        CARD_STRENGTH.put("T",  9);
        CARD_STRENGTH.put("9",  8);
        CARD_STRENGTH.put("8",  7);
        CARD_STRENGTH.put("7",  6);
        CARD_STRENGTH.put("6",  5);
        CARD_STRENGTH.put("5",  4);
        CARD_STRENGTH.put("4",  3);
        CARD_STRENGTH.put("3",  2);
        CARD_STRENGTH.put("2",  1);
    }

    /**
     * Compare two hands.
     * @param h1 one hand to be compared.
     * @param h2 another hand to be compared.
     * @return a negative integer, zero, or a positive integer as the first hand is
     *          weaker, equal to, or stronger than the second.
     */
    @Override
    public int compare(Hand h1, Hand h2) {
        // First, check the hand type
        final HandType h1Strength = h1.strength();
        final HandType h2Strength = h2.strength();

        if (h1Strength != h2Strength) {
            return h2Strength.ordinal() - h1Strength.ordinal();
        }

        // Second, compare cards, A high, 2 low.
        for (int i = 0; i < h1.cards().length; i++) {
            String h1Card = h1.cards()[i];
            int h1CardStrength = CARD_STRENGTH.get(h1Card);
            String h2Card = h2.cards()[i];
            int h2CardStrength = CARD_STRENGTH.get(h2Card);
            if (h1CardStrength != h2CardStrength) {
                return h1CardStrength - h2CardStrength;
            }
        }

        return 0;
    }
}
