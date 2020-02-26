package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.Background;
import sample.GameBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Shape implements Shapes {
    private static final int STARTING_X_INDEX = 4, STARTING_Y_INDEX= 0, NEXT_BLOCK_X_INDEX = 12, NEXT_BLOCK_Y_INDEX = 7;
    protected Square[] figure = new Square[4];
    private int downIndex = STARTING_Y_INDEX, rightIndex = STARTING_X_INDEX, position = 0;
    private Square[][] gameBoard = GameBoard.getInstance().getBoard();
    private Group bigSquare = new Group();
    protected int[] index_X_After_Rotation, index_Y_After_Rotation;
    protected ArrayList<Square> movingDownObjects, movingLeftObjects, movingRightObjects, movingUpObjects;

    public Shape() {
        Color color = randomizeColor();
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

    private Color randomizeColor() {
        Random r = new Random();
        return ShapeColorType.values()[r.nextInt(ShapeColorType.values().length-1)].color;
    }

    public void updatePosition() {
        for (Square square : figure) {
            int SQUARE_HEIGHT = Background.SQUARE_HEIGHT;
            square.getRectangle().setX(square.getStartingX() + (SQUARE_HEIGHT * rightIndex));
            square.getRectangle().setY(square.getStartingY() + (SQUARE_HEIGHT * downIndex));
        }
    }

    public void moveRight() {
        if (Shape.isMovableSideWays(this, rightIndex + 1, getMovingRightObjects())) {
            rightIndex++;
            updatePosition();
        }
    }

    public void moveLeft() {
        if (Shape.isMovableSideWays(this, rightIndex - 1, getMovingLeftObjects())) {
            rightIndex--;
            updatePosition();
        }
    }

    public void moveDown() {
        if (isMovableDown(this)) {
            downIndex++;
            updatePosition();
        }
    }

    private static boolean isMovableSideWays(Shape shape, int rightIndex, ArrayList<Square> squares) {
        Square[][] gameBoard = GameBoard.getInstance().getBoard();
        int down = shape.getDownIndex();
        for (Square sqr : squares) {
            if (sqr.getStartingArrayX() + rightIndex + 1 == 0) return false;
            if (sqr.getStartingArrayX() + rightIndex == GameBoard.MAX_X_BOARD_INDEX) return false;
            if (gameBoard[sqr.getStartingArrayX() + rightIndex][sqr.getStartingArrayY() + down] != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMovableDown(Shape shape) {
        Square[][] gameBoard = GameBoard.getInstance().getBoard();
        int down = shape.getDownIndex();
        int right = shape.getRightIndex();
        List<Square> sqr = shape.getMovingDownObjects();
        down++;
        for (Square square : sqr) {
            if (square.getStartingArrayY() + down >= GameBoard.MAX_Y_BOARD_INDEX) return false;
            if (gameBoard[square.getStartingArrayX() + right][square.getStartingArrayY() + down] != null) {
                return false;
            }
        }
        return true;
    }

    public void rotate() {
        if (checkBoardCollision(index_X_After_Rotation, index_Y_After_Rotation)) {
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

    private void swapCollisionObjects() {
        ArrayList<Square> temp;
        temp = movingLeftObjects;
        movingLeftObjects = movingDownObjects;
        movingDownObjects = movingRightObjects;
        movingRightObjects = movingUpObjects;
        movingUpObjects = temp;
    }

    public void positionNextBlock() {
        rightIndex = NEXT_BLOCK_X_INDEX;
        downIndex = NEXT_BLOCK_Y_INDEX;
        updatePosition();
    }

    private boolean checkBoardCollision(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] + rightIndex < 0 || x[i] + rightIndex >= GameBoard.MAX_X_BOARD_INDEX) return false;
            if (y[i] + downIndex < 0 || y[i] + downIndex >= GameBoard.MAX_Y_BOARD_INDEX) return false;
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

    private List<Square> getMovingDownObjects() {
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

    public static int getStartingXIndex() {
        return STARTING_X_INDEX;
    }

    public int getPositionY(Square square) {
        return square.getStartingArrayY() + downIndex;
    }
}
