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
    private Scene scene;


    public Game(Pane mainRoot, Scene scene) {
        this.scene=scene;
        Background background = new Background(); //todo background extends pane/group
        gameRoot = new Pane();
        initialBlockSpawn();
        this.scene.setOnKeyPressed(this);
        mainRoot.getChildren().addAll(background.getGroup(), gameRoot, ScoreBoard.getInstance().getT());

        new Thread(this).start();
    }


    @Override
    public void run() {
        while (true) {
            try {
                tickGame();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }

    private void tickGame() throws InterruptedException {
        while (playing) {
            Thread.sleep(250);
            if (Shape.isMovableDown(falling)) {
               falling.moveDown();
            } else {
                gameBoard.newPositionDown(falling);
                checkWinCondition();
                checkLoseCondition();
                 swapblocks();
            }
        }

    }

    public void checkWinCondition()
    {
        Platform.runLater(()->{
            gameBoard.checkWinCondition(gameRoot);
        });
    }
    public void checkLoseCondition(){
        if (falling.getDown()<3){
            playing=false;
            ScoreBoard.getInstance().setLost();
        }
    }
    private Shape spawnNewShape() {
        Random r=new Random();
       ShapeType shapeType=ShapeType.values()[r.nextInt(ShapeType.values().length-1)];
       // ShapeType shapeType=ShapeType.I_SHAPE;
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
public void addShape(Shape shape){
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
            }
        }

    }
    public void initialBlockSpawn(){
        falling=spawnNewShape();
        addShape(falling);
        nextBlock=spawnNewShape();
        nextBlock.positionNextBlock();
        addShape(nextBlock);
    }


    public void swapblocks(){
        falling=nextBlock;
        falling.setDown(0);
        falling.setRight(Shape.getStartingX());
        falling.setPosition();
        nextBlock=spawnNewShape();
        nextBlock.positionNextBlock();
        addShape(nextBlock);
    }

    //OO0
    //O**
    //*

    //XY
    // shape -> kosta ma punkty
    // 0,0,
    // 1,0,
    //0,1
    //1,1
    /*
    * Shape collisionPoins = new Shape();
    * shape.addPoint(0,2);
    * shape.addPoint (1,2);
    * if(boardShape.hasCollision(shape)){
    * boardShape.merge(falling);
    * spawnNew();
    * }else{
    * move();
    * }
    * */
    //  hasCollision


}
