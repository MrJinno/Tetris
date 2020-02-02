package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.io.File;
import java.nio.file.Paths;


public class Launcher extends Application {
    private Scene  scene2;
    private Menu menu;
    public static void main(String[] args) {
        Application.launch(Launcher.class, args);
    }
    @Override
    public void start(Stage stage) {
        stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            System.exit(0);
        });
        menu=new Menu(stage);
        stage.setScene(menu.getScene());
        menuEventHandler(stage);
        stage.show();

    }


    private void menuEventHandler(Stage stage){
        menu.getButtonPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setGameScene(stage);
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
        Pane mainRoot = new Pane();
        scene2 = new Scene(mainRoot);
        new Game(mainRoot, scene2);
        stage.setScene(scene2);
    }
}
