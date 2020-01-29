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
    public void checkWinCondition(Pane root) {
        Group group=new Group();
        if (checkBottom()) {
               Platform.runLater(() -> {
                    for (int i = 0; i < plansza.length; i++) {
                        group.getChildren().add(plansza[i][MAX_Y - 1].getRectangle());
                        plansza[i][MAX_Y-1]=null;
                    }
                   moveBottom();
               });
               root.getChildren().remove(group);
            checkWinCondition(root);
        }
    }
    public void moveBottom() {
        for (int i = plansza[0].length - 1; i >= 0; i--) {
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
        public boolean checkBottom(){
            for (int i=0; i<plansza.length;i++){
                if (plansza[i][MAX_Y-1]==null) return false;
            }
            return true;
        }

}
