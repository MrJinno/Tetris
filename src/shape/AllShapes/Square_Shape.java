package shape.AllShapes;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;
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
        figure[0].setStartingX(MIN_POSITION);
        figure[0].setStartingY(MIN_POSITION);
        figure[0].setStartingArrayX(0);
        figure[0].setStartingArrayY(0);

        figure[1].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[1].setStartingY(MIN_POSITION);
        figure[1].setStartingArrayX(1);
        figure[1].setStartingArrayY(0);

        figure[2].setStartingX(MIN_POSITION);
        figure[2].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[2].setStartingArrayX(0);
        figure[2].setStartingArrayY(1);

          figure[3].setStartingX(MIN_POSITION+SQUARE_HEIGH);
        figure[3].setStartingY(MIN_POSITION+SQUARE_HEIGH);
        figure[3].setStartingArrayX(1);
        figure[3].setStartingArrayY(1);




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
