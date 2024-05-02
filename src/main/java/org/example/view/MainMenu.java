package org.example.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainMenu extends ViewManager {

    public AnchorPane startPane;
    private GameScene gameScene;
    public MainMenu(){
        super();
        startPane = new AnchorPane();
    }

    public void createLayout() {
        Label label = new Label("Welcome to Monopoly Boardgame!");
        Button start = new Button("Start Game");
        Button login = new Button("Login");
        label.setMinSize(200, 200);

        start.setMinSize(100, 100);
        login.setMinSize(100, 100);
        start.setLayoutX(200);
        start.setLayoutY(200);
        login.setLayoutY(200);
        login.setLayoutX(400);

        label.setFont(Font.font("Verdana",23));
        startPane.getChildren().add(label);
        startPane.getChildren().add(start);
        startPane.getChildren().add(login);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameScene gameScene = new GameScene();
                gameScene.create_gameboard();
                gameScene.setScene(gameScene.gamePane);
                gameScene.setStage(new Stage());
                gameScene.createSubScenes();
                gameScene.initialize_character("dog.png");
                gameScene.roll();
                Stage stage = gameScene.getMainStage();
                stage.show();
            }
        });
    }
}
