package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.UserInteraction.Menu;
import sample.UserInteraction.Music;
import sample.UserInteraction.RankingManager;


public class Launcher extends Application {
    private Menu menu;
    private RankingManager rankingManager= new RankingManager();
    public static void main(String[] args) {
        Application.launch(Launcher.class, args);
    }
    @Override
    public void start(Stage stage) {
        stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            System.exit(0);
        });
        menu=new Menu(stage, rankingManager);
        stage.setScene(menu.getScene());
        menuEventHandler(stage);
        stage.show();

    }

    private void menuEventHandler(Stage stage){
        menu.getButtonPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.hide();
                setGameScene(stage);
                stage.show();
            }
        });
    }
    private void setGameScene(Stage stage){
        new Music("beat.mp3");
        stage.setWidth(515);
        stage.setHeight(635);
        stage.setTitle("Tetris!");
        stage.setX(600);
        stage.setY(200);
        stage.setResizable(false);
        Pane mainRoot = new Pane();
        Scene gameScene = new Scene(mainRoot);
        Game game = new Game(mainRoot, gameScene, rankingManager);
        stage.setScene(gameScene);
    }
}
