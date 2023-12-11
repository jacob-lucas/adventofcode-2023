package com.jacoblucas.adventofcode2023.day11;

import com.jacoblucas.adventofcode2023.utils.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Image {
    private List<String> raw;
    private List<Galaxy> galaxies;

    public Image(List<String> raw) {
        this.raw = raw;
        this.galaxies = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image other = (Image) o;
        if (raw.size() != other.raw.size()) {
            return false;
        } else if (raw.stream().map(String::length).collect(Collectors.toSet()).size() != 1) {
            return false;
        } else {
            for (int i = 0; i < raw.size(); i++) {
                if (!raw.get(i).equals(other.raw.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public int hashCode() {
        return raw.hashCode();
    }

    public void expand() {
        this.galaxies = new ArrayList<>();
        List<String> updated = new LinkedList<>(raw);

        // expand rows
        for (int i = 0; i < updated.size(); i++) {
            final Set<Character> chars = new HashSet<>();
            for (char c : updated.get(i).toCharArray()) {
                chars.add(c);
            }
            if (chars.size() == 1) {
                // expand! add an empty row after this one
                updated.add(i, updated.get(i));
                i++;
            }
        }

        // expand columns
        for (int j = 0; j < updated.get(0).length(); j++) {
            final Set<Character> chars = new HashSet<>();
            for (String s : updated) {
                chars.add(s.charAt(j));
            }
            if (chars.size() == 1) {
                // expand! add an empty column after this one
                for (int k = 0; k < updated.size(); k++) {
                    String old = updated.remove(k);
                    String newStr = old.substring(0, j+1) + "." + old.substring(j+1);
                    updated.add(k, newStr);
                }
                j++;
            }
        }

        raw = updated;
    }

    public List<Galaxy> getGalaxies() {
        if (!galaxies.isEmpty()) {
            return galaxies;
        }

        int id = 1;
        for (int i = 0; i < raw.size(); i++) {
            for (int j = 0; j < raw.get(i).length(); j++) {
                if (raw.get(i).charAt(j) == '#') {
                    galaxies.add(new Galaxy(id++, new Pair<>(i,j)));
                }
            }
        }

        return galaxies;
    }
}
