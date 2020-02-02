package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Menu  {
    private Button buttonPlay=addButton();
    private Button buttonExit=addButton();
        private Scene scene;

    Menu(Stage stage) {
        stage.setTitle("MENU");
        stage.setWidth(200);
        stage.setHeight(200);
        stage.setX(850);
        stage.setY(400);
        Pane pane=new Pane(buttonPlay, buttonExit);
        manageButtons();
        scene=new Scene(pane);
    }

    Button getButtonPlay() {
        return buttonPlay;
    }

    private void manageButtons(){
        buttonPlay.setLayoutX(40);
        buttonPlay.setLayoutY(10);
        buttonPlay.setText("Graj");

        buttonExit.setText("Wyjdź");
        buttonExit.setLayoutX(40);
        buttonExit.setLayoutY(90);
        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

    }

    public Scene getScene() {
        return scene;
    }

    private Button addButton(){
        Button button=new Button();
        button.setPrefSize(100, 50);
        return button;
    }


}
