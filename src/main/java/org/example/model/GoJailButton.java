package org.example.model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class GoJailButton extends Button {
    private final String GO_JAIL_STYLE = "-fx-background-color: transparent; -fx-background-image: url('go_jail.png');  -fx-background-size: 150px 150px; -fx-background-position: center; -fx-background-repeat: no-repeat";

    public GoJailButton() {
        super();
        setCenterShape(true);
        setPrefWidth(200);
        setPrefHeight(200);
        setStyle(GO_JAIL_STYLE);
        initializeButtonListeners();

    }

    private void setButtonPressedStyle(){  //Pressed Button is smaller
        setStyle(GO_JAIL_STYLE);
        setPrefHeight(145);
        setLayoutY(getLayoutY()+4);

    }

    private void setButtonReleasedStyle(){
        setStyle(GO_JAIL_STYLE);
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
