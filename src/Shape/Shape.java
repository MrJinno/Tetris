package Shape;

import javafx.scene.Group;
import sample.GameBoard;

public abstract   class Shape implements Shapes {
    private Square[]figure;
    private int down, right;
    private GameBoard gameBoard= GameBoard.getInstance();


    public void setPosition(int right, int down){

    }
    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
    }

    public void moveLeft() {

    }

    public void moveRight() {

    }


    public void moveDown() {

    }


    public void rotate() {

    }

    public Group getGroup() {
        return null;
    }

    @Override
    public boolean isStuck() {
        return false;
    }

    public void removeBottom(){

    }
    public void addShape(){

    }

    public Square[] getFigure() {
        return figure;
    }
}
