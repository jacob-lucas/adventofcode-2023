package com.jacoblucas.adventofcode2023.day09;

import java.util.*;
import java.util.function.BiFunction;

public class ValueHistory {

    private final List<Value> history;

    ValueHistory(int ...history) {
        List<Value> values = new ArrayList<>();
        for (int i : history) {
            values.add(new Value(i));
        }
        this.history = values;
    }

    ValueHistory(final List<Value> history) {
        this.history = history;
    }

    public static ValueHistory parse(final String str) {
        List<Value> history = new ArrayList<>();
        final String[] parts = str.split(" ");
        for (String part : parts) {
            history.add(new Value(Integer.parseInt(part)));
        }
        return new ValueHistory(history);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueHistory that = (ValueHistory) o;
        return history.equals(that.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(history);
    }

    @Override
    public String toString() {
        return history.toString();
    }

    public ValueHistory differenceSequence() {
        return sequence((i, j) -> new Value(i, j, j.getValue() - i.getValue()));
    }

    private ValueHistory sequence(final BiFunction<Value, Value, Value> generator) {
        final List<Value> sequence = new ArrayList<>();
        for (int i = 1; i < history.size(); i++) {
            sequence.add(generator.apply(history.get(i-1), history.get(i)));
        }
        return new ValueHistory(sequence);
    }

    public boolean isZero() {
        return history.stream()
                .mapToInt(Value::getValue)
                .allMatch(i -> i == 0);
    }

    public Value get(final int n) {
        return history.get(n < 0 ? history.size() + n : n);
    }

    public Value head() {
        return get(0);
    }

    public Value tail() {
        return get(-1);
    }

    public Value extrapolateForward() {
        ValueHistory history = new ValueHistory(this.history);
        final Stack<ValueHistory> historyStack = new Stack<>();
        historyStack.push(history);

        while (!history.isZero()) {
            history = history.differenceSequence();
            historyStack.push(history);
//            System.out.println(history);
        }

//        System.out.println("Extrapolating...");
        ValueHistory curr = historyStack.pop();
        curr.history.add(new Value(historyStack.peek().tail(), null, 0));
        while (!historyStack.isEmpty()) {
//            System.out.println(curr);
            ValueHistory next = historyStack.pop();
            int left = next.tail().getValue();
            int below = curr.tail().getValue();
            Value newValue;
            if (!historyStack.isEmpty()) {
                newValue = new Value(historyStack.peek().tail(), null, left + below);
            } else {
                newValue = new Value(left + below);
            }
            curr.tail().setRight(newValue);
            next.history.add(newValue);
            curr = next;
        }
//        System.out.println(curr);

        Value extrapolated = curr.tail();
//        System.out.println(extrapolated.getValue());
        return extrapolated;
    }

    public Value extrapolateBackward() {
        ValueHistory history = new ValueHistory(this.history);
        final Stack<ValueHistory> historyStack = new Stack<>();
        historyStack.push(history);

        while (!history.isZero()) {
            history = history.differenceSequence();
            historyStack.push(history);
//            System.out.println(history);
        }

//        System.out.println("Extrapolating...");
        ValueHistory curr = historyStack.pop();
        curr.history.add(0, new Value(null, historyStack.peek().head(), 0));
        while (!historyStack.isEmpty()) {
//            System.out.println(curr);
            ValueHistory next = historyStack.pop();
            int right = next.head().getValue();
            int below = curr.head().getValue();
            Value newValue;
            if (!historyStack.isEmpty()) {
                newValue = new Value(null, historyStack.peek().head(), right - below);
            } else {
                newValue = new Value(right - below);
            }
            curr.head().setLeft(newValue);
            next.history.add(0, newValue);
            curr = next;
        }
//        System.out.println(curr);

        Value extrapolated = curr.head();
//        System.out.println(extrapolated.getValue());
        return extrapolated;
    }
}
