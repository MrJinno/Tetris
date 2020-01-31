package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Background;

public class Square {
    private static final int HEIGHT= Background.SQUARE_HEIGH;
    private static final int MIN_POSITION=HEIGHT*2;
    private int startingX, startingY, startingArrayX, startingArrayY;

    public int getStartingX() {
        return startingX;
    }


    public int getStartingY() {
        return startingY;
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

    public void movebottom(){
        rectangle.setY(rectangle.getY()+HEIGHT);
    }

    public void setPositionXArray(int startingArrayX) {
        startingX=MIN_POSITION+HEIGHT*startingArrayX;
        this.startingArrayX = startingArrayX;
    }

    public void setPositionYArray(int startingArrayY) {
        startingY=MIN_POSITION+HEIGHT*startingArrayY;
        this.startingArrayY = startingArrayY;
    }

    public int getStartingArrayX() {
        return startingArrayX;
    }

    public int getStartingArrayY() {
        return startingArrayY;
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


