package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import shape.AllShapes.*;
import shape.Shape;
import shape.*;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Game implements Runnable, EventHandler<KeyEvent> {
    private Pane gameRoot;
    private GameBoard gameBoard = GameBoard.getInstance();
    private Shape falling, nextBlock;
    private boolean playing = true;
    private static int moveSpeed=400;


    Game(Pane mainRoot, Scene scene) {
        Background background = new Background(); //todo background extends pane/group
        gameRoot = new Pane();
        initialBlockSpawn();
        scene.setOnKeyPressed(this);
        mainRoot.getChildren().addAll(background.getGroup(), gameRoot, ScoreBoard.getInstance().getT());
        new Thread(this).start();
    }


    @Override
    public void run() {
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
                gameBoard.newPositionDown(falling);
                checkWinCondition();
                checkLoseCondition();
                 swapBlocks();
            }
        }

    private void checkWinCondition()
    {
        Platform.runLater(()->{
            gameBoard.checkWinCondition(gameRoot);
        });
    }
    private void checkLoseCondition(){
        if (falling.getDown()<3){
            playing=false;
            ScoreBoard.getInstance().setLost();
        }
    }
    private Shape spawnNewShape() {
        Random r=new Random();
       ShapeType shapeType=ShapeType.values()[r.nextInt(ShapeType.values().length-1)];
        switch (shapeType){
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
private void addShape(Shape shape){
    Platform.runLater(() -> gameRoot.getChildren().add(shape.getGroup()));
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
            }
        }

    }
    private void initialBlockSpawn(){
        falling=spawnNewShape();
        addShape(falling);
        nextBlock=spawnNewShape();
        nextBlock.positionNextBlock();
        addShape(nextBlock);
    }


    private void swapBlocks(){
        falling=nextBlock;
        falling.setDown(0);
        falling.setRight(Shape.getStartingX());
        falling.setPosition();
        nextBlock=spawnNewShape();
        nextBlock.positionNextBlock();
        addShape(nextBlock);
    }
    static void setMoveSpeed(){
        if (moveSpeed!=200){
            moveSpeed=moveSpeed-10;
        }
    }
}
