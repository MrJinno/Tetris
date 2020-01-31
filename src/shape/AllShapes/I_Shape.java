package shape.AllShapes;

import shape.Shape;

import java.util.ArrayList;

public class I_Shape extends Shape {
    public I_Shape() {
        super();
    }

    protected void positionBlock1(){

        figure[0].setPositionXArray(0);
        figure[0].setPositionYArray(0);


        figure[1].setPositionXArray(1);
        figure[1].setPositionYArray(0);


        figure[2].setPositionXArray(2);
        figure[2].setPositionYArray(0);


        figure[3].setPositionXArray(3);
        figure[3].setPositionYArray(0);

        checkCollision(3);

    }

    protected void positionBlock2() {
        if (checkBoardCollision(new int[] {2,2,2}, new int[]{-2, -1, 1})) {

            figure[0].setPositionXArray(2);
            figure[0].setPositionYArray(-2);


            figure[1].setPositionXArray(2);
            figure[1].setPositionYArray(-1);


            figure[3].setPositionXArray(2);
            figure[3].setPositionYArray(1);

            checkCollision(0);
        }

    }
    protected void positionBlock3(){
        if (checkBoardCollision(new int[] {1,3,4}, new int[]{0, 0, 0})) {

            figure[3].setPositionXArray(1);
            figure[3].setPositionYArray(0);


            figure[1].setPositionXArray(3);
            figure[1].setPositionYArray(0);


            figure[0].setPositionXArray(4);
            figure[0].setPositionYArray(0);

            checkCollision(1);
        }
    }
    protected void positionBlock4(){

        if (checkBoardCollision(new int[] {2,2,2}, new int[]{2, 1, -1})) {

            figure[0].setPositionXArray(2);
            figure[0].setPositionYArray(2);


            figure[1].setPositionXArray(2);
            figure[1].setPositionYArray(1);


            figure[3].setPositionXArray(2);
            figure[3].setPositionYArray(-1);

            checkCollision(2);
        }
    }
    public void initMovingObjects() {
        movingUpObjects=new ArrayList<>();
        movingDownObjects =new ArrayList<>();
        movingLeftObjects = new ArrayList<>();
        movingRightObjects =new ArrayList<>();
        movingUpObjects.add(figure[0]);
        movingUpObjects.add(figure[1]);
        movingUpObjects.add(figure[2]);
        movingUpObjects.add(figure[3]);
        movingDownObjects.add(figure[0]);
        movingDownObjects.add(figure[1]);
        movingDownObjects.add(figure[2]);
        movingDownObjects.add(figure[3]);
        movingLeftObjects.add(figure[0]);
        movingRightObjects.add(figure[3]);

    }
}
