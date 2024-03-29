package org.example.model;

import javafx.scene.text.Font;
import javafx.scene.control.Button;

public class SpaceRunnerButton extends Button {

    private final String BUTTON_PRESSED_STYLE = "src/model/resources/free_parking.png";

    public SpaceRunnerButton(String text) {
        setText(text);
        setFont(Font.font("Verdana", 23));

    }

    private void setButtonPressedStyle(){
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY()+4);

    }
}
