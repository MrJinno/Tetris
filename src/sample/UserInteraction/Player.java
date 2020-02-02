package sample.UserInteraction;

import sample.ScoreBoard;

import java.io.Serializable;

public class Player implements Serializable {
    private int score= ScoreBoard.getInstance().getScore();
    private String imie="Player";

    public int getScore() {
        return score;
    }

    public String getImie() {
        return imie;
    }

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", imie='" + imie + '\'' +
                '}';
    }
}
