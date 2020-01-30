package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;

import java.util.ArrayList;


public class L_Shape extends Shape {

    public L_Shape() {
        super();

    }

    @Override
    public void moveRight() {
        if (Shape.isMovableLeftRight(this, right+1, getMovingRightObjects())) {
            right++;
            setPosition();
        }

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

    protected void positionBlock1(){
        figure[0].setStartingX(SQUARE_HEIGH*2);
        figure[0].setStartingY(SQUARE_HEIGH*2);
        figure[0].setStartingArrayX(0);
        figure[0].setStartingArrayY(0);

        figure[1].setStartingX(SQUARE_HEIGH*3);
        figure[1].setStartingY(SQUARE_HEIGH*2);
        figure[1].setStartingArrayX(1);
        figure[1].setStartingArrayY(0);

        figure[2].setStartingX(SQUARE_HEIGH*4);
        figure[2].setStartingY(SQUARE_HEIGH*2);
        figure[2].setStartingArrayX(2);
        figure[2].setStartingArrayY(0);

        figure[3].setStartingX(SQUARE_HEIGH*4);
        figure[3].setStartingY(SQUARE_HEIGH*3);
        figure[3].setStartingArrayX(2);
        figure[3].setStartingArrayY(1);

        checkCollision(3);

    }
    private void positionBlock2() {
        figure[0].setStartingX(SQUARE_HEIGH * 3);
        figure[0].setStartingY(SQUARE_HEIGH);
        figure[0].setStartingArrayX(1);
        figure[0].setStartingArrayY(-1);

        figure[2].setStartingX(SQUARE_HEIGH * 3);
        figure[2].setStartingY(SQUARE_HEIGH * 3);
        figure[2].setStartingArrayX(1);
        figure[2].setStartingArrayY(1);

        figure[3].setStartingX(SQUARE_HEIGH * 2);
        figure[3].setStartingY(SQUARE_HEIGH * 3);
        figure[3].setStartingArrayX(0);
        figure[3].setStartingArrayY(1);

        checkCollision(0);

    }
    private void positionBlock3(){
        figure[0].setStartingX(SQUARE_HEIGH*4);
        figure[0].setStartingY(SQUARE_HEIGH*2);
        figure[0].setStartingArrayX(2);
        figure[0].setStartingArrayY(0);

        figure[2].setStartingX(SQUARE_HEIGH*2);
        figure[2].setStartingY(SQUARE_HEIGH*2);
        figure[2].setStartingArrayX(0);
        figure[2].setStartingArrayY(0);


        figure[3].setStartingX(SQUARE_HEIGH*2);
        figure[3].setStartingY(SQUARE_HEIGH);
        figure[3].setStartingArrayX(0);
        figure[3].setStartingArrayY(-1);

        checkCollision(1);
    }
    private void positionBlock4(){

        figure[0].setStartingX(SQUARE_HEIGH*3);
        figure[0].setStartingY(SQUARE_HEIGH*3);
        figure[0].setStartingArrayX(1);
        figure[0].setStartingArrayY(1);

        figure[2].setStartingX(SQUARE_HEIGH*3);
        figure[2].setStartingY(SQUARE_HEIGH);
        figure[2].setStartingArrayX(1);
        figure[2].setStartingArrayY(-1);

        figure[3].setStartingX(SQUARE_HEIGH*4);
        figure[3].setStartingY(SQUARE_HEIGH);
        figure[3].setStartingArrayX(2);
        figure[3].setStartingArrayY(-1);

        checkCollision(2);

    }

    public void checkCollision(int position){
        if (checkRotateCollision()){
            this.position=position;
            rotate();
        }

    }
    public boolean checkRotateCollision() {
        for (Square square : figure) {
            if (gameboard[square.getStartingArrayX() + right][square.getStartingArrayY() + down] != null) {
                return true;
            }
        }

        return false;
    }

    public void initMovingObjects() {
        movingUpObjects=new ArrayList<>();
        movingDownObjects =new ArrayList<>();
        movingLeftObjects = new ArrayList<>();
        movingRightObjects =new ArrayList<>();
        movingUpObjects.add(figure[0]);
        movingUpObjects.add(figure[1]);
        movingUpObjects.add(figure[2]);
        movingDownObjects.add(figure[0]);
        movingDownObjects.add(figure[1]);
        movingDownObjects.add(figure[3]);
        movingLeftObjects.add(figure[0]);
        movingLeftObjects.add(figure[3]);
        movingRightObjects.add(figure[2]);
        movingRightObjects.add(figure[3]);

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
