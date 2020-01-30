package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Z_Shape extends Shape {
    private static final int SQUARE_HEIGH=Square.getHEIGHT();
    private static final int MIN_POSITION=50;
    private Square[]figure =new Square[4];
    private Color color=Shape.randomizeColor();
    private Group bigSquare=new Group();
    private int startingRight=4;
    private int down=0,right=startingRight, position=0;
    private ArrayList<Square> movingDownObjects, movingLeftObjects, movingRightObjects, movingUpObjects;

    public Z_Shape() {
        figure[0]=new Square(color);
        bigSquare.getChildren().add(figure[0].getRectangle());

        figure[1]=new Square(color);
        bigSquare.getChildren().add(figure[1].getRectangle());

        figure[2]=new Square(color);
        bigSquare.getChildren().add(figure[2].getRectangle());

        figure[3]=new Square(color);
        bigSquare.getChildren().add(figure[3].getRectangle());

        positionBlock1();
        setPosition();
        initMovingObjects();

    }
    public Group getGroup() {
        return bigSquare;
    }
    @Override
    public void moveLeft() {
        if (Shape.isMovableLeftRight(this, right-1, getMovingLeftObjects())) {
            right--;
            setPosition();
        }
    }
    public void setPosition( ){
        for (Square square:figure){
            square.getRectangle().setX(square.getStartingX()+(SQUARE_HEIGH*right));
            square.getRectangle().setY(square.getStartingY()+(SQUARE_HEIGH*down));
        }
    }
    @Override
    public void moveRight() {
        if (Shape.isMovableLeftRight(this, right+1, getMovingRightObjects())) {
            right++;
            setPosition();
        }

    }
    public int getPositionX(Square square){
        return square.getStartingArrayX()+right;
    }
    public int getPositionY(Square square){
        return square.getStartingArrayY()+down;
    }


    @Override
    public void moveDown() {
        if (isMovableDown(this)) {
            down++;
            setPosition();
        }
    }

    @Override
    public void rotate() {
        switch (position){
            case 0:
                positionBlock2();
                position=1;
                break;
            case 1:
                positionBlock3();
                position=2;
                break;
            case 2:
                positionBlock4();
                position=3;
                break;
            case 3:
                positionBlock1();
                position=0;
                break;
        }
        swapCollicionObjects();
        setPosition();
    }

    private void positionBlock1(){
        figure[0].setStartingX(MIN_POSITION);
        figure[0].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[0].setStartingArrayX(0);
        figure[0].setStartingArrayY(1);

        figure[1].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[1].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[1].setStartingArrayX(1);
        figure[1].setStartingArrayY(1);

        figure[2].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[2].setStartingY(MIN_POSITION);
        figure[2].setStartingArrayX(1);
        figure[2].setStartingArrayY(0);

        figure[3].setStartingX(MIN_POSITION+SQUARE_HEIGH*2);
        figure[3].setStartingY(MIN_POSITION);
        figure[3].setStartingArrayX(2);
        figure[3].setStartingArrayY(0);

    }
    private void positionBlock2(){
        figure[0].setStartingX(MIN_POSITION);
        figure[0].setStartingY(MIN_POSITION-SQUARE_HEIGH);
        figure[0].setStartingArrayX(0);
        figure[0].setStartingArrayY(-1);

        figure[1].setStartingX(MIN_POSITION);
        figure[1].setStartingY(MIN_POSITION);
        figure[1].setStartingArrayX(0);
        figure[1].setStartingArrayY(0);

        figure[3].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[3].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[3].setStartingArrayX(1);
        figure[3].setStartingArrayY(1);

    }
    private void positionBlock3(){
        figure[0].setStartingX(MIN_POSITION+2*SQUARE_HEIGH);
        figure[0].setStartingY(MIN_POSITION-SQUARE_HEIGH);
        figure[0].setStartingArrayX(2);
        figure[0].setStartingArrayY(-1);

        figure[1].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[1].setStartingY(MIN_POSITION-SQUARE_HEIGH);
        figure[1].setStartingArrayX(1);
        figure[1].setStartingArrayY(-1);


        figure[3].setStartingX(MIN_POSITION);
        figure[3].setStartingY(MIN_POSITION);
        figure[3].setStartingArrayX(0);
        figure[3].setStartingArrayY(0);
    }
    private void positionBlock4(){
        figure[0].setStartingX(MIN_POSITION+2*SQUARE_HEIGH);
        figure[0].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[0].setStartingArrayX(2);
        figure[0].setStartingArrayY(1);

        figure[1].setStartingX(MIN_POSITION+2*SQUARE_HEIGH);
        figure[1].setStartingY(MIN_POSITION);
        figure[1].setStartingArrayX(2);
        figure[1].setStartingArrayY(0);


        figure[3].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[3].setStartingY(MIN_POSITION-SQUARE_HEIGH);
        figure[3].setStartingArrayX(1);
        figure[3].setStartingArrayY(-1);
    }


    public int getDown() {
        return down;
    }

    public Square[] getFigure() {
        return figure;
    }

    public int getRight() {
        return right;
    }

    public void initMovingObjects() {
        movingUpObjects=new ArrayList<>();
        movingDownObjects =new ArrayList<>();
        movingLeftObjects = new ArrayList<>();
        movingRightObjects =new ArrayList<>();
        movingUpObjects.add(figure[0]);
        movingUpObjects.add(figure[2]);
        movingUpObjects.add(figure[3]);
        movingDownObjects.add(figure[0]);
        movingDownObjects.add(figure[1]);
        movingDownObjects.add(figure[3]);
        movingLeftObjects.add(figure[0]);
        movingLeftObjects.add(figure[2]);
        movingRightObjects.add(figure[1]);
        movingRightObjects.add(figure[3]);

    }
    public ArrayList<Square> getMovingDownObjects() {
        return movingDownObjects;
    }

    public ArrayList<Square> getMovingLeftObjects() {
        return movingLeftObjects;
    }

    public ArrayList<Square> getMovingRightObjects() {
        return movingRightObjects;
    }

    public void swapCollicionObjects(){
        ArrayList<Square> temp;
        temp= movingLeftObjects;
        movingLeftObjects=movingDownObjects;
        movingDownObjects=movingRightObjects;
        movingRightObjects=movingUpObjects;
        movingUpObjects=temp;
    }

}
