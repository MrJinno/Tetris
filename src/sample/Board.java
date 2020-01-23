package sample;

import Shape.Shape;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board {
    private final int STARTING_X=25;
    private final int STARTING_Y=25;
    private final int BOARD_HEIGH=550;
    private final int BOARD_WIDHT=300;
    private int minX=0, minY=0;
    private int maxX=(int)(BOARD_WIDHT/Shape.HEIGHT);
    private int maxY=(int)(BOARD_HEIGH/Shape.HEIGHT);
    private Shape shape;
    private Scene scene;
    private Shape[][] board=new Shape[(int)(BOARD_HEIGH/Shape.HEIGHT)][(int)(BOARD_WIDHT/Shape.HEIGHT)];
    Group group=new Group();

    public Board() {
        createEdges();
        fillTheBoard();
    }

    private void createEdges(){
    for (int i=minX;i<board.length;i++){
        //Adding LeftWall
        board[i][minX]=new Shape();
        board[i][minX].getRectangle().setFill(Color.GRAY);
        board[i][minX].getRectangle().setStroke(Color.BLACK);
        board[i][minX].getRectangle().setY(STARTING_Y+(Shape.HEIGHT*i));
        board[i][minX].getRectangle().setX(STARTING_X);
        group.getChildren().add(board[i][0].getRectangle());
        //Adding RightWall
        board[i][maxX-1]=new Shape();
        board[i][maxX-1].getRectangle().setFill(Color.GRAY);
        board[i][maxX-1].getRectangle().setStroke(Color.BLACK);
        board[i][maxX-1].getRectangle().setY(STARTING_Y+(Shape.HEIGHT*i));
        board[i][maxX-1].getRectangle().setX(STARTING_X*board[i].length);
        group.getChildren().add(board[i][maxX-1].getRectangle());
    }
    for (int i=minY;i<board[0].length-2;i++){
        //Adding Top Wall
        board[minY][i]=new Shape();
        board[minY][i].getRectangle().setFill(Color.GRAY);
        board[minY][i].getRectangle().setStroke(Color.BLACK);
        board[minY][i].getRectangle().setY(STARTING_Y);
        board[minY][i].getRectangle().setX(STARTING_X+(Shape.HEIGHT*i)+ Shape.HEIGHT);
        group.getChildren().add(board[0][i].getRectangle());
        //Adding Bottom Wall
        board[maxY-1][i]=new Shape();
        board[maxY-1][i].getRectangle().setFill(Color.GRAY);
        board[maxY-1][i].getRectangle().setStroke(Color.BLACK);
        board[maxY-1][i].getRectangle().setY((STARTING_Y*board.length));
        board[maxY-1][i].getRectangle().setX(STARTING_X+(Shape.HEIGHT*i)+ Shape.HEIGHT);
        group.getChildren().add(board[maxY-1][i].getRectangle());
    }

}
    public void fillTheBoard(){
        for (int i=minY+1;i<maxY-1;i++){
            for (int j=minX+1;j<maxX-1;j++){
                board[i][j]=new Shape();
                board[i][j].getRectangle().setFill(Color.BLACK);
                board[i][j].getRectangle().setStroke(Color.LIGHTGRAY);
                board[i][j].getRectangle().setY(minY+(Shape.HEIGHT*i)+Shape.HEIGHT);
                board[i][j].getRectangle().setX(minX+(Shape.HEIGHT*j)+Shape.HEIGHT);
                group.getChildren().add(board[i][j].getRectangle());



            }
        }
    }

    public Group getGroup() {
        return group;
    }
}
