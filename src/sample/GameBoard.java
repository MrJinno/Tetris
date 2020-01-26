package sample;

import Shape.Shape;
import Shape.Square;

public class GameBoard {
    private static final Square[][] plansza= new Square[10][20];
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
        for (Square square: squares){
            plansza[x+square.getStartingArrayX()][y+square.getStartingArrayY()]=square;
        }
    }

}
