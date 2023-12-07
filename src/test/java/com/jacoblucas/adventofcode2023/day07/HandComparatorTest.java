package com.jacoblucas.adventofcode2023.day07;

import org.junit.Test;

import static com.jacoblucas.adventofcode2023.day07.Hands.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HandComparatorTest {
    private final HandComparator comparator = new HandComparator();

    @Test
    public void testHandComparatorOnStrength() {
        assertThat(comparator.compare(FIVE_OF_A_KIND_HAND, FOUR_OF_A_KIND_HAND), is(1));
        assertThat(comparator.compare(FOUR_OF_A_KIND_HAND, FULL_HOUSE_HAND), is(1));
        assertThat(comparator.compare(FULL_HOUSE_HAND, THREE_OF_A_KIND_HAND), is(1));
        assertThat(comparator.compare(THREE_OF_A_KIND_HAND, TWO_PAIR_HAND), is(1));
        assertThat(comparator.compare(TWO_PAIR_HAND, ONE_PAIR_HAND), is(1));
        assertThat(comparator.compare(ONE_PAIR_HAND, HIGH_CARD_HAND), is(1));

        assertThat(comparator.compare(FOUR_OF_A_KIND_HAND, FIVE_OF_A_KIND_HAND), is(-1));
        assertThat(comparator.compare(FULL_HOUSE_HAND, FOUR_OF_A_KIND_HAND), is(-1));
        assertThat(comparator.compare(THREE_OF_A_KIND_HAND, FULL_HOUSE_HAND), is(-1));
        assertThat(comparator.compare(TWO_PAIR_HAND, THREE_OF_A_KIND_HAND), is(-1));
        assertThat(comparator.compare(ONE_PAIR_HAND, TWO_PAIR_HAND), is(-1));
        assertThat(comparator.compare(HIGH_CARD_HAND, ONE_PAIR_HAND), is(-1));
    }

    @Test
    public void testHandComparatorOnCardRank() {
        assertThat(comparator.compare(new Hand(new String[]{"3","3","3","3","2"}, 1), new Hand(new String[]{"2","A","A","A","A"}, 1)), is(1));
        assertThat(comparator.compare(new Hand(new String[]{"2","A","A","A","A"}, 1), new Hand(new String[]{"3","3","3","3","2"}, 1)), is(-1));

        assertThat(comparator.compare(new Hand(new String[]{"7","7","8","8","8"}, 1), new Hand(new String[]{"7","7","7","8","8"}, 1)), is(1));
        assertThat(comparator.compare(new Hand(new String[]{"7","7","7","8","8"}, 1), new Hand(new String[]{"7","7","8","8","8"}, 1)), is(-1));
    }

    @Test
    public void testEqualHands() {
        assertThat(comparator.compare(new Hand(new String[]{"7","7","7","8","8"}, 1), new Hand(new String[]{"7","7","7","8","8"}, 1)), is(0));
    }
}
