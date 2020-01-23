package Shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Square_Shape extends Shape {
    private Square shape;
    private Square[][]figure =new Square[3][3];
    private Color color=Color.RED;
    Group bigSquare=new Group();


    public Group getBigSquare() {
        return bigSquare;
    }

    public Square_Shape() {
        figure[0][0]=new Square(Color.RED);
        figure[0][0].getRectangle().setX(100);
        figure[0][0].getRectangle().setY(100);
        bigSquare.getChildren().add(figure[0][0].getRectangle());

        figure[0][1]=new Square(Color.RED);
        figure[0][1].getRectangle().setX(100);
        figure[0][1].getRectangle().setY(125);
        bigSquare.getChildren().add(figure[0][1].getRectangle());

        figure[1][0]=new Square(Color.RED);
        figure[1][0].getRectangle().setX(125);
        figure[1][0].getRectangle().setY(100);
        bigSquare.getChildren().add(figure[1][0].getRectangle());

        figure[1][1]=new Square(Color.RED);
        figure[1][1].getRectangle().setX(125);
        figure[1][1].getRectangle().setY(125);
        bigSquare.getChildren().add(figure[1][1].getRectangle());

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveDown() {
      bigSquare.setLayoutY(bigSquare.getLayoutY()+25);

    }

    @Override
    public void rotate() {

    }
}
