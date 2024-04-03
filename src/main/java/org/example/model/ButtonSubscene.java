package org.example.model;

import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.util.Duration;

public class ButtonSubscene extends SubScene {
    private final static String BACKGROUND_IMAGE = "blue.png";
    private boolean isHidden;

    private AnchorPane root2;
    private Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

    public ButtonSubscene() {
        super(new AnchorPane(), 600, 400);
        prefWidth(600);
        prefHeight(400);
        isHidden = false;

        BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 600, 400, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(image));

        Button buy = new Button("BUY!");
        buy.setPrefWidth(100);
        buy.setPrefHeight(100);
        buy.setLayoutX(100);
        buy.setLayoutY(100);



        root2.getChildren().add(buy);
        setLayoutX(primaryScreenBounds.getMaxX() + 1);
        setLayoutY(primaryScreenBounds.getMinY() + 1);
    }

    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);

        if(isHidden){
            transition.setToX(-676);
            isHidden = false;
        } else {
            transition.setToX(0);
            isHidden = true;
        }

        transition.play();
    }

    public void deleteSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);
        transition.setToX(0);
        isHidden = true;

        transition.play();

    }
}
