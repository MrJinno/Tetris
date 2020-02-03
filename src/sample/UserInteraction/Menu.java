package sample.UserInteraction;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu {
    private Button buttonPlay = createButton();
    private Button buttonExit = createButton();
    private Button buttonScore = createButton();
    private RankingManager rankingManager;
    private Stage stage;

    public Menu(Stage stage, RankingManager rankingManager) {
        this.rankingManager = rankingManager;

        this.stage = stage;
        stage.setTitle("MENU");
        stage.setWidth(200);
        stage.setHeight(300);
        stage.setX(850);
        stage.setY(400);
        stage.setResizable(false);
        Pane pane = new Pane(buttonPlay, buttonExit, buttonScore);
        manageButtons();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public Button getButtonPlay() {
        return buttonPlay;
    }

    private void manageButtons() {
        buttonPlay.setText("Play");
        buttonPlay.setLayoutX(40);
        buttonPlay.setLayoutY(10);

        buttonScore.setText("Score");
        buttonScore.setLayoutX(40);
        buttonScore.setLayoutY(90);
        buttonScore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new RankingWindow(rankingManager);
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

    private Button createButton() {
        Button button = new Button();
        button.setPrefSize(100, 50);
        return button;
    }
}
