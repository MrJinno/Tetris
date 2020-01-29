package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import shape.Shape;
import shape.Square_Shape;
import shape.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class Game implements Runnable, EventHandler<KeyEvent> {
    private Pane gameRoot;
    private GameBoard gameBoard = GameBoard.getInstance();
    private Shape falling;
    private boolean playing = true;
    private Scene scene;


    public Game(Pane mainRoot, Scene scene) {
        this.scene=scene;
        Background background = new Background(); //todo background extends pane/group
        gameRoot = new Pane();
        spawnNewShape();
        this.scene.setOnKeyPressed(this);
        mainRoot.getChildren().addAll(background.getGroup(), gameRoot);
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
                gameBoard.checkWinCondition(gameRoot);
                System.out.println("down: " + falling.getDown() + "right" + falling.getRight());
                spawnNewShape();
            }
        }

    }

    private void spawnNewShape() {
        Random r=new Random();
        ShapeType shapeType=ShapeType.values()[r.nextInt(ShapeType.values().length-1)];
        falling= new Square_Shape();
    switch (shapeType){
        case L_SHAPE:
            falling= new L_Shape();
            break;
        case SQUARE:
            falling= new Square_Shape();
            break;
    }

    Platform.runLater(() -> gameRoot.getChildren().add(falling.getGroup()));
    }

    @Override
    public void handle(KeyEvent keyEvent) {
    switch (keyEvent.getCode()){
        case LEFT: falling.moveLeft(); break;
        case RIGHT:falling.moveRight(); break;
        case UP: falling.rotate(); break;
    }
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
