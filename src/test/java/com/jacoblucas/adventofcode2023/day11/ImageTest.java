package com.jacoblucas.adventofcode2023.day11;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2023.utils.InputReader;
import com.jacoblucas.adventofcode2023.utils.Pair;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ImageTest {
    private Image image;

    @Before
    public void setUp() throws IOException {
        final List<String> testInput = InputReader.readFile("src/test/resources/", "day11-test-input.txt");
        image = new Image(testInput);
    }

    @Test
    public void testEquals() throws IOException {
        Image i1 = new Image(InputReader.readFile("src/test/resources/", "day11-test-input.txt"));
        Image i2 = new Image(InputReader.readFile("src/test/resources/", "day11-test-input.txt"));
        assertThat(i1.equals(i2), is(true));
        assertThat(i1.equals(new Image(ImmutableList.of("..#"))), is(false));
    }

    @Test
    public void testExpand() {
        image.expand();
        final Image expected = new Image(ImmutableList.of(
                "....#........",
                ".........#...",
                "#............",
                ".............",
                ".............",
                "........#....",
                ".#...........",
                "............#",
                ".............",
                ".............",
                ".........#...",
                "#....#......."));
        assertThat(image.equals(expected), is(true));
    }

    @Test
    public void testGetGalaxies() {
        image.expand();
        assertThat(image.getGalaxies(), is(ImmutableList.of(
                new Galaxy(1, new Pair<>(0,4)),
                new Galaxy(2, new Pair<>(1,9)),
                new Galaxy(3, new Pair<>(2,0)),
                new Galaxy(4, new Pair<>(5,8)),
                new Galaxy(5, new Pair<>(6,1)),
                new Galaxy(6, new Pair<>(7,12)),
                new Galaxy(7, new Pair<>(10,9)),
                new Galaxy(8, new Pair<>(11,0)),
                new Galaxy(9, new Pair<>(11,5))
        )));
    }
}
