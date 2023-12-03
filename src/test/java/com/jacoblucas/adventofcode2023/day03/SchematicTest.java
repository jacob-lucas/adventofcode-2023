package com.jacoblucas.adventofcode2023.day03;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2023.utils.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.CoreMatchers.is;

public class SchematicTest {
    private Schematic schematic;

    @Before
    public void setUp() {
        List<String> testEngine = ImmutableList.of(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.1");

        schematic = new Schematic(testEngine);
    }

    @Test
    public void testFindParts() {
        assertThat(schematic.findParts(), containsInAnyOrder(
                new Pair<>(1, 3),
                new Pair<>(3, 6),
                new Pair<>(4, 3),
                new Pair<>(5, 5),
                new Pair<>(8, 3),
                new Pair<>(8, 5)));
    }

    @Test
    public void testFindPartNumbers() {
        assertThat(schematic.findPartNumbers(new Pair<>(1, 3)), containsInAnyOrder(467, 35));
        assertThat(schematic.findPartNumbers(new Pair<>(3, 6)), containsInAnyOrder(633));
        assertThat(schematic.findPartNumbers(new Pair<>(4, 3)), containsInAnyOrder(617));
        assertThat(schematic.findPartNumbers(new Pair<>(5, 5)), containsInAnyOrder(592));
        assertThat(schematic.findPartNumbers(new Pair<>(8, 3)), containsInAnyOrder(664));
        assertThat(schematic.findPartNumbers(new Pair<>(8, 5)), containsInAnyOrder(755, 598));
    }

    @Test
    public void testGetPartNumberSum() {
        assertThat(schematic.getPartNumberSum(), is(4361));
    }

    @Test
    public void testFindGears() {
        assertThat(schematic.findGears(), containsInAnyOrder(
                new Pair<>(1, 3),
                new Pair<>(8, 5)));
    }
}
