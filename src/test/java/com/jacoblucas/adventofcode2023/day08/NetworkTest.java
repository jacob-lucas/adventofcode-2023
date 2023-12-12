package com.jacoblucas.adventofcode2023.day08;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class NetworkTest {
    private Network network;

    @Before
    public void setUp() {
        network = new Network(ImmutableList.of(
                new Node("AAA", "BBB", "CCC"),
                new Node("BBB", "DDD", "EEE"),
                new Node("CCC", "ZZZ", "GGG"),
                new Node("DDD", "DDD", "DDD"),
                new Node("EEE", "EEE", "EEE"),
                new Node("GGG", "GGG", "GGG"),
                new Node("ZZZ", "BBB", "CCC")
        ));
    }

    @Test
    public void testLeft() {
        assertThat(network.left("AAA").id(), is("BBB"));
        assertThat(network.left("123"), is(nullValue()));
    }

    @Test
    public void testRight() {
        assertThat(network.right("AAA").id(), is("CCC"));
        assertThat(network.right("123"), is(nullValue()));
    }

    @Test
    public void testStepsExample1() {
        assertThat(network.steps("AAA", "ZZZ", "RL"), is(2));
    }

    @Test
    public void testStepsExample2() {
        network = new Network(ImmutableList.of(
                new Node("AAA", "BBB", "BBB"),
                new Node("BBB", "AAA", "ZZZ"),
                new Node("ZZZ", "ZZZ", "ZZZ")
        ));
        assertThat(network.steps("AAA", "ZZZ", "LLR"), is(6));
    }
}
