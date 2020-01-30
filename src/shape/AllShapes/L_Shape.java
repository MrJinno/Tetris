package shape.AllShapes;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;
import shape.Shape;

import java.util.ArrayList;


public class L_Shape extends Shape {

    public L_Shape() {
        super();

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
    protected void positionBlock2() {
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
    protected void positionBlock3(){
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
    protected void positionBlock4(){

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


}
