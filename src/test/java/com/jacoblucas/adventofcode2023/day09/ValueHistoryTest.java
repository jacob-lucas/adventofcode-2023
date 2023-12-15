package com.jacoblucas.adventofcode2023.day09;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValueHistoryTest {
    private ValueHistory valueHistory;

    @Before
    public void setUp() {
        valueHistory = new ValueHistory(0,3,6,9,12,15);
    }

    @Test
    public void testParse() {
        assertThat(ValueHistory.parse("0 3 6 9 12 15"), is(valueHistory));
    }

    @Test
    public void testDifferenceSequence() {
        ValueHistory threes = new ValueHistory(ImmutableList.of(
                new Value(new Value(0), new Value(3), 3),
                new Value(new Value(3), new Value(6), 3),
                new Value(new Value(6), new Value(9), 3),
                new Value(new Value(9), new Value(12), 3),
                new Value(new Value(12), new Value(15), 3)));
        assertThat(valueHistory.differenceSequence(), is(threes));
    }

    @Test
    public void testIsZero() {
        assertThat(valueHistory.isZero(), is(false));
        assertThat(new ValueHistory(0,0,0,0,0,0,0,0,0,0,0,0,0).isZero(), is(true));
        assertThat(new ValueHistory(-1,1,-1,1).isZero(), is(false));
    }

    @Test
    public void testExtrapolateForward() {
        assertThat(ValueHistory.parse("0 3 6 9 12 15").extrapolateForward().getValue(), is(18));
        assertThat(new ValueHistory(1, 3, 6, 10, 15, 21).extrapolateForward().getValue(), is(28));
        assertThat(new ValueHistory(10, 13, 16, 21, 30, 45).extrapolateForward().getValue(), is(68));
    }

    @Test
    public void testExtrapolateBackward() {
        assertThat(ValueHistory.parse("0 3 6 9 12 15").extrapolateBackward().getValue(), is(-3));
        assertThat(new ValueHistory(1, 3, 6, 10, 15, 21).extrapolateBackward().getValue(), is(0));
        assertThat(new ValueHistory(10, 13, 16, 21, 30, 45).extrapolateBackward().getValue(), is(5));
    }
}
