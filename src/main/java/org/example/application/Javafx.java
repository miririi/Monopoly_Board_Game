package org.example.application;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.view.GameScene;

public class Javafx extends Application {

        @Override
        public void start(Stage stage) {
            GameScene gameScene = new GameScene();
            gameScene.create_gameboard();
            gameScene.setScene(gameScene.gamePane);
            gameScene.setStage(new Stage());
            gameScene.createSubScenes();
            gameScene.initialize_character("/dog.png");
            gameScene.roll();
            stage = gameScene.getMainStage();
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
}
