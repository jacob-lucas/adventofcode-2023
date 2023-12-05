package com.jacoblucas.adventofcode2023.day05;


import com.jacoblucas.adventofcode2023.utils.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlmanacTest {
    private Almanac almanac;

    @Before
    public void setUp() throws IOException {
//        final Mapping mapping1 = new Mapping(50, 98, 2);
//        final Mapping mapping2 = new Mapping(52, 50, 48);
//        almanac = new Almanac(ImmutableMap.of(
//                Category.SOIL, ImmutableList.of(mapping1, mapping2)));
        final List<List<String>> input = InputReader.readGroups("src/test/resources/", "day05-test-input.txt");
        almanac = Almanac.parse(input);
    }

    @Test
    public void testMapSeedToSoil() {
        assertThat(almanac.map(Category.SEED, 79), is(81L));
        assertThat(almanac.map(Category.SEED, 14), is(14L));
        assertThat(almanac.map(Category.SEED, 55), is(57L));
        assertThat(almanac.map(Category.SEED, 13), is(13L));
    }

    @Test
    public void testGetLocationForSeed() {
        assertThat(almanac.getLocationForSeed(79), is(82L));
        assertThat(almanac.getLocationForSeed(14), is(43L));
        assertThat(almanac.getLocationForSeed(55), is(86L));
        assertThat(almanac.getLocationForSeed(13), is(35L));
    }
}
