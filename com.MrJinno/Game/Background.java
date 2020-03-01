package Game;

import javafx.scene.layout.Pane;
import shape.GameBoardSquare;
import shape.Square;
import javafx.scene.paint.Color;

public class Background extends Pane {
    public static final int SQUARE_HEIGHT = 25;
    private static final int BOARD_HEIGHT = 550;
    private static final int BOARD_WIDTH = 300;
    private static final int MIN_X_INDEX = 0, MIN_Y_INDEX = 0;
    private static final int maxX = (BOARD_WIDTH / SQUARE_HEIGHT);
    private static final int maxY = (BOARD_HEIGHT / SQUARE_HEIGHT);
    private static final int MAX_BOARD_ARRAY = 25;
    private Square[][] background = new Square[MAX_BOARD_ARRAY][MAX_BOARD_ARRAY];
    private Square[][] board = new Square[(BOARD_HEIGHT / SQUARE_HEIGHT)][(BOARD_WIDTH / SQUARE_HEIGHT)];
    static final int Y_BOARD_SIZE = BOARD_HEIGHT / SQUARE_HEIGHT - 2; //20
    static final int X_BOARD_SIZE = BOARD_WIDTH / SQUARE_HEIGHT - 2; //10
    private static final int NEXT_BLOCK_BOARD_MIN_Y = 7;
    private static final int NEXT_BLOCK_BOARD_MIN_X = maxX;
    private static final int NEXT_BLOCK_BOARD_MAX_Y = 12;

   public Background() {
        createBackGround();
        fillTheBoard();
        scoreBoard();
        nextBlockBoard();
    }

    private void createBackGround() {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 24; j++) {
                background[i][j] = new Square(Color.GRAY);
                background[i][j].getRectangle().setX(SQUARE_HEIGHT * i);
                background[i][j].getRectangle().setY(SQUARE_HEIGHT * j);
                addToGroup(background[i][j]);
            }
        }
    }

    private void fillTheBoard() {
        for (int i = MIN_Y_INDEX + 1; i < maxY - 1; i++) {
            for (int j = MIN_X_INDEX + 1; j < maxX - 1; j++) {
                board[i][j] = new GameBoardSquare();
                board[i][j].getRectangle().setY(MIN_Y_INDEX + (SQUARE_HEIGHT * i) + SQUARE_HEIGHT);
                board[i][j].getRectangle().setX(MIN_X_INDEX + (SQUARE_HEIGHT * j) + SQUARE_HEIGHT);
                addToGroup(board[i][j]);
            }
        }
    }

    private void scoreBoard() {
        for (int i = MIN_Y_INDEX + 2; i < 5; i++) {
            for (int j = maxX; j < maxX + 6; j++) {
                background[i][j] = new GameBoardSquare();
                background[i][j].getRectangle().setY(MIN_Y_INDEX + (SQUARE_HEIGHT * i) + SQUARE_HEIGHT);
                background[i][j].getRectangle().setX(MIN_X_INDEX + (SQUARE_HEIGHT * j) + SQUARE_HEIGHT);
                addToGroup(background[i][j]);
            }
        }
    }

    private void nextBlockBoard() {
        for (int i = NEXT_BLOCK_BOARD_MIN_Y; i < NEXT_BLOCK_BOARD_MAX_Y; i++) {
            for (int j = NEXT_BLOCK_BOARD_MIN_X; j < maxX + 6; j++) {
                background[i][j] = new GameBoardSquare();
                background[i][j].getRectangle().setY(MIN_Y_INDEX + (SQUARE_HEIGHT * i) + SQUARE_HEIGHT);
                background[i][j].getRectangle().setX(MIN_X_INDEX + (SQUARE_HEIGHT * j) + SQUARE_HEIGHT);
                addToGroup(background[i][j]);
            }
        }
    }

    private void addToGroup(Square square) {
        getChildren().add(square.getRectangle());
    }
}
