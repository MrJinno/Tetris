package shape.AllShapes;

import shape.Shape;
import shape.Shapes;
import java.util.ArrayList;

public class Square_Shape extends Shape implements Shapes {

    public Square_Shape() {
        super();
    }

    @Override
    protected void positionBlock1() {
        figure[0].setPositionX(0);
        figure[0].setPositionY(0);

        figure[1].setPositionX(1);
        figure[1].setPositionY(0);

        figure[2].setPositionX(0);
        figure[2].setPositionY(1);

        figure[3].setPositionX(1);
        figure[3].setPositionY(1);
    }

    public void initMovingObjects() {
        movingUpObjects = new ArrayList<>();
        movingDownObjects = new ArrayList<>();
        movingLeftObjects = new ArrayList<>();
        movingRightObjects = new ArrayList<>();
        movingUpObjects.add(figure[0]);
        movingUpObjects.add(figure[1]);
        movingDownObjects.add(figure[3]);
        movingDownObjects.add(figure[2]);
        movingLeftObjects.add(figure[0]);
        movingLeftObjects.add(figure[2]);
        movingRightObjects.add(figure[1]);
        movingRightObjects.add(figure[3]);

    }

    @Override
    protected void positionBlock4() {
    }

    @Override
    protected void positionBlock2() {
    }

    @Override
    protected void positionBlock3() {
    }

    @Override
    public void rotate() {
    }
}
