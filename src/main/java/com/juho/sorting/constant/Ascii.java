package com.juho.sorting.constant;

public enum Ascii {
    A(65),
    Z(90),
    a(97),
    z(122),
    ZERO(48),
    NINE(57);

    private final int value;
    Ascii(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}