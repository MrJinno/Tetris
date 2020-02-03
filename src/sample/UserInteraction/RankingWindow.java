package sample.UserInteraction;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RankingWindow {
    public RankingWindow(Stage stage, RankingManager rankingManager) {
        VBox vBox=new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(25));
        Scene scene=new Scene(vBox);
        ListView<Player> playerListView=new ListView<>();
        playerListView.getItems().addAll(rankingManager.getPlayers());
        rankingManager.sortPlayerScores();
        vBox.getChildren().add(playerListView);
        stage.setWidth(300);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.setTitle("Scores: ");
        stage.setResizable(false);
    }
}
