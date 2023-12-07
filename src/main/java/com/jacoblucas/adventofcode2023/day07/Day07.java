package com.jacoblucas.adventofcode2023.day07;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day07 {
    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day07-input.txt");

        // Part 1
        final HandComparator handComparator = new HandComparator();
        final List<Hand> hands = input.stream()
                .map(str -> str.split(" "))
                .map(parts -> new Hand(toArray(parts[0]), Integer.parseInt(parts[1])))
                .sorted(handComparator)
                .toList();

        int winnings = 0;
        for (int i = 0; i < hands.size(); i++) {
            winnings += hands.get(i).bid() * (i+1);
        }
        System.out.println(winnings);
    }

    private static String[] toArray(final String str) {
        String[] arr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = ""+str.charAt(i);
        }
        return arr;
    }
}