package shape.AllShapes;

import shape.Shape;
import java.util.ArrayList;

public class _I_Shape extends Shape {

    public _I_Shape() {
        super();
    }

    protected void positionBlock1() {
        figure[0].setPositionX(0);
        figure[0].setPositionY(0);

        figure[1].setPositionX(1);
        figure[1].setPositionY(0);

        figure[2].setPositionX(2);
        figure[2].setPositionY(0);

        figure[3].setPositionX(1);
        figure[3].setPositionY(1);

        index_X_After_Rotation = new int[]{1, 1, 0};
        index_Y_After_Rotation = new int[]{-1, 1, 0};
    }

    protected void positionBlock2() {
        figure[0].setPositionX(1);
        figure[0].setPositionY(-1);

        figure[2].setPositionX(1);
        figure[2].setPositionY(1);

        figure[3].setPositionX(0);
        figure[3].setPositionY(0);

        index_X_After_Rotation = new int[]{2, 0, 1};
        index_Y_After_Rotation = new int[]{0, 0, -1};
    }

    protected void positionBlock3() {
        figure[0].setPositionX(2);
        figure[0].setPositionY(0);

        figure[2].setPositionX(0);
        figure[2].setPositionY(0);

        figure[3].setPositionX(1);
        figure[3].setPositionY(-1);

        index_X_After_Rotation = new int[]{1, 1, 2};
        index_Y_After_Rotation = new int[]{1, -1, 0};
    }

    protected void positionBlock4() {
        figure[0].setPositionX(1);
        figure[0].setPositionY(1);

        figure[2].setPositionX(1);
        figure[2].setPositionY(-1);

        figure[3].setPositionX(2);
        figure[3].setPositionY(0);

        index_X_After_Rotation = new int[]{0, 2, 1};
        index_Y_After_Rotation = new int[]{0, 0, 1};
    }

    public void initMovingObjects() {
        movingUpObjects = new ArrayList<>();
        movingDownObjects = new ArrayList<>();
        movingLeftObjects = new ArrayList<>();
        movingRightObjects = new ArrayList<>();
        movingUpObjects.add(figure[0]);
        movingUpObjects.add(figure[1]);
        movingUpObjects.add(figure[2]);
        movingDownObjects.add(figure[0]);
        movingDownObjects.add(figure[2]);
        movingDownObjects.add(figure[3]);
        movingLeftObjects.add(figure[0]);
        movingLeftObjects.add(figure[3]);
        movingRightObjects.add(figure[2]);
        movingRightObjects.add(figure[3]);
    }
}
