package org.example.view;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ViewManager {
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private double screen_height;

    public ViewManager() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, 800, 600);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButton();
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        mainStage.setX(primaryScreenBounds.getMinX());
        mainStage.setY(primaryScreenBounds.getMinY());
        mainStage.setWidth(primaryScreenBounds.getWidth());
        mainStage.setHeight(primaryScreenBounds.getHeight());
        screen_height = primaryScreenBounds.getMaxY() - primaryScreenBounds.getMinY();
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void setButtonPressedStyle(Button button, String style){  //Pressed Button is smaller
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
    }
    private void createButton() {
        double y_axis = 0.0;
        String [] buttons = {"collect_200", "MR_avenue", "community_chest", "baltic_avenue", "income_tax", "reading_railroad", "oriental_avenue", "chance", "vermont_avenue", "connecticut_avenue", "just_visiting" };
        for (String monopoly_button: buttons){
            Button style_button = new Button();
            style_button.setPrefHeight(120.5);
            style_button.setPrefWidth(180);
            style_button.setStyle("-fx-background-color: transparent; -fx-background-image: url('"+ monopoly_button + ".png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat");
            mainPane.getChildren().add(style_button);
            mainPane.setBottomAnchor(style_button, y_axis);
            y_axis += 122.0;
            initializeButtonListeners(monopoly_button, style_button);
        }


    }

}
