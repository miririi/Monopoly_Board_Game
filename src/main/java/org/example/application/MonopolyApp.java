package org.example.application;
import javafx.application.Application;
import javafx.stage.Stage;
import org.example.view.MainMenu;


public class MonopolyApp extends Application {

        @Override
        public void start(Stage stage){
            /**GameScene gameScene = new GameScene();
            gameScene.create_gameboard();
            gameScene.setScene(gameScene.gamePane);
            gameScene.setStage(new Stage());
            gameScene.createSubScenes();
            gameScene.initialize_character("dog.png");
            gameScene.roll();**/
            MainMenu startMenu = new MainMenu();
            startMenu.createLayout();

            startMenu.setScene(startMenu.startPane);
            startMenu.setStage(new Stage());
            stage = startMenu.getMainStage();
            //stage = gameScene.getMainStage();
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
}
