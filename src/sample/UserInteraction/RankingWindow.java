package sample.UserInteraction;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Scanner;

public class RankingWindow {
    private Scene scene;
    private TextField textField=addTextField();
    public RankingWindow(Stage stage) {
    stage.setTitle("MENU");
        stage.setWidth(400);
        stage.setHeight(200);
        stage.setX(850);
        stage.setY(400);
        Pane pane=new Pane(textField);
        scene=new Scene(pane);
        stage.setScene(scene);

}
    public TextField addTextField(){
        TextField textField=new TextField();
        textField.setLayoutY(50);
        textField.setLayoutX(50);
        return textField;
    }

    public Scene getScene() {
        return scene;
    }

    public String getName(){
        return textField.toString();
    }

}
