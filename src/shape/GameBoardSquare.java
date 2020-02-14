package shape;

import javafx.scene.paint.Color;

public class GameBoardSquare extends Square {

    public GameBoardSquare() {
        super(Color.BLACK);
        getRectangle().setStroke(Color.LIGHTGRAY);
        getRectangle().setArcWidth(0);
        getRectangle().setArcHeight(0);
    }
}
