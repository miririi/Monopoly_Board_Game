package org.example.view;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.example.view.ButtonSubscene;

import java.util.Random;

public class GameScene extends ViewManager {

    private int dice_number;
    public AnchorPane gamePane;
    private ImageView character;
    private ImageView diceImage;
    private ButtonSubscene subscene;
    Random random = new Random();

    public GameScene() {
        super();
        gamePane = new AnchorPane();
        diceImage = new ImageView();
        subscene = new ButtonSubscene();
    }

    public void create_gameboard() {
        createButtonsOnLeft();
        createButtonsOnTop();
        createButtonsOnRight();
        createButtonsOnBottom();
    }

    private void createButtonsOnLeft() {
        double y_axis = 0.0;
        String [] buttons = {"collect_200", "MR_avenue", "community_chest", "baltic_avenue", "luxury_tax", "reading_railroad", "oriental_avenue", "chance", "vermont_avenue", "connecticut_avenue", "just_visiting" };
        for (String monopoly_button: buttons){
            Button style_button = new Button();
            style_button.setPrefHeight(70.0);
            style_button.setPrefWidth(70);
            style_button.setStyle("-fx-background-color: transparent; -fx-background-image: url('"+ monopoly_button + ".png');  -fx-background-size: 70px 70px; -fx-background-position: center; -fx-background-repeat: no-repeat");
            gamePane.getChildren().add(style_button);
            if(monopoly_button.equals("just_visiting")){
                gamePane.setTopAnchor(style_button, 0.0);
            }
            else {
                gamePane.setBottomAnchor(style_button, y_axis);
            }
            y_axis += 70.0;

            if(!monopoly_button.equals("collect_200") && !monopoly_button.equals("chance") && !monopoly_button.equals("community_chest") && !monopoly_button.equals("luxury_tax")){
                style_button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        subscene.moveSubScene();
                    }
                });
            }
            else {
                style_button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        subscene.deleteSubScene();
                    }
                });
            }
        }
    }

    private void createButtonsOnTop() {
        double x_axis = 70.0;
        String [] buttons = {"charles_place", "electric_company", "states_avenue", "virginia_avenue", "pennsylvania_railroad", "james_place", "community_chest", "tennessee_avenue", "new_york_avenue", "free_parking"};
        for(String monopoly_button: buttons){
            Button style_button = new Button();
            style_button.setPrefHeight(70.0);
            style_button.setPrefWidth(70.0);
            style_button.setStyle("-fx-background-color: transparent; -fx-background-image: url('"+ monopoly_button +".png');  -fx-background-size: 70px 70px; -fx-background-position: center; -fx-background-repeat: no-repeat");
            gamePane.getChildren().add(style_button);
            gamePane.setLeftAnchor(style_button, x_axis);
            x_axis += 70.0;
            //initializeButtonListeners(monopoly_button, style_button);
            if(!monopoly_button.equals("free_parking") && !monopoly_button.equals("community_chest")){
                style_button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        subscene.moveSubScene();
                    }
                });

            } else {
                style_button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        subscene.deleteSubScene();
                    }
                });

            }
        }
    }

    private void createButtonsOnRight() {
        String [] buttons = {"go_jail", "marvin_gardens", "water_works", "ventnor_avenue", "atlantic_avenue", "railroad", "illinois_avenue", "indiana_avenue", "chance", "kentucky_avenue" };
        Double y_axis = 0.0;
        for (String monopoly_button: buttons){
            Button style_button = new Button();
            style_button.setPrefHeight(70.0);
            style_button.setPrefWidth(70);
            style_button.setStyle("-fx-background-color: transparent; -fx-background-image: url('" + monopoly_button + ".png');  -fx-background-size: 70px 70px; -fx-background-position: center; -fx-background-repeat: no-repeat");
            gamePane.getChildren().add(style_button);
            gamePane.setBottomAnchor(style_button, y_axis);
            gamePane.setLeftAnchor(style_button, 700.0);
            y_axis += 70.0;
            if(!monopoly_button.equals("go_jail") && !monopoly_button.equals("chance")){
                style_button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        subscene.moveSubScene();
                    }
                });
            } else {
                style_button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        subscene.deleteSubScene();
                    }
                });
            }
        }
    }

    private void createButtonsOnBottom() {
        Double x_axis = 70.0;
        Double y_axis = 0.0;
        String [] buttons = {"boardwalk", "luxury_tax", "park_place", "chance", "short_line", "pennsylvania_avenue", "community_chest", "north_carolina_avenue", "pacific_avenue"};
        for(String monopoly_button: buttons){
            Button style_button = new Button();
            style_button.setPrefHeight(70.0);
            style_button.setPrefWidth(70.0);
            style_button.setStyle("-fx-background-color: transparent; -fx-background-image: url('" + monopoly_button + ".png');  -fx-background-size: 70px 70px; -fx-background-position: center; -fx-background-repeat: no-repeat");
            gamePane.getChildren().add(style_button);
            gamePane.setLeftAnchor(style_button, x_axis);
            gamePane.setBottomAnchor(style_button, y_axis);
            x_axis += 70.0;
            if(!monopoly_button.equals("luxury_tax") && !monopoly_button.equals("chance") && !monopoly_button.equals("community_chest")){
                style_button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        subscene.moveSubScene();
                    }
                });
            } else {
                style_button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        subscene.deleteSubScene();
                    }
                });
            }

        }
    }

    /* private void createCharacter(Character choosenCharacter){
        character = new ImageView("/dog.png");
        //character.setStyle("-fx-background-color: transparent; -fx-background-image: url('"+ style + ".png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat");

        character.setLayoutX(150);
        character.setLayoutY(150);
        mainPane.getChildren().add(character);


    } */

    public void initialize_character(String url) {
        character = new ImageView(url);
        character.setFitHeight(70.0);
        character.setFitWidth(70.0);
        gamePane.getChildren().add(character);
        gamePane.setBottomAnchor(character, 0.0);

    }

    public void move_character(int dice_number) {
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(1000));
        translate.setNode(character);
        translate.play();
        translate.setOnFinished(actionEvent -> {
            updatePos(dice_number, character);
        });
    }

    private void updatePos(int dice_number, ImageView character) {
        double vert = character.getY();
        double horizontal = character.getX();
        System.out.println(horizontal);
        if(horizontal == 0){ // Figur links
            character.setY(70.0 * dice_number + vert);
            gamePane.setBottomAnchor(character, 70.0 * dice_number + vert);
        }
    }

    public int rollDice(){ return random.nextInt(6)+1;}

    public void roll(){
        dice_number = rollDice();
        ImageView dice = new ImageView(new Image("dice"+dice_number+".png", 100, 0, true, true));
        Button roll = new Button("Roll Dice");
        roll.setMinSize(15, 25);
        roll.setMinWidth(50);
        roll.setMinHeight(25);
        roll.setLayoutY(300);
        roll.setLayoutX(300);
        dice.setLayoutY(200);
        dice.setLayoutX(200);
        gamePane.getChildren().add(roll);
        gamePane.getChildren().add(dice);
        roll.setOnAction(e -> {
            RotateTransition rt = new RotateTransition();
            rt.setByAngle(360);
            rt.setNode(diceImage);
            rt.setDuration(Duration.millis(1000));
            rt.play();
            dice_number = rollDice();
            rt.setOnFinished(j -> dice.setImage(new Image("dice"+ dice_number + ".png", 100, 0, true, true)));
            move_character(dice_number);

        });
    }

    public void createSubScenes() {
     subscene = new ButtonSubscene();
     gamePane.getChildren().add(subscene);
     }
}
