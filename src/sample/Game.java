package sample;

import Shape.Shape;

import java.util.concurrent.TimeUnit;

public class Game extends Runnable {
private Shape shape;

    public Game(Shape shape) throws InterruptedException {
        this.shape = shape;
        
        }

    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            shape.moveDown();
        }




    }
}

