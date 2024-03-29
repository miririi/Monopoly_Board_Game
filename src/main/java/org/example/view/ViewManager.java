package org.example.view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.model.SpaceRunnerButton;

public class ViewManager {
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public ViewManager() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, 800, 600);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButton();
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void createButton() {
        /**Button button = new Button();
        button.setLayoutX(100);
        button.setLayoutY(100);
        mainPane.getChildren().add(button);
        button.setOnMouseEntered(new EventHandler<Event>(){
            @Override
            public void handle(Event event) {
                System.out.println("mouse entered");
            }
        });**/
        SpaceRunnerButton button = new SpaceRunnerButton("FREE PARKING");
        mainPane.getChildren().add(button);
        //Test test test



    }

}
