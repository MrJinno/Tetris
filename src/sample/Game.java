package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import sample.UserInteraction.RankingManager;
import sample.UserInteraction.SaveScoreWindow;
import shape.AllShapes.*;
import shape.Shape;
import shape.*;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Game implements Runnable, EventHandler<KeyEvent> {
    private Pane gameRoot;
    private GameBoard gameBoard = GameBoard.getInstance();
    private Shape falling, nextBlock;
    private boolean playing = false;
    private static int moveSpeed = 400;
    private RankingManager rankingManager;

    public Game(Pane mainRoot, RankingManager rankingManager) {
        this.rankingManager = rankingManager;
        Background background = new Background();
        gameRoot = new Pane();
        mainRoot.getScene().setOnKeyPressed(this);
        mainRoot.getChildren().addAll(background, gameRoot, ScoreBoard.getInstance().getText());
        new Thread(this).start();
    }

    @Override
    public void run() {
        initialBlockSpawn();
        handleGame();
        saveScoreWindow();
    }

    private void initialBlockSpawn() {
        falling = spawnNewShape();
        addShape(falling);
        initializeNextBlock();
    }

    private Shape spawnNewShape() {
        Random r = new Random();
        ShapeType shapeType = ShapeType.values()[r.nextInt(ShapeType.values().length - 1)];
        switch (shapeType) {
            case L_SHAPE:
                return new L_Shape();
            case SQUARE:
                return new Square_Shape();
            case Z_SHAPE:
                return new Z_Shape();
            case L_Shape2:
                return new L_Shape2();
            case Z_Shape2:
                return new Z_Shape2();
            case I_SHAPE:
                return new I_Shape();
            case _I_SHAPE:
                return new _I_Shape();
        }
        return new Square_Shape();
    }

    private void addShape(Shape shape) {
        Platform.runLater(() -> gameRoot.getChildren().add(shape.getGroup()));
    }

    private void initializeNextBlock() {
        nextBlock = spawnNewShape();
        nextBlock.positionNextBlock();
        addShape(nextBlock);
    }

    private void handleGame() {
        while (playing) {
            try {
                tickGame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void tickGame() throws InterruptedException {
        Thread.sleep(moveSpeed);
        if (Shape.isMovableDown(falling)) {
            falling.moveDown();
        } else {
            gameBoard.addFallingBlockToGameBoardShape(falling);
            handleWinCondition();
            checkLoseCondition();
            swapFallingBlockWithNextBlock();
        }
    }

    private void handleWinCondition() {
        Platform.runLater(() -> {
            gameBoard.handleWinCondition(gameRoot);
        });
    }

    private void checkLoseCondition() {
        if (falling.getDownIndex() < 3) {
            playing = false;
            ScoreBoard.getInstance().setLost();
        }
    }

    private void swapFallingBlockWithNextBlock() {
        falling = nextBlock;
        falling.setDownIndex(0);
        falling.setRightIndex(Shape.getStartingXIndex());
        falling.updatePosition();
        initializeNextBlock();
    }

    private void saveScoreWindow() {
        SaveScoreWindow saveScoreWindow = new SaveScoreWindow(rankingManager);
        saveScoreWindow.ShowSaveScoreWindow();
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (playing) {
            switch (keyEvent.getCode()) {
                case LEFT:
                    falling.moveLeft();
                    break;
                case RIGHT:
                    falling.moveRight();
                    break;
                case UP:
                    falling.rotate();
                    break;
                case DOWN:
                    falling.moveDown();
                    break;
                case ESCAPE:
                    System.exit(0);
                    break;
            }
        }
    }

    static void increaseMoveSpeed() {
        if (moveSpeed != 200) {
            moveSpeed = moveSpeed - 10;
        }
    }

    public void play() {
        playing = true;
    }
}
