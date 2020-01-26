package Shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.Game;
import sample.GameBoard;

public class Square_Shape extends Shape implements Shapes {
    private Square shape;
    private Square[]figure =new Square[4];
    private Color color=Color.RED;
    Group bigSquare=new Group();
    GameBoard gameBoard= GameBoard.getInstance();
    Square[][] plansza=gameBoard.getPlansza();
    private int down,right;
    private ShapeType shapeType=ShapeType.l_SHAPE;

    public Square_Shape() {
        down=0;
        right=4;
        figure[0]=new Square(Color.RED, 50, 50,0,0);
        figure[0].getRectangle().setX(figure[0].getStartingX()+(25*right));
        figure[0].getRectangle().setY(figure[0].getStartingY()+(25*down));
        bigSquare.getChildren().add(figure[0].getRectangle());
        plansza[0][0]=figure[0];


        figure[1]=new Square(Color.RED, 75, 50,1,0);
        figure[1].getRectangle().setX(figure[1].getStartingX()+(25*right));
        figure[1].getRectangle().setY(figure[1].getStartingY()+(25*down));
        bigSquare.getChildren().add(figure[1].getRectangle());
        plansza[1][0]=figure[1];

        figure[2]=new Square(Color.RED,50,75,0,1);
        figure[2].getRectangle().setX(figure[2].getStartingX()+(25*right));
        figure[2].getRectangle().setY(figure[2].getStartingY()+(25*down));
        bigSquare.getChildren().add(figure[2].getRectangle());
        plansza[0][1]=figure[2];


        figure[3]=new Square(Color.RED, 75,75,1,1);
        figure[3].getRectangle().setX(figure[3].getStartingX()+(25*right));
        figure[3].getRectangle().setY(figure[3].getStartingY()+(25*down));
        bigSquare.getChildren().add(figure[3].getRectangle());
        plansza[1][1]=figure[3];
    }

    public Group getGroup() {
        return bigSquare;
    }

    @Override
    public void moveLeft() {
        right--;
        setPosition(right,down);
    }
    public void setPosition(int right, int down){
        for (Square square:figure){
            square.getRectangle().setX(square.getStartingX()+(25*right));
            square.getRectangle().setY(square.getStartingY()+(25*down));
        }
    }
    @Override
    public void moveRight() {
        right++;
        setPosition(right,down);

    }
    public Square[] movingDownObjects(){
        Square[] sqr=new Square[2];
        sqr[0]=figure[2];
        sqr[1]=figure[3];
        return sqr;
    }
    public Square[] movingLeftObjects(){
        Square[] sqr=new Square[2];
        sqr[0]=figure[0];
        sqr[1]=figure[2];
        return sqr;
    }
    public Square[] movingRightObjects(){
        Square[] sqr=new Square[2];
        sqr[0]=figure[1];
        sqr[1]=figure[3];
        return sqr;
    }

    @Override
    public void moveDown() {
        down++;
        setPosition(right, down);
        gameBoard.newPositionDown(figure, right, down);
        }


    @Override
    public void rotate() {

    }
    @Override
    public void removeBottom(){
    }
    @Override
    public boolean isStuck(){
    return true;
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
}
