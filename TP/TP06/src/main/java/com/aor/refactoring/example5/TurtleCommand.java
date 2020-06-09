package com.aor.refactoring.example5;

public class TurtleCommand {

    private char type;

    public TurtleCommand(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }
}
