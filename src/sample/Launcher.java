package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Launcher extends Application {

    public static void main(String[] args) {
        Application.launch(Launcher.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tetris!");
        stage.show();
        stage.setWidth(500);
        stage.setHeight(700);

        Pane mainRoot = new Pane();
        Scene scene = new Scene(mainRoot);
        Game game = new Game(mainRoot);
        stage.setScene(scene);


    }
}
