package com.jacoblucas.adventofcode2023.day08;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NodeTest {
    @Test
    public void testParse() {
        assertThat(Node.parse("AAA = (BBB, CCC)"), is(new Node("AAA", "BBB", "CCC")));
    }
}
