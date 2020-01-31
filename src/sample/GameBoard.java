package sample;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import shape.AllShapes.Square_Shape;
import shape.Shape;
import shape.Square;

public class GameBoard {
    private static final int SQUARE_HEIGH=Background.SQUARE_HEIGH;
    public static final int MAX_Y=Background.Y_GAMEBOARD_SIZE;
    public static final int MAX_X=Background.X_GAMEBOARD_SIZE;
    private static final Square[][] board = new Square[MAX_X][MAX_Y];
    private static final GameBoard gameBoard =new GameBoard();
    private int row;
    private ScoreBoard scoreBoard=ScoreBoard.getInstance();
    private GameBoard() {
    }
    public static GameBoard getInstance(){
        return gameBoard;
    }

    public Square[][] getPlansza() {
        return board;
    }




    public void newPositionDown(Shape shape){
        for (Square square:shape.getFigure()){
            board[shape.getPositionX(square)][shape.getPositionY(square)]=square;
            System.out.println("X: " + shape.getPositionX(square) + " Y:" + shape.getPositionY(square));
        }

    }
    public void checkWinCondition(Pane root) {
        Group group=new Group();
        if (checkRows(GameBoard.MAX_Y-1)) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    group.getChildren().add(board[i][row].getRectangle());
                    board[i][row] = null;
                }
                moveBlocks();
                root.getChildren().remove(group);
                scoreBoard.setScore(scoreBoard.getScore()+100);
                checkWinCondition(root);
        }
    }

    private boolean checkRows(int n){
        if (n==1) return false;
        if (checkRow(n)) {
            row=n;
            return true;
        }
        else return checkRows(n-1);
    }
    private boolean checkRow(int n){
        for (int i = 0; i< board.length; i++){
            if (board[i][n]==null) return false;
        }
        return true;
    }
    private void moveBlocks() {
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                Square temp;
                if (board[j][i] != null) {
                    board[j][i].movebottom();
                    temp= board[j][i];
                    board[j][i]=null;
                    board[j][i+1]=temp;
                }
            }
        }

    }


}
