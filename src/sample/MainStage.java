package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;



public class MainStage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tetris!");
        stage.show();
        stage.setWidth(300);
        stage.setHeight(700);
        Board board=new Board();
        Scene scene1=new Scene(board.getGroup());
        stage.setScene(scene1);
    }
}
