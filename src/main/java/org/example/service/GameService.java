package org.example.service;

import javafx.stage.Stage;
import org.example.view.GameScene;

public class GameService {
    public void start_game(GameScene gameScene, String player_name, String choosen_character){
        gameScene.create_gameboard();
        gameScene.setScene(gameScene.gamePane);
        gameScene.setStage(new Stage());
        gameScene.createSubScenes();
        gameScene.initialize_character("dog.png");
        gameScene.roll();
        Stage stage = gameScene.getMainStage();
        stage.show();
    }

    /* private void createCharacter(Character choosenCharacter){
        character = new ImageView("/dog.png");
        //character.setStyle("-fx-background-color: transparent; -fx-background-image: url('"+ style + ".png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat");

        character.setLayoutX(150);
        character.setLayoutY(150);
        mainPane.getChildren().add(character);


    } */
}
