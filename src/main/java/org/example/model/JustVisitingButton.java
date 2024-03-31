package org.example.model;

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

public class JustVisitingButton extends Button {
    private final String JUST_VISITING_STYLE = "-fx-background-color: transparent; -fx-background-image: url('just_visiting.png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat";


    public JustVisitingButton() {
        super();
        setPrefWidth(200);
        setPrefHeight(200);
        setStyle(JUST_VISITING_STYLE);
        initializeButtonListeners();

    }

    private void setButtonPressedStyle(){  //Pressed Button is smaller
        setStyle(JUST_VISITING_STYLE);
        setPrefHeight(145);
        setLayoutY(getLayoutY()+4);

    }

    private void setButtonReleasedStyle(){
        setStyle(JUST_VISITING_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY()-4);

    }

    private void initializeButtonListeners(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle();
                }
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(new DropShadow());
                ;            }
        });
    }
}

