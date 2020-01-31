package shape.AllShapes;

import javafx.scene.Group;
import shape.Shape;
import shape.ShapeType;
import shape.Shapes;

import java.util.ArrayList;

public class Square_Shape extends Shape implements Shapes {


    private ShapeType shapeType=ShapeType.SQUARE;
    public Square_Shape() {
        super();
    }

    public Group getGroup() {
        return bigSquare;
    }


    @Override
    protected void positionBlock1() {

        figure[0].setPositionXArray(0);
        figure[0].setPositionYArray(0);


        figure[1].setPositionXArray(1);
        figure[1].setPositionYArray(0);


        figure[2].setPositionXArray(0);
        figure[2].setPositionYArray(1);


        figure[3].setPositionXArray(1);
        figure[3].setPositionYArray(1);




    }




    public void initMovingObjects() {
        movingUpObjects=new ArrayList<>();
        movingDownObjects =new ArrayList<>();
        movingLeftObjects = new ArrayList<>();
        movingRightObjects =new ArrayList<>();
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
