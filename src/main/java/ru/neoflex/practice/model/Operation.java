package ru.neoflex.practice.model;

public enum Operation {
    ADD("+"),
    SUBTRACT("-");

    public final String label;

    private Operation(String label) {
        this.label = label;
    }
}