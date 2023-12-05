package com.jacoblucas.adventofcode2023.day05;

import org.junit.Test;

import static com.jacoblucas.adventofcode2023.day05.Category.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryTest {
    @Test
    public void testNext() {
        assertThat(SEED.next(), is(SOIL));
        assertThat(SOIL.next(), is(FERTILIZER));
        assertThat(FERTILIZER.next(), is(WATER));
        assertThat(WATER.next(), is(LIGHT));
        assertThat(LIGHT.next(), is(TEMPERATURE));
        assertThat(TEMPERATURE.next(), is(HUMIDITY));
        assertThat(HUMIDITY.next(), is(LOCATION));
        assertThat(LOCATION.next(), is(nullValue()));
    }
}
