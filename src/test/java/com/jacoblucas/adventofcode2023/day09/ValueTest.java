package com.jacoblucas.adventofcode2023.day09;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValueTest {
    @Test
    public void testToString() {
        assertThat(new Value(3).toString(), is("3"));
    }

    @Test
    public void testEquals() {
        assertThat(new Value(3), is(new Value(3)));
    }
}
