package com.jacoblucas.adventofcode2023.day09;

import com.jacoblucas.adventofcode2023.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day09 {
    public static void main(String[] args) throws IOException {
//        final List<String> input = ImmutableList.of(
//                "0 3 6 9 12 15",
//                "1 3 6 10 15 21",
//                "10 13 16 21 30 45");
        final List<String> input = InputReader.read("day09-input.txt");

        final List<ValueHistory> histories = input.stream()
                .map(ValueHistory::parse)
                .toList();

        // Part 1
        histories.forEach(ValueHistory::extrapolate);
        long extrapolationSum = histories.stream()
                .mapToLong(ValueHistory::last)
                .sum();
        System.out.println(extrapolationSum);
    }


}
