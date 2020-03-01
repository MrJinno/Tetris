package Game.UserInteraction;

import javafx.application.Platform;
import javafx.scene.control.TextInputDialog;

public class SaveScoreWindow {
    private TextInputDialog textInput;
    private Player player = new Player();
    private RankingManager rankingManager;

    public SaveScoreWindow(RankingManager rankingManager) {
        this.rankingManager = rankingManager;
        manageTextField();
    }

    private void manageTextField() {
        Platform.runLater(() -> {
            textInput = new TextInputDialog();
            textInput.setY(50);
            textInput.setX(50);
            textInput.setTitle("Game OVER");
            textInput.setHeaderText("You got: " + player.getScore() + "Points!");
            textInput.setContentText("Enter your name...");
        });
    }

    public void ShowSaveScoreWindow() {
        Platform.runLater(()->{
            textInput.show();
            textInput.setOnHidden(e -> savePlayer());
        });
    }

    private void savePlayer() {
        try {
            String name = textInput.resultProperty().get();
            player.setName(name);
            rankingManager.saveScore(player);
        }catch (NullPointerException e){
            System.out.println("You did not save your Score!");
        }
    }
}
