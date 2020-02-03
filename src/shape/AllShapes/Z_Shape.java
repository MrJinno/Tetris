package shape.AllShapes;

import shape.Shape;

import java.util.ArrayList;

public class Z_Shape extends Shape {

    public Z_Shape() {
        super();
    }

    protected void positionBlock1() {
        figure[0].setPositionX(0);
        figure[0].setPositionY(1);

        figure[1].setPositionX(1);
        figure[1].setPositionY(1);

        figure[2].setPositionX(1);
        figure[2].setPositionY(0);

        figure[3].setPositionX(2);
        figure[3].setPositionY(0);

        nextX = new int[]{0, 0, 1};
        nextY = new int[]{-1, 0, 1};
    }

    protected void positionBlock2() {
        figure[0].setPositionX(0);
        figure[0].setPositionY(-1);

        figure[1].setPositionX(0);
        figure[1].setPositionY(0);

        figure[3].setPositionX(1);
        figure[3].setPositionY(1);

        nextX = new int[]{2, 1, 0};
        nextY = new int[]{-1, 1, 0};
    }

    protected void positionBlock3() {

        figure[0].setPositionX(2);
        figure[0].setPositionY(-1);

        figure[1].setPositionX(1);
        figure[1].setPositionY(-1);

        figure[3].setPositionX(0);
        figure[3].setPositionY(0);

        nextX = new int[]{2, 2, 1};
        nextY = new int[]{1, 0, -1};
    }

    protected void positionBlock4() {
        figure[0].setPositionX(2);
        figure[0].setPositionY(1);

        figure[1].setPositionX(2);
        figure[1].setPositionY(0);

        figure[3].setPositionX(1);
        figure[3].setPositionY(-1);

        nextX = new int[]{0, 1, 2};
        nextY = new int[]{1, 1, 0};
    }

    public void initMovingObjects() {
        movingUpObjects = new ArrayList<>();
        movingDownObjects = new ArrayList<>();
        movingLeftObjects = new ArrayList<>();
        movingRightObjects = new ArrayList<>();
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
