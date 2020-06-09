package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private TurtleDirection direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = new TurtleDirection(direction);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction.getType();
    }

    public void execute(TurtleCommand command) {
        if (command.getType() == 'L') direction.rotateLeft();
        else if (command.getType() == 'R') direction.rotateRight();
        else if (command.getType() == 'F') moveForward();
    }

    public void moveForward() {
        if (getDirection() == 'N') row--;
        if (getDirection() == 'S') row++;
        if (getDirection() == 'W') column--;
        if (getDirection() == 'E') column++;
    }


}
