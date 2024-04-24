package org.example.entity;

import javafx.scene.image.ImageView;

public class Character {
    private String name;
    private ImageView url;

    public Character(String name) {
        name = name;
        url = new ImageView(name + ".png");
    }
}
