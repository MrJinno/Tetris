package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shape implements Shapes {
    protected final int SQUARE_HEIGH=25;
    private static final int STARTING_X=4;
    protected static final int MIN_POSITION=50;
   protected Square[]figure=new Square[4];;
    protected int down=0, right=STARTING_X, position=0;
    protected Color color=Shape.randomizeColor();
    protected Square[][] gameboard=GameBoard.getInstance().getPlansza();
    protected ArrayList<Square> movingDownObjects, movingLeftObjects, movingRightObjects, movingUpObjects;
    protected Group bigSquare=new Group();


    public Shape() {
        figure[0]=new Square(color);
        bigSquare.getChildren().add(figure[0].getRectangle());

        figure[1]=new Square(color);
        bigSquare.getChildren().add(figure[1].getRectangle());

        figure[2]=new Square(color);
        bigSquare.getChildren().add(figure[2].getRectangle());

        figure[3]=new Square(color);
        bigSquare.getChildren().add(figure[3].getRectangle());

        positionBlock1();
        setPosition();
        initMovingObjects();
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

    @Override
    public void moveRight() {
        if (Shape.isMovableLeftRight(this, right+1, getMovingRightObjects())) {
            right++;
            setPosition();
        }

    }


    @Override
    public void moveDown() {
        if (isMovableDown(this)) {
            down++;
            setPosition();
        }
    }

    @Override
    public void rotate() {
        switch (position){
            case 0:
                positionBlock2();
                position=1;
                break;
            case 1:
                positionBlock3();
                position=2;
                break;
            case 2:
                positionBlock4();
                position=3;
                break;
            case 3:
                positionBlock1();
                position=0;
                break;
        }
        swapCollicionObjects();
        setPosition();
    }
    public Square[] getFigure() {
        return figure;
    }

    public int getPositionX(Square square){
        return square.getStartingArrayX()+right;
    }

    public int getPositionY(Square square){
        return square.getStartingArrayY()+down;
    }

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
    public void checkCollision(int position){
        if (checkRotateCollision()){
            this.position=position;
            revertCollisionObjects();
            setPosition();
            rotate();
        }

    }
    public boolean checkRotateCollision() {
        for (Square square : figure) {
            if (gameboard[square.getStartingArrayX() + right][square.getStartingArrayY() + down] != null) {
                return true;
            }
        }

        return false;
    }

    public void setPosition( ){
        for (Square square:figure){
            square.getRectangle().setX(square.getStartingX()+(SQUARE_HEIGH*right));
            square.getRectangle().setY(square.getStartingY()+(SQUARE_HEIGH*down));
        }
    }



    public void swapCollicionObjects(){
        ArrayList<Square> temp;
        temp= movingLeftObjects;
        movingLeftObjects=movingDownObjects;
        movingDownObjects=movingRightObjects;
        movingRightObjects=movingUpObjects;
        movingUpObjects=temp;
    }

    public void revertCollisionObjects(){
        ArrayList<Square> temp;
        temp=movingLeftObjects;
        movingLeftObjects=movingUpObjects;
        movingUpObjects=movingRightObjects;
        movingRightObjects=movingDownObjects;
        movingDownObjects=temp;
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
        if (Shape.isMovableLeftRight(this, right-1, getMovingLeftObjects())) {
            right--;
            setPosition();
        }
    }

    public void setRight(int right) {
        this.right = right;
    }

    public Group getGroup() {
        return bigSquare;
    }

    protected abstract void positionBlock1();
    public ArrayList<Square> getMovingDownObjects() {
        return movingDownObjects;
    }
    public ArrayList<Square> getMovingLeftObjects() {
        return movingLeftObjects;
    }

    public ArrayList<Square> getMovingRightObjects() {
        return movingRightObjects;
    }

    protected abstract void initMovingObjects();
    protected abstract void positionBlock4();
    protected abstract void positionBlock2();
    protected abstract void positionBlock3();
}
