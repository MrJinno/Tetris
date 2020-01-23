package Shape;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import sample.Game;
import sample.GameBoard;

public class Square_Shape extends Shape implements Shapes {
    private Square shape;
    private Square[][]figure =new Square[3][3];
    private Color color=Color.RED;
    Group bigSquare=new Group();
    GameBoard gameBoard= GameBoard.getInstance();
    Square[][] plansza=gameBoard.getPlansza();

    public Group getGroup() {
        return bigSquare;
    }

    public Square_Shape() {
        figure[0][0]=new Square(Color.RED);
        figure[0][0].getRectangle().setX(150);
        figure[0][0].getRectangle().setY(50);
        bigSquare.getChildren().add(figure[0][0].getRectangle());
        plansza[4][0]=figure[0][0];

        figure[0][1]=new Square(Color.RED);
        figure[0][1].getRectangle().setX(150);
        figure[0][1].getRectangle().setY(75);
        bigSquare.getChildren().add(figure[0][1].getRectangle());
        plansza[4][1]=figure[0][1];

        figure[1][0]=new Square(Color.RED);
        figure[1][0].getRectangle().setX(175);
        figure[1][0].getRectangle().setY(50);
        bigSquare.getChildren().add(figure[1][0].getRectangle());
        plansza[5][0]=figure[1][0];


        figure[1][1]=new Square(Color.RED);
        figure[1][1].getRectangle().setX(175);
        figure[1][1].getRectangle().setY(75);
        bigSquare.getChildren().add(figure[1][1].getRectangle());
        plansza[5][1]=figure[1][1];
    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveDown() {
        int licznik=0;
      bigSquare.setLayoutY(bigSquare.getLayoutY()+25);
      for (int i=0;i<plansza.length;i++){
          for (int j=0;i<plansza.length;i++){
              if (plansza[i][j]!=null){
                  plansza[i][j+1]=new Square(Color.RED,plansza[i][j]);
                  plansza[i][j]=null;
                  licznik++;
                if (licznik==4) break;
              }
            if (licznik==4) break;
          }
      }

    }

    @Override
    public void rotate() {

    }
    @Override
    public void removeBottom(){
        bigSquare.getChildren().removeAll(figure[1][1].getRectangle(),figure[0][1].getRectangle());
    }
    @Override
    public boolean isStuck(){
    for (int i=0;i<figure[i].length;i++){
        for (int j=0;j<figure.length;j++){
        }
    }
    return true;
    }
}
