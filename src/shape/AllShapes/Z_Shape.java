package shape.AllShapes;

import shape.Shape;

import java.util.ArrayList;

public class Z_Shape extends Shape {

    public Z_Shape() {
        super();

    }

    protected void positionBlock1(){
        figure[0].setStartingX(MIN_POSITION);
        figure[0].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[0].setPositionXArray(0);
        figure[0].setPositionYArray(1);

        figure[1].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[1].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[1].setPositionXArray(1);
        figure[1].setPositionYArray(1);

        figure[2].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[2].setStartingY(MIN_POSITION);
        figure[2].setPositionXArray(1);
        figure[2].setPositionYArray(0);

        figure[3].setStartingX(MIN_POSITION+SQUARE_HEIGH*2);
        figure[3].setStartingY(MIN_POSITION);
        figure[3].setPositionXArray(2);
        figure[3].setPositionYArray(0);

    }
    protected void positionBlock2(){
        figure[0].setStartingX(MIN_POSITION);
        figure[0].setStartingY(MIN_POSITION-SQUARE_HEIGH);
        figure[0].setPositionXArray(0);
        figure[0].setPositionYArray(-1);

        figure[1].setStartingX(MIN_POSITION);
        figure[1].setStartingY(MIN_POSITION);
        figure[1].setPositionXArray(0);
        figure[1].setPositionYArray(0);

        figure[3].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[3].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[3].setPositionXArray(1);
        figure[3].setPositionYArray(1);

    }
    protected void positionBlock3(){
        figure[0].setStartingX(MIN_POSITION+2*SQUARE_HEIGH);
        figure[0].setStartingY(MIN_POSITION-SQUARE_HEIGH);
        figure[0].setPositionXArray(2);
        figure[0].setPositionYArray(-1);

        figure[1].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[1].setStartingY(MIN_POSITION-SQUARE_HEIGH);
        figure[1].setPositionXArray(1);
        figure[1].setPositionYArray(-1);


        figure[3].setStartingX(MIN_POSITION);
        figure[3].setStartingY(MIN_POSITION);
        figure[3].setPositionXArray(0);
        figure[3].setPositionYArray(0);
    }
    protected void positionBlock4(){
        figure[0].setStartingX(MIN_POSITION+2*SQUARE_HEIGH);
        figure[0].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[0].setPositionXArray(2);
        figure[0].setPositionYArray(1);

        figure[1].setStartingX(MIN_POSITION+2*SQUARE_HEIGH);
        figure[1].setStartingY(MIN_POSITION);
        figure[1].setPositionXArray(2);
        figure[1].setPositionYArray(0);


        figure[3].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[3].setStartingY(MIN_POSITION-SQUARE_HEIGH);
        figure[3].setPositionXArray(1);
        figure[3].setPositionYArray(-1);
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



}
