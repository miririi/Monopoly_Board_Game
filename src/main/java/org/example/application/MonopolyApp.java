package org.example.application;
import javafx.application.Application;
import javafx.stage.Stage;
import org.example.entity.MonopolyGame;
import org.example.view.MainMenu;


public class MonopolyApp extends Application {

        @Override
        public void start(Stage stage){
            MonopolyGame game = new MonopolyGame();
            MainMenu startMenu = new MainMenu(game);
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
