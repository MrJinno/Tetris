package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import sample.UserInteraction.Music;
import shape.Shape;
import shape.Square;

public class GameBoard {
    public static final int MAX_Y_BOARD_INDEX = Background.Y_BOARD_SIZE;
    public static final int MAX_X_BOARD_INDEX = Background.X_BOARD_SIZE;
    private static final Square[][] BOARD = new Square[MAX_X_BOARD_INDEX][MAX_Y_BOARD_INDEX];
    private static final GameBoard GAME_BOARD = new GameBoard();
    private int gameBoardRow;
    private ScoreBoard scoreBoard = ScoreBoard.getInstance();

    private GameBoard() {
    }

    public static GameBoard getInstance() {
        return GAME_BOARD;
    }

    void addFallingBlockToGameBoardShape(Shape shape) {
        for (Square square : shape.getFigure()) {
            BOARD[shape.getPositionX(square)][shape.getPositionY(square)] = square;
        }
    }

    void handleWinCondition(Pane root) {
        Group group = new Group();
        if (checkRowWinCondition(MAX_Y_BOARD_INDEX - 1)) {
            initializeWinActions(root, group);
            handleWinCondition(root);
        }
    }

    private boolean checkRowWinCondition(int rowNumber) {
        if (rowNumber == 1) return false;
        if (checkRow(rowNumber)) {
            gameBoardRow = rowNumber;
            return true;
        } else return checkRowWinCondition(rowNumber - 1);
    }

    private void initializeWinActions(Pane root, Group group) {
        for (int i = 0; i < MAX_X_BOARD_INDEX; i++) {
            group.getChildren().add(BOARD[i][gameBoardRow].getRectangle());
            BOARD[i][gameBoardRow] = null;
        }
        moveBlocks();
        root.getChildren().remove(group);
        scoreBoard.increaseScore();
        Game.increaseMoveSpeed();
        new Music("sparkle.mp3");
    }

    private boolean checkRow(int rowNumber) {
        for (Square[] squares : BOARD) {
            if (squares[rowNumber] == null) return false;
        }
        return true;
    }

    private void moveBlocks() {
        for (int i = gameBoardRow - 1; i >= 0; i--) {
            for (int j = 0; j < BOARD.length; j++) {
                Square temp;
                if (BOARD[j][i] != null) {
                    BOARD[j][i].moveBottom();
                    temp = BOARD[j][i];
                    BOARD[j][i] = null;
                    BOARD[j][i + 1] = temp;
                }
            }
        }
    }

    public Square[][] getBoard() {
        return BOARD;
    }
}
