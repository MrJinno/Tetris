package sample;

import javafx.application.Platform;
import shape.Shape;
import shape.Square_Shape;
import shape.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class Game implements Runnable {
    private Pane gameRoot;
    private GameBoard gameBoard = GameBoard.getInstance();
    private Shape falling;
    private boolean playing = true;


    public Game(Pane mainRoot) {
        Background background = new Background(); //todo background extends pane/group
        gameRoot = new Pane();
        spawnNewShape();
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
           /* Platform.runLater(() ->{
                shapes.add(new L_Shape());
                group.getChildren().add(shapes.get(shapes.size()-1).getGroup());
            });
*/
        }


    }

    private void tickGame() throws InterruptedException {
        while (playing) {
            Thread.sleep(250);
            if (gameBoard.isMovableDown(falling)) {
                falling.moveDown();
            } else {
                gameBoard.newPositionDown(falling);
                System.out.println("down: " + falling.getDown() + "right" + falling.getRight());
                spawnNewShape();
            }
        }

    }

    private void spawnNewShape() {
        Random r=new Random();
        int i=r.nextInt(2);
    falling= new Square_Shape();
    switch (i){
        case 0:
            falling= new L_Shape();
            break;
        case 1:
            falling= new Square_Shape();
            break;
    }

    Platform.runLater(() -> gameRoot.getChildren().add(falling.getGroup()));
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
