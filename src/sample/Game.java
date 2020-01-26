package sample;

import Shape.Shape;
import javafx.application.Platform;
import javafx.scene.Group;
import Shape.Square_Shape;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    private ArrayList<Square_Shape> shape;
    private Group group;
    Thread thread = new Thread(this);
    GameBoard gameBoard = GameBoard.getInstance();


    public Game(ArrayList<Square_Shape> shape, Group group) throws InterruptedException {
        thread.start();
        this.shape = shape;
        this.group = group;

    }

    @Override
    public void run() {
        for (int j=0;j<shape.size();j++) {
            int i = 1;
            while (i < GameBoard.MAX_Y - 1) {
                if (!gameBoard.isMovableDown(shape.get(j).getFigure(), shape.get(j).getDown(), shape.get(j).getRight())) break;
                shape.get(j).moveDown();
                i++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
