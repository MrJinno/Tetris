package sample;

import Shape.Shape;
import javafx.application.Platform;
import javafx.scene.Group;
import Shape.Square_Shape;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    private ArrayList<Shape> shape;
    private Group group;
    Thread thread = new Thread(this);
    GameBoard gameBoard = GameBoard.getInstance();


    public Game(ArrayList<Shape> shape, Group group) throws InterruptedException {
        thread.start();
        this.shape = shape;
        this.group = group;

    }

    @Override
    public void run() {
        for (int j=0;j<shape.size();j++) {
            while (gameBoard.isMovableDown(shape.get(j))){
                shape.get(j).moveDown();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
