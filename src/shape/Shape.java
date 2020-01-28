package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;

import java.util.Random;

public abstract class Shape implements Shapes {
    private Square[]figure;
    private int down, right;
    private GameBoard gameBoard= GameBoard.getInstance();
    private Color color=Shape.randomizeColor();


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

    public void setRight(int right) {
        this.right = right;
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
    public static Color randomizeColor(){
        Random r=new Random();
        int colorInt=r.nextInt(5);
        Color color=Color.RED;
        switch (colorInt){
            case 0:
                color= Color.AQUA;
                break;

            case 1:
                color= Color.RED;
                break;

            case 2:
                color= Color.CORAL;
                break;

            case 3:
                color= Color.BROWN;
                break;

            case 4:
                color= Color.AZURE;
                break;

        }

        return color;
    }

    public abstract Square[] getFigure();
    public abstract Square[] getMovingDownObjects();
    public abstract Square[] movingLeftObjects();
    public abstract Square[] movingRightObjects();
    public abstract int getPositionX(Square square);
    public abstract int getPositionY(Square square);

    public void setDown(int down) {
        this.down = down;
    }
}
