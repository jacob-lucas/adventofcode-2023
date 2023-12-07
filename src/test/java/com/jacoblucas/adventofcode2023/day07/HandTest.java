package com.jacoblucas.adventofcode2023.day07;

import org.junit.Test;

import static com.jacoblucas.adventofcode2023.day07.HandType.*;
import static com.jacoblucas.adventofcode2023.day07.Hands.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HandTest {
    @Test
    public void testStrength() {
        assertThat(FIVE_OF_A_KIND_HAND.strength(), is(FIVE_OF_A_KIND));
        assertThat(FOUR_OF_A_KIND_HAND.strength(), is(FOUR_OF_A_KIND));
        assertThat(FULL_HOUSE_HAND.strength(), is(FULL_HOUSE));
        assertThat(THREE_OF_A_KIND_HAND.strength(), is(THREE_OF_A_KIND));
        assertThat(TWO_PAIR_HAND.strength(), is(TWO_PAIR));
        assertThat(ONE_PAIR_HAND.strength(), is(ONE_PAIR));
        assertThat(HIGH_CARD_HAND.strength(), is(HIGH_CARD));
    }
}
