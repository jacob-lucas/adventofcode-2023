package com.jacoblucas.adventofcode2023.day03;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day03 {
    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day03-input.txt");

        // Part 1
        final Schematic schematic = new Schematic(input);
        System.out.println(schematic.getPartNumberSum());
    }
}
