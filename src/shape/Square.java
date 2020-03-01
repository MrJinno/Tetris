package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Game.Background;

public class Square {
    private static final int HEIGHT = Background.SQUARE_HEIGHT;
    private static final int MIN_POSITION = HEIGHT * 2;
    private int startingX, startingY, startingArrayX, startingArrayY;
    private Rectangle rectangle;

    public Square(Color color) {
        rectangle = new Rectangle();
        rectangle.setWidth(HEIGHT);
        rectangle.setHeight(HEIGHT);
        rectangle.setArcHeight(5);
        rectangle.setArcWidth(5);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(color);
    }

    public void moveBottom() {
        rectangle.setY(rectangle.getY() + HEIGHT);
    }

    public void setPositionX(int startingArrayX) {
        startingX = MIN_POSITION + HEIGHT * startingArrayX;
        this.startingArrayX = startingArrayX;
    }

    public void setPositionY(int startingArrayY) {
        startingY = MIN_POSITION + HEIGHT * startingArrayY;
        this.startingArrayY = startingArrayY;
    }

    int getStartingArrayX() {
        return startingArrayX;
    }

    int getStartingArrayY() {
        return startingArrayY;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    int getStartingX() {
        return startingX;
    }

    int getStartingY() {
        return startingY;
    }
}


