package org.example.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewManager{

    protected Scene mainScene;
    protected Stage mainStage;

    public Stage getMainStage() {
        return mainStage;
    }

    public void setScene(AnchorPane pane){
        mainScene = new Scene(pane, 800, 800);
    }

    public void setStage(Stage stage){
        mainStage = stage;
        mainStage.setScene(mainScene);
    }

    /**private void setButtonPressedStyle(Button button, String style){  //Pressed Button is smaller
        button.setStyle("-fx-background-color: transparent; -fx-background-image: url('"+ style + ".png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat");
        button.setPrefHeight(145);
        button.setLayoutY(button.getLayoutY()+4);

    }

    private void setButtonReleasedStyle(Button button, String style){
        button.setStyle(style);
        button.setPrefHeight(45);
        button.setLayoutY(button.getLayoutY()-4);

    }

    private void initializeButtonListeners(String string, Button button){
        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle(button, string);
                }
            }
        });

        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mainPane.setEffect(new DropShadow());
                ;            }
        });
    }**/




}
