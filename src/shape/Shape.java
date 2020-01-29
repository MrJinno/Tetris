package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shape implements Shapes {
    private Square[]figure;
    private int down, right;
    private Color color=Shape.randomizeColor();


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

    public abstract ArrayList<Square> getMovingDownObjects();
    public abstract ArrayList<Square> getMovingLeftObjects();
    public abstract ArrayList<Square> getMovingRightObjects();
    public abstract int getPositionX(Square square);
    public abstract int getPositionY(Square square);
    public abstract int getWidth();
    public static boolean isMovableLeftRight(Shape shape, int right, ArrayList<Square> squares){
         Square[][] gameBoard= GameBoard.getInstance().getPlansza();
        int down=shape.getDown();
        if (right+1==0) return false;
        if (right+shape.getWidth()-1==GameBoard.MAX_X) return false;
        for (Square sqr:squares){
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
        if (down+1==GameBoard.MAX_Y) return false;
        for (Square square : sqr) {
            if (plansza[square.getStartingArrayX() + right][square.getStartingArrayY() + down] != null) {
                return false;
            }
        }
        return true;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public void setPosition(){

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
}
