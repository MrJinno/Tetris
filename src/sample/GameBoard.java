package sample;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import shape.Shape;
import shape.Square;

public class GameBoard {
    public static final int MAX_Y=20;
    public static final int MAX_X=10;
    private static final Square[][] plansza= new Square[MAX_X][MAX_Y];
    private static final GameBoard gameBoard =new GameBoard();
    private int row;
    private GameBoard() {

    }
    public static GameBoard getInstance(){
        return gameBoard;
    }

    public Square[][] getPlansza() {
        return plansza;
    }



    public void newPositionDown(Shape shape){
        for (Square square:shape.getFigure()){
            plansza[shape.getPositionX(square)][shape.getPositionY(square)]=square;
            System.out.println("X: " + shape.getPositionX(square) + " Y:" + shape.getPositionY(square));
        }

    }
    public void checkWinCondition(Pane root) {
        Group group=new Group();
        if (checkRows(GameBoard.MAX_Y-1)) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    group.getChildren().add(plansza[i][row].getRectangle());
                    plansza[i][row] = null;
                }
                moveBlocks();
                root.getChildren().remove(group);
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
        for (int i=0; i<plansza.length;i++){
            if (plansza[i][n]==null) return false;
        }
        return true;
    }
    private void moveBlocks() {
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < plansza.length; j++) {
                Square temp;
                if (plansza[j][i] != null) {
                    plansza[j][i].movebottom();
                    temp=plansza[j][i];
                    plansza[j][i]=null;
                    plansza[j][i+1]=temp;
                }
            }
        }

    }

}
