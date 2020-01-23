package sample;

import Shape.Shape;
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
        stage.setScene(scene1);
        Shape shape = new Square_Shape();
        board.getGroup().getChildren().add(shape.getGroup());
        Game game=new Game(shape);

    }
}
