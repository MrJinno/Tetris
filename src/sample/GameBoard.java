package sample;

import shape.Shape;
import shape.Square;

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


    //ogarnac!
    public void newPositionDown(Shape shape){
        for (Square square:shape.getFigure()){
            plansza[shape.getPositionX(square)][shape.getPositionY(square)]=square;
            System.out.println("X: " + shape.getPositionX(square) + " Y:" + shape.getPositionY(square));
        }

    }
    public boolean isMovableDown(Shape shape){
        int down=shape.getDown();
        int right=shape.getRight();
        Square[] sqr=shape.getMovingDownObjects();
        down++;
        if (down+1==GameBoard.MAX_Y) return false;
        for (int i=0;i<sqr.length;i++){
            if (plansza[sqr[i].getStartingArrayX()+right][sqr[i].getStartingArrayY()+down]!=null) {
                return false;
            }
        }
        return true;
    }

}
