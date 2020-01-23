package sample;

import Shape.Shape;
import javafx.application.Platform;
import javafx.scene.Group;
import Shape.Square_Shape;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    private Shape shape;
    private Group group;
    Thread thread = new Thread(this);

    public Game(Shape shape) throws InterruptedException {
        thread.start();
        this.shape=shape;

    }

    @Override
    public void run() {
        int i = 0;
        while (i < 5) {
            shape.moveDown();
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                shape.removeBottom();
            }
        });

    }
    }
