package sample;

import javafx.scene.layout.Pane;
import shape.Square;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Background extends Pane {
    public static final int SQUARE_HEIGH=25;
    private static final int BOARD_HEIGH=550;
    private static final int BOARD_WIDHT=300;
    private static final int minX=0, minY=0;
    private static final int maxX=(BOARD_WIDHT/ SQUARE_HEIGH);
    private static final int maxY=(BOARD_HEIGH/ SQUARE_HEIGH);
    private static final int MAX_BOARD_ARRAY=25;
    private Square[][] background = new Square[MAX_BOARD_ARRAY][MAX_BOARD_ARRAY];
    private Square[][] board=new Square[(BOARD_HEIGH/ SQUARE_HEIGH)][(BOARD_WIDHT/ SQUARE_HEIGH)];
    public static final int Y_GAMEBOARD_SIZE=BOARD_HEIGH/SQUARE_HEIGH-2;
    public static final int X_GAMEBOARD_SIZE=BOARD_WIDHT/SQUARE_HEIGH-2;
    private Group group=new Group();
    public static final int NEXT_BLOCK_BOARD_MIN_Y =7;
    public static final int NEXT_BLOCK_BOARD_MIN_X =maxX;
    private static final int NEXT_BOARD_MAX_Y=12;

    public Background() {
        createBackGround();
        //createEdges();
        fillTheBoard();
        scoreBoard();
        nextBlockBoard();

    }

   /* private void createEdges(){
    for (int i=minX;i<board.length;i++){
        //Adding LeftWall
        board[i][minX]=new Square(Color.GRAY);
        board[i][minX].getRectangle().setY(STARTING_Y+(SQUARE_HEIGH*i));
        board[i][minX].getRectangle().setX(STARTING_X);
        group.getChildren().add(board[i][0].getRectangle());
        //Adding RightWall
        board[i][maxX-1]=new Square(Color.GRAY);
        board[i][maxX-1].getRectangle().setY(STARTING_Y+(SQUARE_HEIGH*i));
        board[i][maxX-1].getRectangle().setX(STARTING_X*board[i].length);
        group.getChildren().add(board[i][maxX-1].getRectangle());
    }
    for (int j=0;j<2;j++) {
        for (int i = minY; i < board[0].length - 2; i++) {
            //Adding Top Wall
            board[minY][i] = new Square(Color.GRAY);
            board[minY][i].getRectangle().setY(STARTING_Y-SQUARE_HEIGH*j);
            board[minY][i].getRectangle().setX(STARTING_X + (SQUARE_HEIGH * i));
            group.getChildren().add(board[0][i].getRectangle());

            //Adding Bottom Wall
            board[maxY - 1][i] = new Square(Color.GRAY);
            board[maxY - 1][i].getRectangle().setY(STARTING_Y * board.length+SQUARE_HEIGH*j);
            board[maxY - 1][i].getRectangle().setX(STARTING_X + (SQUARE_HEIGH * i));
            group.getChildren().add(board[maxY - 1][i].getRectangle());
        }
    }

}*/

    public void createBackGround(){
        for (int i=0;i<25;i++){
            for (int j=0;j<24;j++){
                background[i][j]= new Square(Color.GRAY);
                background[i][j].getRectangle().setX(SQUARE_HEIGH*i);
                background[i][j].getRectangle().setY(SQUARE_HEIGH*j);
                group.getChildren().add(background[i][j].getRectangle());

            }
        }
    }
    public void fillTheBoard(){
        for (int i=minY+1;i<maxY-1;i++){
            for (int j=minX+1;j<maxX-1;j++){
                board[i][j]=new Square(Color.BLACK);
                board[i][j].getRectangle().setStroke(Color.LIGHTGRAY);
                board[i][j].getRectangle().setArcWidth(0);
                board[i][j].getRectangle().setArcHeight(0);
                board[i][j].getRectangle().setY(minY+(SQUARE_HEIGH*i)+ SQUARE_HEIGH);
                board[i][j].getRectangle().setX(minX+(SQUARE_HEIGH*j)+ SQUARE_HEIGH);
                group.getChildren().add(board[i][j].getRectangle());



            }
        }
    }
    public void scoreBoard(){
        for (int i=minY+2;i<5;i++){
            for (int j=maxX;j<maxX+6;j++){
                background[i][j]=new Square(Color.BLACK);
                background[i][j].getRectangle().setStroke(Color.LIGHTGRAY);
                background[i][j].getRectangle().setArcWidth(0);
                background[i][j].getRectangle().setArcHeight(0);
                background[i][j].getRectangle().setY(minY+(SQUARE_HEIGH*i)+ SQUARE_HEIGH);
                background[i][j].getRectangle().setX(minX+(SQUARE_HEIGH*j)+ SQUARE_HEIGH);
                group.getChildren().add(background[i][j].getRectangle());



            }
        }
    }
    public void nextBlockBoard(){
        for (int i = NEXT_BLOCK_BOARD_MIN_Y; i<NEXT_BOARD_MAX_Y; i++){
            for (int j = NEXT_BLOCK_BOARD_MIN_X; j<maxX+6; j++){
                background[i][j]=new Square(Color.BLACK);
                background[i][j].getRectangle().setStroke(Color.LIGHTGRAY);
                background[i][j].getRectangle().setArcWidth(0);
                background[i][j].getRectangle().setArcHeight(0);
                background[i][j].getRectangle().setY(minY+(SQUARE_HEIGH*i)+ SQUARE_HEIGH);
                background[i][j].getRectangle().setX(minX+(SQUARE_HEIGH*j)+ SQUARE_HEIGH);
                group.getChildren().add(background[i][j].getRectangle());



            }
        }
    }

    public Group getGroup() {
        return group;
    }
}
