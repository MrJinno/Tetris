package sample.UserInteraction;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankingManager {
    private static final String RANKING_FILENAME = "ranking.bin";
    private List<Player> ranking;

    public RankingManager() {
        ranking = new ArrayList<>();
        loadRanking();
    }

    @SuppressWarnings("unchecked")
    private void loadRanking() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RANKING_FILENAME));
            ranking = (List<Player>) ois.readObject();
            ois.close();
            System.out.println(ranking);
        } catch (Exception e) {
        }
    }

    private void saveRanking() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RANKING_FILENAME));
            oos.writeObject(ranking);
            oos.flush();
            oos.close();
        } catch (Exception e) {

        }
    }

    public List<Player> getPlayers() {
        Collections.sort(ranking);
        return ranking;
    }

    public void saveScore(Player player) {
        ranking.add(player);
        saveRanking();
    }
}
