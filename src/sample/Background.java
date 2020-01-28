package sample;

import javafx.scene.layout.Pane;
import shape.Square;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Background extends Pane {
    private final int STARTING_X=25;
    private final int STARTING_Y=25;
    private final int BOARD_HEIGH=550;
    private final int BOARD_WIDHT=300;
    private int minX=0, minY=0;
    private int maxX=(int)(BOARD_WIDHT/ Square.HEIGHT);
    private int maxY=(int)(BOARD_HEIGH/ Square.HEIGHT);
    private Square shape;
    private Scene scene;
    private Square[][] board=new Square[(int)(BOARD_HEIGH/ Square.HEIGHT)][(int)(BOARD_WIDHT/ Square.HEIGHT)];
     private Group group=new Group();

    public Background() {
        createEdges();
        fillTheBoard();
    }

    private void createEdges(){
    for (int i=minX;i<board.length;i++){
        //Adding LeftWall
        board[i][minX]=new Square(Color.GRAY);
        board[i][minX].getRectangle().setY(STARTING_Y+(Square.HEIGHT*i));
        board[i][minX].getRectangle().setX(STARTING_X);
        group.getChildren().add(board[i][0].getRectangle());
        //Adding RightWall
        board[i][maxX-1]=new Square(Color.GRAY);
        board[i][maxX-1].getRectangle().setY(STARTING_Y+(Square.HEIGHT*i));
        board[i][maxX-1].getRectangle().setX(STARTING_X*board[i].length);
        group.getChildren().add(board[i][maxX-1].getRectangle());
    }
    for (int i=minY;i<board[0].length-2;i++){
        //Adding Top Wall
        board[minY][i]=new Square(Color.GRAY);
        board[minY][i].getRectangle().setY(STARTING_Y);
        board[minY][i].getRectangle().setX(STARTING_X+(Square.HEIGHT*i)+ Square.HEIGHT);
        group.getChildren().add(board[0][i].getRectangle());
        //Adding Bottom Wall
        board[maxY-1][i]=new Square(Color.GRAY);
        board[maxY-1][i].getRectangle().setY((STARTING_Y*board.length));
        board[maxY-1][i].getRectangle().setX(STARTING_X+(Square.HEIGHT*i)+ Square.HEIGHT);
        group.getChildren().add(board[maxY-1][i].getRectangle());
    }

}
    public void fillTheBoard(){
        for (int i=minY+1;i<maxY-1;i++){
            for (int j=minX+1;j<maxX-1;j++){
                board[i][j]=new Square(Color.BLACK);
                board[i][j].getRectangle().setStroke(Color.LIGHTGRAY);
                board[i][j].getRectangle().setArcWidth(0);
                board[i][j].getRectangle().setArcHeight(0);
                board[i][j].getRectangle().setY(minY+(Square.HEIGHT*i)+ Square.HEIGHT);
                board[i][j].getRectangle().setX(minX+(Square.HEIGHT*j)+ Square.HEIGHT);
                group.getChildren().add(board[i][j].getRectangle());



            }
        }
    }

    public Group getGroup() {
        return group;
    }
}
