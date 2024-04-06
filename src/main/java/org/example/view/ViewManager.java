package org.example.view;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.model.ButtonSubscene;
import org.example.model.Character;

public class ViewManager{
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private ButtonSubscene subscene;
    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;

    private ImageView character;

    private int angle;

    private AnimationTimer gameTimer;


    private double GAME_WIDTH;
    private double GAME_HEIGHT;

    public ViewManager() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, 800, 600);
        mainStage = new Stage();
        mainStage.setScene(mainScene);

        createButtonsOnLeft();
        createButtonsOnTop();
        createButtonsOnRight();
        createButtonsOnBottom();
        createSubScenes();
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        initialize();

        //set Stage boundaries to visible bounds of the main screen
        mainStage.setX(primaryScreenBounds.getMinX());
        mainStage.setY(primaryScreenBounds.getMinY());
        mainStage.setWidth(primaryScreenBounds.getWidth());
        mainStage.setHeight(primaryScreenBounds.getHeight());

        GAME_WIDTH = primaryScreenBounds.getWidth();
        GAME_HEIGHT = primaryScreenBounds.getHeight();

        mainStage.show();



    }

    private void createSubScenes() {
        subscene = new ButtonSubscene();
        mainPane.getChildren().add(subscene);

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
    private void createButtonsOnLeft() {
        double y_axis = 0.0;
        String [] buttons = {"collect_200", "MR_avenue", "community_chest", "baltic_avenue", "luxury_tax", "reading_railroad", "oriental_avenue", "chance", "vermont_avenue", "connecticut_avenue", "just_visiting" };
        for (String monopoly_button: buttons){
            Button style_button = new Button();
            style_button.setPrefHeight(121.0);
            style_button.setPrefWidth(180);
            style_button.setStyle("-fx-background-color: transparent; -fx-background-image: url('"+ monopoly_button + ".png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat");
            mainPane.getChildren().add(style_button);
            if(monopoly_button.equals("just_visiting")){
                mainPane.setTopAnchor(style_button, 0.0);
                style_button.setPrefHeight(135.0);
            }
            else {
                mainPane.setBottomAnchor(style_button, y_axis);
            }

            y_axis += 123.0;


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
        double x_axis = 150.0;
        String [] buttons = {"charles_place", "electric_company", "states_avenue", "virginia_avenue", "pennsylvania_railroad", "james_place", "community_chest", "tennessee_avenue", "new_york_avenue", "free_parking"};
        for(String monopoly_button: buttons){
            Button style_button = new Button();
            style_button.setPrefHeight(140.0);
            style_button.setPrefWidth(200.0);
            style_button.setStyle("-fx-background-color: transparent; -fx-background-image: url('"+ monopoly_button +".png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat");

            mainPane.getChildren().add(style_button);
            mainPane.setLeftAnchor(style_button, x_axis);
            x_axis += 135.0;
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

            style_button.setPrefHeight(121.0);
            style_button.setPrefWidth(180);
            style_button.setStyle("-fx-background-color: transparent; -fx-background-image: url('" + monopoly_button + ".png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat");
            mainPane.getChildren().add(style_button);
            mainPane.setBottomAnchor(style_button, y_axis);
            mainPane.setLeftAnchor(style_button, 1375.0);
            y_axis += 123.0;
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
        Double x_axis = 150.0;
        Double y_axis = 0.0;
        String [] buttons = {"boardwalk", "luxury_tax", "park_place", "chance", "short_line", "pennsylvania_avenue", "community_chest", "north_carolina_avenue", "pacific_avenue"};
        for(String monopoly_button: buttons){
            Button style_button = new Button();
            style_button.setPrefHeight(140.0);
            style_button.setPrefWidth(200.0);
            style_button.setStyle("-fx-background-color: transparent; -fx-background-image: url('" + monopoly_button + ".png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat");
            mainPane.getChildren().add(style_button);
            mainPane.setLeftAnchor(style_button, x_axis);
            mainPane.setBottomAnchor(style_button, y_axis);
            x_axis += 135.0;
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



    public void initialize(){
        ImageView character = new ImageView("/dog.png");
        character.setFitHeight(150.0);
        character.setFitWidth(150.0);
        mainPane.getChildren().add(character);
        mainPane.setBottomAnchor(character, 0.0);
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(1000));
        translate.setNode(character);
        if(1 == 1){ // Augenzahl
            translate.setByX(1000);
        }
        translate.play();
    }

}
