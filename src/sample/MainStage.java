package sample;

import Shape.Square;
import Shape.Square_Shape;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;



public class MainStage extends Application {
    private Scene scene1;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tetris!");
        stage.show();
        stage.setWidth(500);
        stage.setHeight(700);
        Board board=new Board();
        scene1=new Scene(board.getGroup());
        Square_Shape sqr=new Square_Shape();
        board.getGroup().getChildren().add(sqr.getBigSquare());
        stage.setScene(scene1);
        Game game=new Game(sqr);
    }
}
