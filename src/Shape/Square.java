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
    public Square(Color color, Square square){
        rectangle=new Rectangle();
        rectangle.setWidth(HEIGHT);
        rectangle.setHeight(HEIGHT);
        rectangle.setArcHeight(5);
        rectangle.setArcWidth(5);
        rectangle.setStroke(Color.BLACK);
        this.color=color;
        rectangle.setFill(this.color);
        rectangle.setX(square.getRectangle().getX());
        rectangle.setY(square.getRectangle().getY());
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
}

