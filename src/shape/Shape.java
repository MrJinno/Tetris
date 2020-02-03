package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.Background;
import sample.GameBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Shape implements Shapes {
    private static final int STARTING_X = 4, NEXT_BLOCK_X = 12, NEXT_BLOCK_Y = 7;
    protected Square[] figure = new Square[4];
    private int downIndex = 0, rightIndex = STARTING_X, position = 0;
    private Square[][] gameBoard = GameBoard.getInstance().getBoard();
    private Group bigSquare = new Group();
    protected int[] nextX, nextY;
    protected ArrayList<Square> movingDownObjects, movingLeftObjects, movingRightObjects, movingUpObjects;

    public Shape() {
        Color color = Shape.randomizeColor();
        for (int i = 0; i < figure.length; i++) {
            figure[i] = new Square(color);
            bigSquare.getChildren().add(figure[i].getRectangle());
        }
        positionBlock1();
        updatePosition();
        initMovingObjects();
    }

    protected abstract void positionBlock1();
    protected abstract void positionBlock2();
    protected abstract void positionBlock3();
    protected abstract void positionBlock4();
    protected abstract void initMovingObjects();

    @Override
    public void moveRight() {
        if (Shape.isMovableLeftRight(this, rightIndex + 1, getMovingRightObjects())) {
            rightIndex++;
            updatePosition();
        }
    }

    @Override
    public void moveDown() {
        if (isMovableDown(this)) {
            downIndex++;
            updatePosition();
        }
    }

    public void moveLeft() {
        if (Shape.isMovableLeftRight(this, rightIndex - 1, getMovingLeftObjects())) {
            rightIndex--;
            updatePosition();
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
            updatePosition();
        }
    }

    public static boolean isMovableDown(Shape shape) {
        Square[][] plansza = GameBoard.getInstance().getBoard();
        int down = shape.getDownIndex();
        int right = shape.getRightIndex();
        List<Square> sqr = shape.getMovingDownObjects();
        down++;
        for (Square square : sqr) {
            if (square.getStartingArrayY() + down >= GameBoard.MAX_Y) return false;
            if (plansza[square.getStartingArrayX() + right][square.getStartingArrayY() + down] != null) {
                return false;
            }
        }
        return true;
    }

    public void updatePosition() {
        for (Square square : figure) {
            int SQUARE_HEIGH = Background.SQUARE_HEIGH;
            square.getRectangle().setX(square.getStartingX() + (SQUARE_HEIGH * rightIndex));
            square.getRectangle().setY(square.getStartingY() + (SQUARE_HEIGH * downIndex));
        }
    }

    public void positionNextBlock() {
        rightIndex = NEXT_BLOCK_X;
        downIndex = NEXT_BLOCK_Y;
        updatePosition();
    }

    private static Color randomizeColor() {
        Random r = new Random();
        Color[] colors = new Color[5];
        colors[0] = Color.BLUE;
        colors[1] = Color.RED;
        colors[2] = Color.YELLOW;
        colors[3] = Color.GREEN;
        colors[4] = Color.PURPLE;
        int colorInt = r.nextInt(5);
        return colors[colorInt];
    }

    private static boolean isMovableLeftRight(Shape shape, int right, ArrayList<Square> squares) {
        Square[][] gameBoard = GameBoard.getInstance().getBoard();
        int down = shape.getDownIndex();
        for (Square sqr : squares) {
            if (sqr.getStartingArrayX() + right + 1 == 0) return false;
            if (sqr.getStartingArrayX() + right == GameBoard.MAX_X) return false;
            if (gameBoard[sqr.getStartingArrayX() + right][sqr.getStartingArrayY() + down] != null) {
                return false;
            }
        }
        return true;
    }

    private void swapCollisionObjects() {
        ArrayList<Square> temp;
        temp = movingLeftObjects;
        movingLeftObjects = movingDownObjects;
        movingDownObjects = movingRightObjects;
        movingRightObjects = movingUpObjects;
        movingUpObjects = temp;
    }

    private boolean checkBoardCollision(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] + rightIndex < 0 || x[i] + rightIndex >= GameBoard.MAX_X) return false;
            if (y[i] + downIndex < 0 || y[i] + downIndex >= GameBoard.MAX_Y) return false;
            if (gameBoard[x[i] + rightIndex][y[i] + downIndex] != null) {
                return false;
            }
        }
        return true;
    }

    public int getDownIndex() {
        return downIndex;
    }

    private int getRightIndex() {
        return rightIndex;
    }

    public void setDownIndex(int downIndex) {
        this.downIndex = downIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

    public Group getGroup() {
        return bigSquare;
    }

    private ArrayList<Square> getMovingDownObjects() {
        return movingDownObjects;
    }

    private ArrayList<Square> getMovingLeftObjects() {
        return movingLeftObjects;
    }

    private ArrayList<Square> getMovingRightObjects() {
        return movingRightObjects;
    }

    public Square[] getFigure() {
        return figure;
    }

    public int getPositionX(Square square) {
        return square.getStartingArrayX() + rightIndex;
    }

    public static int getStartingX() {
        return STARTING_X;
    }

    public int getPositionY(Square square) {
        return square.getStartingArrayY() + downIndex;
    }
}
