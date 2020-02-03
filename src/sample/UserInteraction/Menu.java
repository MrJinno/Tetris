package sample.UserInteraction;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu  {
    private Button buttonPlay=addButton();
    private Button buttonExit=addButton();
    private Button buttonScore=addButton();
    private RankingManager rankingManager;
   private Stage stage;

    public Menu(Stage stage, RankingManager rankingManager) {
        this.rankingManager=rankingManager;

        this.stage=stage;
        stage.setTitle("MENU");
        stage.setWidth(200);
        stage.setHeight(300);
        stage.setX(850);
        stage.setY(400);
        Pane pane=new Pane(buttonPlay, buttonExit, buttonScore);
        manageButtons();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

   public Button getButtonPlay() {
        return buttonPlay;
    }

    private void manageButtons(){
        buttonPlay.setText("Play");
        buttonPlay.setLayoutX(40);
        buttonPlay.setLayoutY(10);

        buttonScore.setText("Score");
        buttonScore.setLayoutX(40);
        buttonScore.setLayoutY(90);
        buttonScore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showScoresWindow();
            }
        });

        buttonExit.setText("Exit");
        buttonExit.setLayoutX(40);
        buttonExit.setLayoutY(180);
        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

    }
    private Button addButton(){
        Button button=new Button();
        button.setPrefSize(100, 50);
        return button;
    }
    public void showScoresWindow(){
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
