package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shape implements Shapes {
    private final int SQUARE_HEIGH=25;
    private Square[]figure;
    private int down, right;
    private Color color=Shape.randomizeColor();
    protected ArrayList<Square> movingDownObjects, movingLeftObjects, movingRightObjects, movingUpObjects;


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
    public abstract int getPositionX(Square square);
    public abstract int getPositionY(Square square);
    public static boolean isMovableLeftRight(Shape shape, int right, ArrayList<Square> squares){
         Square[][] gameBoard= GameBoard.getInstance().getPlansza();
        int down=shape.getDown();
        for (Square sqr:squares){
            if (sqr.getStartingArrayX()+right+1==0) return false;
            if (sqr.getStartingArrayX()+right==GameBoard.MAX_X) return false;
            if (gameBoard[sqr.getStartingArrayX() + right][sqr.getStartingArrayY() + down] != null) {
                return false;
            }
            }
        return true;
        }
    public static boolean isMovableDown(Shape shape){
        Square[][] plansza=GameBoard.getInstance().getPlansza();
        int down=shape.getDown();
        int right=shape.getRight();
        ArrayList<Square> sqr=shape.getMovingDownObjects();
        down++;
        for (Square square : sqr) {
            if (square.getStartingArrayY()+down==GameBoard.MAX_Y) return false;
            if (plansza[square.getStartingArrayX() + right][square.getStartingArrayY() + down] != null) {
                return false;
            }
        }
        return true;
    }

    public void setDown(int down) {
        this.down = down;
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


    public void removeBottom(){

    }
    public void addShape(){

    }
    public abstract ArrayList<Square> getMovingDownObjects();

    public  abstract ArrayList<Square> getMovingLeftObjects();
    public abstract ArrayList<Square> getMovingRightObjects();


}
