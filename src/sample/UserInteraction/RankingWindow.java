package sample.UserInteraction;

import javafx.application.Platform;

import javafx.scene.control.TextInputDialog;


public class RankingWindow {
    private TextInputDialog textInput;
    private Player player=new Player();
    private RankingManager rankingManager;

    public RankingWindow(RankingManager rankingManager) {
        this.rankingManager = rankingManager;
    }

    public void addTextField(){
        Platform.runLater(()->{
            textInput=new TextInputDialog();
            textInput.setY(50);
            textInput.setX(50);
            textInput.setTitle("Game OVER");
            textInput.setHeaderText("You got: " + player.getScore() + "Points!");
            textInput.setContentText("Enter your name...");
            textInput.show();
            textInput.setOnHidden(e -> savePlayer());

        });
    }

   public void savePlayer(){
        String name=textInput.resultProperty().get();
       if (!name.isEmpty()){
           player.setName(name);
           rankingManager.saveScore(player);
       }
   }


}
