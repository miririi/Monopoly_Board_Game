package org.example.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainMenu extends ViewManager {

    private AnchorPane startPane;
    public MainMenu(){
        super();
        startPane = new AnchorPane();
    }

    public void createLayout(){
        Label label = new Label("Welcome to Monopoly Boardgame!");
        Button start = new Button("Start Game");
        Button login = new Button("Login");

        label.setLayoutX(200);
        label.setLayoutY(200);
        startPane.getChildren().add(label);
    }
}
