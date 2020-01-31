package sample;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


public class Launcher extends Application {

    public static void main(String[] args) {
        Application.launch(Launcher.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tetris!");
        stage.show();
        stage.setWidth(515);
        stage.setHeight(635);


        Pane mainRoot = new Pane();
        Scene scene = new Scene(mainRoot);
        Game game = new Game(mainRoot, scene);
        stage.setScene(scene);




    }





}
