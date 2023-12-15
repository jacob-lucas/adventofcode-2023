package com.jacoblucas.adventofcode2023.day09;

import java.util.Objects;

public class Value {
    private Value left, right;

    private final int value;

    public Value(final Value left, final Value right, final int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Value(final int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return value == value1.value && Objects.equals(left, value1.left) && Objects.equals(right, value1.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, value);
    }

    @Override
    public String toString() {
        return ""+value;
    }

    public int getValue() {
        return value;
    }

    public void setRight(final Value v) {
        this.right = v;
    }
}
