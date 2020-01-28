package shape;


import javafx.scene.shape.Rectangle;

public class Point extends Rectangle {
    private static final int SIZE = 25;

    private int left,down;
    private int myX;
    private int myY;

    public Point(int myX, int myY) {
        this.myX = myX;
        this.myY = myY;
    }

    public Point(int left, int down, int myX, int myY) {
        this.left = left;
        this.down = down;
        this.myX = myX;
        this.myY = myY;
    }

    public void update() {
     setX(myX * SIZE);
     setY(myY * SIZE);
    }

    public int getMyX() {
        return myX + left;
    }

    public int getMyY() {
        return myY + down;
    }
}
