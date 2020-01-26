package Shape;

import java.awt.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Square {
    public static final int HEIGHT=25;
    private int startingX, startingY, startingArrayX, StartingArrayY;

    public int getStartingX() {
        return startingX;
    }

    public void setStartingX(int startingX) {
        this.startingX = startingX;
    }

    public int getStartingY() {
        return startingY;
    }

    public void setStartingY(int startingY) {
        this.startingY = startingY;
    }

    private Color color;
    Rectangle rectangle;

    public Square(Color color) {
        rectangle=new Rectangle();
        rectangle.setWidth(HEIGHT);
        rectangle.setHeight(HEIGHT);
        rectangle.setArcHeight(5);
        rectangle.setArcWidth(5);
        rectangle.setStroke(Color.BLACK);
        this.color=color;
        rectangle.setFill(this.color);
    }
    public Square(Color color, int startingX, int startingY, int startingArrayX, int getStartingArrayY){
        rectangle=new Rectangle();
        rectangle.setWidth(HEIGHT);
        rectangle.setHeight(HEIGHT);
        rectangle.setArcHeight(5);
        rectangle.setArcWidth(5);
        rectangle.setStroke(Color.BLACK);
        this.color=color;
        rectangle.setFill(this.color);
        this.startingX=startingX;
        this.startingY=startingY;
    }

    public int getStartingArrayX() {
        return startingArrayX;
    }

    public int getStartingArrayY() {
        return StartingArrayY;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public Color getColor() {
        return color;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public String toString() {
        return "Square{" +
                "color=" + color + " X=" + rectangle.getX() + " Y=" + rectangle.getY();
    }
}


