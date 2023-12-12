package com.jacoblucas.adventofcode2023.day08;

public record Node(String id, String leftId, String rightId) {
    // id = (left, right)
    public static Node parse(String input) {
        final String[] parts = input.split(" ");
        return new Node(parts[0], parts[2].substring(1, parts[2].length()-1), parts[3].substring(0, parts[3].length()-1));
    }
}
