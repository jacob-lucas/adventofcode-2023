package com.jacoblucas.adventofcode2023.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PairTest {
    @Test
    public void testPair() {
        Pair<Integer, String> pair = new Pair<>(1, "foo");
        assertThat(pair.first(), is(1));
        assertThat(pair.second(), is("foo"));
    }
}
