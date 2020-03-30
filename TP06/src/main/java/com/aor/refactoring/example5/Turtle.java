package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public void execute(char command) {

        switch(command){
            case 'L':
                rotateLeft();
                break;
            case 'R':
                rotateRight();
                break;
            case 'F':
                moveForward();
                break;
        }
    }

    public void rotateLeft() {
        switch(direction){
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    public void rotateRight() {
        switch(direction){
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    public void moveForward() {
        switch(direction){
            case 'N':
                moveUp();
                break;
            case 'S':
                moveDown();
                break;
            case 'W':
                moveLeft();
                break;
            case 'E':
                moveRight();
                break;
        }
    }

    public void moveUp(){
        this.row--;
    }

    public void moveDown(){
        this.row++;
    }

    public void moveLeft(){
        this.column--;
    }

    public void moveRight(){
        this.column++;
    }

}
