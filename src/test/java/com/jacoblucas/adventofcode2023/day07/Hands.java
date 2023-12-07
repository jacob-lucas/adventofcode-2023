package com.jacoblucas.adventofcode2023.day07;

import com.google.common.collect.ImmutableList;

import java.util.List;

public final class Hands {
    static final Hand FIVE_OF_A_KIND_HAND    = new Hand(new String[]{"A","A","A","A","A"}, 1);
    static final Hand FOUR_OF_A_KIND_HAND    = new Hand(new String[]{"A","A","8","A","A"}, 1);
    static final Hand FULL_HOUSE_HAND        = new Hand(new String[]{"2","3","3","3","2"}, 1);
    static final Hand THREE_OF_A_KIND_HAND   = new Hand(new String[]{"T","T","T","9","8"}, 1);
    static final Hand TWO_PAIR_HAND          = new Hand(new String[]{"2","3","4","3","2"}, 1);
    static final Hand ONE_PAIR_HAND          = new Hand(new String[]{"A","2","3","A","4"}, 1);
    static final Hand HIGH_CARD_HAND         = new Hand(new String[]{"2","3","4","5","6"}, 1);

    static final List<Hand> TEST_INPUT_LIST = ImmutableList.of(
            new Hand(new String[]{"3","2","T","3","K"}, 765),
            new Hand(new String[]{"T","5","5","J","5"}, 684),
            new Hand(new String[]{"K","K","6","7","7"}, 28),
            new Hand(new String[]{"K","T","J","J","T"}, 220),
            new Hand(new String[]{"Q","Q","Q","J","A"}, 483)
    );
}
