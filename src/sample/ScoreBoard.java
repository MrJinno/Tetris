package sample;


import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class ScoreBoard {
    private static final ScoreBoard scoreBoard=new ScoreBoard();
    private Text t=new Text();
    private int score=0;

    private ScoreBoard() {
        t.setText(Integer.toString(score));
        t.setX(Background.SQUARE_HEIGH*14);
        t.setY(Background.SQUARE_HEIGH*5);
        t.setFont(Font.font("Verdana", 33));
        t.setFill(Color.WHITE);
        t.setStroke(Color.GOLD);
    }
    static ScoreBoard getInstance(){
        return scoreBoard;
    }

    int getScore() {
        return score;
    }

    Text getT() {
        return t;
    }

    void setScore(int score) {
        this.score = score;
        t.setText(Integer.toString(score));
    }
    void setLost(){
        t.setY(Background.SQUARE_HEIGH*4);
        t.setText("LOST! \n" + score);
    }

}
