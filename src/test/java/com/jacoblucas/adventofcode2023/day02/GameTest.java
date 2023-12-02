package com.jacoblucas.adventofcode2023.day02;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2023.utils.InputReader;
import com.jacoblucas.adventofcode2023.utils.Pair;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.jacoblucas.adventofcode2023.day02.Cube.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameTest {
    @Test
    public void testParse() {
        final Game expected = new Game(1, ImmutableList.of(
                ImmutableList.of(
                        new Pair<>(3, BLUE),
                        new Pair<>(4, RED)),
                ImmutableList.of(
                        new Pair<>(1, RED),
                        new Pair<>(2, GREEN),
                        new Pair<>(6, BLUE)),
                ImmutableList.of(
                        new Pair<>(2, GREEN))));

        assertThat(Game.parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"), is(expected));
    }

    @Test
    public void testIsPossible() throws IOException {
        final List<Game> games = InputReader.readFile("src/test/resources/", "day02-test-input.txt")
                .stream()
                .map(Game::parse)
                .toList();

        final int redCount = 12, greenCount = 13, blueCount = 14;

        assertThat(games.get(0).isPossible(redCount, greenCount, blueCount), is(true));
        assertThat(games.get(1).isPossible(redCount, greenCount, blueCount), is(true));
        assertThat(games.get(2).isPossible(redCount, greenCount, blueCount), is(false));
        assertThat(games.get(3).isPossible(redCount, greenCount, blueCount), is(false));
        assertThat(games.get(4).isPossible(redCount, greenCount, blueCount), is(true));
    }
}
