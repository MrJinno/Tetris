package Shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.GameBoard;


public class L_Shape {
    private Square shape;
    private Square[]figure =new Square[4];
    private Color color=Color.BLUE;
    Group bigSquare=new Group();
    GameBoard gameBoard= GameBoard.getInstance();
    Square[][] plansza=gameBoard.getPlansza();
    private int down,right;
    public L_Shape() {
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
        figure[3].getRectangle().setY(figure[3].getStartingX()+(25*down));
        bigSquare.getChildren().add(figure[3].getRectangle());
        plansza[1][1]=figure[0];
    }
}
