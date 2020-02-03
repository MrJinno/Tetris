package sample.UserInteraction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RankingManager {
    private static final String RANKING_FILENAME = "ranking.bin";
    private List<Player> ranking;

    public RankingManager() {
        ranking=new ArrayList<>();
        loadRanking();
    }




    @SuppressWarnings("unchecked")
    private void loadRanking(){
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(RANKING_FILENAME));
            ranking = (List<Player>) ois.readObject();
            ois.close();
            System.out.println(ranking);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void saveRanking(){
        try {
            FileOutputStream fos= new FileOutputStream(RANKING_FILENAME);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(ranking);
            oos.flush();
            oos.close();
        } catch (Exception e) {
        }
    }

    public List<Player> getPlayers() {
        return ranking;
    }

    public void saveScore(Player player){
        ranking.add(player);
        saveRanking();
    }





}
