package sample;

import javafx.application.Application;
import javafx.application.Platform;
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
    public static void main(String[] args) {
        Application.launch(Launcher.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
            Music music= new Music("beat.mp3");

        stage.setTitle("Tetris!");
        stage.setWidth(515);
        stage.setHeight(635);
        stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event ->{
            System.exit(0);
        });
        Pane mainRoot = new Pane();
        Scene scene = new Scene(mainRoot);
        Game game = new Game(mainRoot, scene);
        stage.setScene(scene);
        stage.show();




    }






}
