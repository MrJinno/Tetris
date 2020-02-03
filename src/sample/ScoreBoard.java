package sample;


import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScoreBoard {
    private static final ScoreBoard scoreBoard = new ScoreBoard();
    private Text text = new Text();
    private int score = 0;

    private ScoreBoard() {
        text.setText(Integer.toString(score));
        text.setX(Background.SQUARE_HEIGH * 14);
        text.setY(Background.SQUARE_HEIGH * 5);
        text.setFont(Font.font("Verdana", 33));
        text.setFill(Color.WHITE);
        text.setStroke(Color.GOLD);
    }

    public static ScoreBoard getInstance() {
        return scoreBoard;
    }

    public int getScore() {
        return score;
    }

    Text getText() {
        return text;
    }

    void setScore(int score) {
        this.score = score;
        text.setText(Integer.toString(score));
    }

    void setLost() {
        text.setY(Background.SQUARE_HEIGH * 4);
        text.setText("LOST! \n" + score);
    }

}
