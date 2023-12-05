package com.jacoblucas.adventofcode2023.day05;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MappingTest {
    @Test
    public void testParse() {
        Mapping expected = new Mapping(50, 98, 2);
        assertThat(Mapping.parse("50 98 2"), is(expected));
    }
}
