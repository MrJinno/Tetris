package shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;

import java.util.ArrayList;

public class Square_Shape extends Shape implements Shapes {
     private static final int SQUARE_HEIGH=Square.getHEIGHT();
    private Square shape;
    private Square[]figure =new Square[4];
    private Color color=Shape.randomizeColor();
    Group bigSquare=new Group();
    GameBoard gameBoard= GameBoard.getInstance();
    private int down=0;
    private int right=4;
    private int width=2;
    private ArrayList<Square> movingDownObject, movingLeftObject, movingRightObject;

    private ShapeType shapeType=ShapeType.SQUARE;
    public Square_Shape() {
        figure[0]=new Square(color, SQUARE_HEIGH*2, SQUARE_HEIGH*2,0,0);
        figure[0].getRectangle().setX(figure[0].getStartingX()+(SQUARE_HEIGH*right));
        figure[0].getRectangle().setY(figure[0].getStartingY()+(SQUARE_HEIGH*down));
        bigSquare.getChildren().add(figure[0].getRectangle());

        figure[1]=new Square(color, SQUARE_HEIGH*3, SQUARE_HEIGH*2,1,0);
        figure[1].getRectangle().setX(figure[1].getStartingX()+(SQUARE_HEIGH*right));
        figure[1].getRectangle().setY(figure[1].getStartingY()+(SQUARE_HEIGH*down));
        bigSquare.getChildren().add(figure[1].getRectangle());

        figure[2]=new Square(color,SQUARE_HEIGH*2,SQUARE_HEIGH*3,0,1);
        figure[2].getRectangle().setX(figure[2].getStartingX()+(SQUARE_HEIGH*right));
        figure[2].getRectangle().setY(figure[2].getStartingY()+(SQUARE_HEIGH*down));
        bigSquare.getChildren().add(figure[2].getRectangle());


        figure[3]=new Square(color, SQUARE_HEIGH*3,SQUARE_HEIGH*3,1,1);
        figure[3].getRectangle().setX(figure[3].getStartingX()+(SQUARE_HEIGH*right));
        figure[3].getRectangle().setY(figure[3].getStartingY()+(SQUARE_HEIGH*down));
        bigSquare.getChildren().add(figure[3].getRectangle());
    }

    public Group getGroup() {
        return bigSquare;
    }

    @Override
    protected void initMovingObjects() {

    }

    @Override
    protected void positionBlock1() {
        figure[0].getRectangle().setX(figure[0].getStartingX()+(SQUARE_HEIGH*right));
        figure[0].getRectangle().setY(figure[0].getStartingY()+(SQUARE_HEIGH*down));

        figure[1].getRectangle().setX(figure[1].getStartingX()+(SQUARE_HEIGH*right));
        figure[1].getRectangle().setY(figure[1].getStartingY()+(SQUARE_HEIGH*down));

        figure[2].getRectangle().setX(figure[2].getStartingX()+(SQUARE_HEIGH*right));
        figure[2].getRectangle().setY(figure[2].getStartingY()+(SQUARE_HEIGH*down));

        figure[3].getRectangle().setX(figure[3].getStartingX()+(SQUARE_HEIGH*right));
        figure[3].getRectangle().setY(figure[3].getStartingY()+(SQUARE_HEIGH*down));


    }

    @Override
    public void moveLeft() {
       if (Shape.isMovableLeftRight(this, right-1, getMovingLeftObjects())) {
           right--;
           setPosition();
       }
    }

    public void setPosition(){
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
    public ArrayList<Square> getMovingDownObjects(){
        movingDownObject=new ArrayList<>();
        movingDownObject.add(figure[2]);
        movingDownObject.add(figure[3]);
        return movingDownObject;
    }


    @Override
    public void setDown(int down) {
        this.down = down;
    }

    public ArrayList<Square> getMovingLeftObjects(){
        movingLeftObject=new ArrayList<>();
       movingLeftObject.add(figure[0]);
       movingLeftObject.add(figure[2]);

        return movingLeftObject;
    }

    public ArrayList<Square> getMovingRightObjects(){
        movingRightObject=new ArrayList<>();
        movingRightObject.add(figure[1]);
        movingRightObject.add(figure[3]);
        return movingRightObject;
    }
    @Override
    public void moveDown() {
        if (isMovableDown(this)) {
            down++;
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
    public void rotate() {

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

    public void setRight(int right) {
        this.right = right;
    }

    public int getWidth() {
        return width;
    }
}
