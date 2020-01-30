package shape;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square {
    private static final int HEIGHT=25;
    public int getStartingX() {
        return startingX;
    }

    private int startingX, startingY, startingArrayX, startingArrayY;

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
    public Square(Color color, int startingX, int startingY, int startingArrayX, int startingArrayY){
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
        this.startingArrayX=startingArrayX;
        this.startingArrayY=startingArrayY;
    }
    public void movebottom(){
        rectangle.setY(rectangle.getY()+HEIGHT);
    }

    public void setStartingArrayX(int startingArrayX) {
        this.startingArrayX = startingArrayX;
    }

    public void setStartingArrayY(int startingArrayY) {
        this.startingArrayY = startingArrayY;
    }

    public int getStartingArrayX() {
        return startingArrayX;
    }

    public int getStartingArrayY() {
        return startingArrayY;
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


