package sample;

import Shape.Shape;
import Shape.Square_Shape;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Shape.*;

import java.util.ArrayList;


public class MainStage extends Application {
    private Scene scene1;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tetris!");
        stage.show();
        stage.setWidth(500);
        stage.setHeight(700);
        Background board=new Background();
        scene1=new Scene(board.getGroup());
        stage.setScene(scene1);


        Game game=new Game( board.getGroup());


    }
}
