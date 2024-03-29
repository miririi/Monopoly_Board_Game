package org.example.model;

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.control.Button;

public class SpaceRunnerButton extends Button {

    private final String BUTTON_STYLE = "src/main/java/org/example/model/resources/free_parking.png";

    public SpaceRunnerButton(String text) {
        setText(text);
        //setFont(Font.font("Verdana", 23));
        setPrefWidth(190);
        setPrefHeight(149);
        setStyle(BUTTON_STYLE);

    }

    private void setButtonPressedStyle(){  //Pressed Button is smaller
        setStyle(BUTTON_STYLE);
        setPrefHeight(145);
        setLayoutY(getLayoutY()+4);

    }

    private void setButtonReleasedStyle(){
        setStyle(BUTTON_STYLE);
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
