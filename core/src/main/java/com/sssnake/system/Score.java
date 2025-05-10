package com.sssnake.system;

public class Score {
    private static int value;

    public static void add(int x) {
        value += x;
    }

    public static int getValue() {
        return value;
    }
}
