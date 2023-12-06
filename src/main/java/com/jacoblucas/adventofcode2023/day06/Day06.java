package com.jacoblucas.adventofcode2023.day06;

import java.util.stream.Stream;

public class Day06 {
    public static Race RACE1 = new Race(1, 48, 390);
    public static Race RACE2 = new Race(2, 98, 1103);
    public static Race RACE3 = new Race(3, 90, 1112);
    public static Race RACE4 = new Race(4, 83, 1360);

    public static void main(String[] args) {
        final Toyboat toyboat = new Toyboat(1);

        // Part 1
        long waysToWin = Stream.of(RACE1, RACE2, RACE3, RACE4)
                .map(toyboat::getWaysToWin)
                .reduce((a, b) -> a * b)
                .get();
        System.out.println(waysToWin);

        // Part 2
        final Race realRace = new Race(5, 48989083L, 390110311121360L);
        System.out.println(toyboat.getWaysToWin(realRace));
    }
}
