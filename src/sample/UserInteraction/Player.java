package sample.UserInteraction;

import sample.ScoreBoard;

import java.io.Serializable;

public class Player implements Serializable {
    private int score= ScoreBoard.getInstance().getScore();
    private String imie;

    public Player(String imie) {
        this.imie = imie;
    }




    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", imie='" + imie + '\'' +
                '}';
    }
}
