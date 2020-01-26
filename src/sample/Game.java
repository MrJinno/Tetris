package sample;

import Shape.Shape;
import javafx.application.Platform;
import javafx.scene.Group;
import Shape.Square_Shape;
import Shape.*;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    private ArrayList<Shape> shapes=new ArrayList<Shape>();
    private Group group;
    Thread thread = new Thread(this);
    GameBoard gameBoard = GameBoard.getInstance();


    public Game( Group group) throws InterruptedException {

        this.group = group;
        shapes.add(new Square_Shape());
        shapes.add(new Square_Shape());
        Square_Shape sqr=new Square_Shape();
        sqr.setRight(5);
        shapes.add(sqr);
        shapes.add(new L_Shape());
        shapes.add(new L_Shape());
        for (Shape shape:shapes){
            group.getChildren().add(shape.getGroup());
        }
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            for (int j = 0; j < shapes.size(); j++) {
                while (gameBoard.isMovableDown(shapes.get(j))) {
                     shapes.get(j).moveDown();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
           /* Platform.runLater(() ->{
                shapes.add(new L_Shape());
                group.getChildren().add(shapes.get(shapes.size()-1).getGroup());
            });
*/

        }
    }





}
