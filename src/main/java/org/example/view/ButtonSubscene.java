package org.example.view;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;


public class ButtonSubscene extends SubScene {

    private boolean isHidden;
    private Button buy_street = new Button("buy");

    public ButtonSubscene(){
        super(new AnchorPane(), 200,200);
        BackgroundImage image = new BackgroundImage(new Image("blue.png", 200, 200, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        AnchorPane root = (AnchorPane) this.getRoot();
        root.setBackground(new Background(image));
        setLayoutX(1000);
        setLayoutY(500);
        buy_street.setMinSize(50, 50);
        root.getChildren().add(buy_street);
        isHidden = true;
    }

    public void moveSubScene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);
        if(isHidden){
            transition.setToX(-676);
            isHidden = false;
        }else{
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }

    public void deleteSubScene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);
        transition.setToX(0);
        transition.play();
    }
}
