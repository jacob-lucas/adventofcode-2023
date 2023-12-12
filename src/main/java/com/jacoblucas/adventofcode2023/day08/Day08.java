package com.jacoblucas.adventofcode2023.day08;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day08 {
    public static void main(String[] args) throws IOException {
        final List<List<String>> input = InputReader.readGroups("day08-input.txt");

        final String instructions = input.get(0).get(0);
        final Network network = new Network(input.get(1).stream()
                .map(Node::parse)
                .toList());

        // Part 1
        int steps = network.steps("AAA", "ZZZ", instructions);
        System.out.println(steps);
    }
}
