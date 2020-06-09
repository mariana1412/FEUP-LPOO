package com.aor.refactoring.example5;

public class TurtleDirection {

    private char type;

    public TurtleDirection(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void rotateLeft() {
        if (type == 'N') type = 'W';
        else if (type == 'W') type = 'S';
        else if (type == 'S') type = 'E';
        else if (type == 'E') type = 'N';
    }

    public void rotateRight() {
        if (type == 'N') type = 'E';
        else if (type == 'E') type = 'S';
        else if (type == 'S') type = 'W';
        else if (type == 'W') type = 'N';
    }
}
