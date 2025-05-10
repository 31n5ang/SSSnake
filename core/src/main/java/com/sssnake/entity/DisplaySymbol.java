package com.sssnake.entity;

public class DisplaySymbol {
    private final char symbol;
    private final AnsiColor textColor;
    private final AnsiColor backgroundColor;

    private DisplaySymbol(Builder builder) {
        this.symbol = builder.symbol;
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
    }

    public char getSymbol() {
        return symbol;
    }

    public AnsiColor getTextColor() {
        return textColor;
    }

    public AnsiColor getBackgroundColor() {
        return backgroundColor;
    }

    public static class Builder {
        private char symbol = 'I';
        private AnsiColor textColor = AnsiColor.RESET;
        private AnsiColor backgroundColor = AnsiColor.RESET;

        public Builder symbol(char symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder textColor(AnsiColor textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder backgroundColor(AnsiColor backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public DisplaySymbol build() {
            return new DisplaySymbol(this);
        }
    }
}
