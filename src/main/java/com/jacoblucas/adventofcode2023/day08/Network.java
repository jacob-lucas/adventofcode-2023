package com.jacoblucas.adventofcode2023.day08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
    private final Map<String, Node> nodeMap;

    public Network(final List<Node> nodes) {
        nodeMap = new HashMap<>();
        nodes.forEach(n -> nodeMap.put(n.id(), n));
    }

    public Node left(final String id) {
        final Node node = nodeMap.getOrDefault(id, null);
        return node == null ? null : nodeMap.get(node.leftId());
    }

    public Node right(final String id) {
        final Node node = nodeMap.getOrDefault(id, null);
        return node == null ? null : nodeMap.get(node.rightId());
    }

    public int steps(final String srcId, final String destId, final String instructions) {
        int steps = 0;
        int instructionsIdx = 0;
        String currId = srcId;
        while (!currId.equals(destId)) {
            char direction = instructions.charAt(instructionsIdx);
            System.out.println("At " + currId + ", looking for " + destId + ", heading " + direction);
            Node next = direction == 'L' ? left(currId) : right(currId);
            if (next == null) {
                return -1;
            } else {
                currId = next.id();
                steps++;
                instructionsIdx = (instructionsIdx + 1) % instructions.length();
            }
        }
        return steps;
    }
}
