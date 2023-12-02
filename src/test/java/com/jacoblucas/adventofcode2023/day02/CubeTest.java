package com.jacoblucas.adventofcode2023.day02;

import org.junit.Test;

import static com.jacoblucas.adventofcode2023.day02.Cube.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CubeTest {
    @Test
    public void testParseInvalidValue() {
        assertThat(Cube.parse("abc"), is(nullValue()));
    }

    @Test
    public void testParseValidValue() {
        assertThat(Cube.parse("blue"), is(BLUE));
        assertThat(Cube.parse("red"), is(RED));
        assertThat(Cube.parse("green"), is(GREEN));
    }
}
