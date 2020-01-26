package Shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;


public class L_Shape extends Shape {
    private Square shape;
    private Square[]figure =new Square[4];
    private Color color=Color.BLUE;
    private Group bigSquare=new Group();
    private GameBoard gameBoard= GameBoard.getInstance();
    private Square[][] plansza=gameBoard.getPlansza();
    private int down,right;
    public L_Shape() {
        down=0;
        right=4;
        figure[0]=new Square(color, 50, 50,0,0);
        figure[0].getRectangle().setX(figure[0].getStartingX()+(25*right));
        figure[0].getRectangle().setY(figure[0].getStartingY()+(25*down));
        bigSquare.getChildren().add(figure[0].getRectangle());
        plansza[figure[0].getStartingArrayX()][figure[0].getStartingArrayY()]=figure[0];


        figure[1]=new Square(color, 75, 50,1,0);
        figure[1].getRectangle().setX(figure[1].getStartingX()+(25*right));
        figure[1].getRectangle().setY(figure[1].getStartingY()+(25*down));
        bigSquare.getChildren().add(figure[1].getRectangle());
        plansza[figure[1].getStartingArrayX()][figure[1].getStartingArrayY()]=figure[1];

        figure[2]=new Square(color,100,50,2,0);
        figure[2].getRectangle().setX(figure[2].getStartingX()+(25*right));
        figure[2].getRectangle().setY(figure[2].getStartingY()+(25*down));
        bigSquare.getChildren().add(figure[2].getRectangle());
        plansza[figure[2].getStartingArrayX()][figure[2].getStartingArrayY()]=figure[2];


        figure[3]=new Square(color, 100,75,2,1);
        figure[3].getRectangle().setX(figure[3].getStartingX()+(25*right));
        figure[3].getRectangle().setY(figure[3].getStartingY()+(25*down));
        bigSquare.getChildren().add(figure[3].getRectangle());
        plansza[figure[3].getStartingArrayX()][figure[3].getStartingArrayY()]=figure[3];
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
    public Square[] getMovingDownObjects(){
        Square[] sqr=new Square[3];
        sqr[0]=figure[0];
        sqr[1]=figure[1];
        sqr[2]=figure[3];
        return sqr;
    }
    public Square[] movingLeftObjects(){
        Square[] sqr=new Square[1];
        sqr[0]=figure[0];
        return sqr;
    }
    public Square[] movingRightObjects(){
        Square[] sqr=new Square[2];
        sqr[0]=figure[2];
        sqr[1]=figure[3];
        return sqr;
    }
}
