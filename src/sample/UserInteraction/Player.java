package sample.UserInteraction;

import sample.ScoreBoard;

import java.io.Serializable;

public class Player implements Serializable, Comparable<Player> {
    private int score= ScoreBoard.getInstance().getScore();
    private String name;



    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Score: " + score;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.score,score);
    }
}
