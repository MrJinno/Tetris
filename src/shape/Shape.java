package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.Background;
import sample.GameBoard;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shape implements Shapes {
    private static final int STARTING_X=4, NEXT_BLOCK_X=12, NEXT_BLOCK_Y=7;
    protected Square[]figure=new Square[4];
    private int down=0, right=STARTING_X, position=0;
    private Square[][] gameBoard =GameBoard.getInstance().getBoard();
    protected ArrayList<Square> movingDownObjects, movingLeftObjects, movingRightObjects, movingUpObjects;
    protected Group bigSquare=new Group();
    protected int[] nextX, nextY;


    public Shape() {
        Color color = Shape.randomizeColor();
        figure[0]=new Square(color);
        figure[1]=new Square(color);
        figure[2]=new Square(color);
        figure[3]=new Square(color);

        for (Square square:figure){
            bigSquare.getChildren().add(square.getRectangle());
        }
        positionBlock1();
        setPosition();
        initMovingObjects();
    }

    private static Color randomizeColor(){
        Random r=new Random();
        Color[] colors=new Color[5];
        colors[0]=Color.BLUE;
        colors[1]=Color.RED;
        colors[2]=Color.YELLOW;
        colors[3]=Color.GREEN;
        colors[4]=Color.PURPLE;
        int colorInt=r.nextInt(5);
        return colors[colorInt];
    }

    public void positionNextBlock(){
        right=NEXT_BLOCK_X;
        down=NEXT_BLOCK_Y;
        setPosition();

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
    public void moveLeft() {
        if (Shape.isMovableLeftRight(this, right-1, getMovingLeftObjects())) {
            right--;
            setPosition();
        }
    }
    @Override
    public void rotate() {
        if (checkBoardCollision(nextX, nextY)) {
            switch (position) {
                case 0:
                    positionBlock2();
                    position = 1;
                    break;
                case 1:
                    positionBlock3();
                    position = 2;
                    break;
                case 2:
                    positionBlock4();
                    position = 3;
                    break;
                case 3:
                    positionBlock1();
                    position = 0;
                    break;
            }
            swapCollisionObjects();
            setPosition();
        }
    }

    private static boolean isMovableLeftRight(Shape shape, int right, ArrayList<Square> squares){
         Square[][] gameBoard= GameBoard.getInstance().getBoard();
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
        Square[][] plansza=GameBoard.getInstance().getBoard();
        int down=shape.getDown();
        int right=shape.getRight();
        ArrayList<Square> sqr=shape.getMovingDownObjects();
        down++;
        for (Square square : sqr) {
            if (square.getStartingArrayY()+down>=GameBoard.MAX_Y) return false;
            if (plansza[square.getStartingArrayX() + right][square.getStartingArrayY() + down] != null) {
                return false;
            }
        }
        return true;
    }


    public void setPosition( ){
        for (Square square:figure){
            int SQUARE_HEIGH = Background.SQUARE_HEIGH;
            square.getRectangle().setX(square.getStartingX()+(SQUARE_HEIGH *right));
            square.getRectangle().setY(square.getStartingY()+(SQUARE_HEIGH *down));
        }
    }

    private boolean checkBoardCollision(int[] x, int[] y){
        for (int i=0;i<x.length;i++){
            if (x[i] + right<0 || x[i]+right>=GameBoard.MAX_X) return false;
            if (y[i] + down<0 || y[i]+down>=GameBoard.MAX_Y) return false;
            if (gameBoard[x[i] + right][y[i] + down] != null) {
                return false;
        }

        }
        return true;
    }


    private void swapCollisionObjects(){
        ArrayList<Square> temp;
        temp= movingLeftObjects;
        movingLeftObjects=movingDownObjects;
        movingDownObjects=movingRightObjects;
        movingRightObjects=movingUpObjects;
        movingUpObjects=temp;
    }

    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
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

    public void setDown(int down) {
        this.down = down;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public static int getStartingX() {
        return STARTING_X;
    }

    protected abstract void initMovingObjects();

    protected abstract void positionBlock4();
    protected abstract void positionBlock2();
    protected abstract void positionBlock3();
    public Square[] getFigure() {
        return figure;
    }

    public int getPositionX(Square square){
        return square.getStartingArrayX()+right;
    }

    public int getPositionY(Square square){
        return square.getStartingArrayY()+down;
    }
}
