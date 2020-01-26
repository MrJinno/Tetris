package sample;

import Shape.Shape;
import Shape.Square;

public class GameBoard {
    public static final int MAX_Y=20;
    public static final int MAX_X=10;
    private static final Square[][] plansza= new Square[MAX_X][MAX_Y];
    private static final GameBoard gameBoard =new GameBoard();
    private GameBoard() {

    }
    public static GameBoard getInstance(){
        return gameBoard;
    }

    public Square[][] getPlansza() {
        return plansza;
    }

    public void newPositionDown(Square[] squares, int x, int y){
        for (int i=squares.length-1;i>=0;i--){
            plansza[x+squares[i].getStartingArrayX()][y+squares[i].getStartingArrayY()]=squares[i];
            plansza[x+squares[i].getStartingArrayX()][y+squares[i].getStartingArrayY()-1]=null;
        }
    }
    public boolean isMovableDown(Shape shape){
        int down=shape.getDown();
        int right=shape.getRight();
        Square[] sqr=shape.movingDownObjects();
        down++;
        if (down+1==GameBoard.MAX_Y) return false;
        for (int i=0;i<sqr.length;i++){
            if (plansza[sqr[i].getStartingArrayX()+right][sqr[i].getStartingArrayY()+down]!=null) return false;
        }
        return true;
    }

}
