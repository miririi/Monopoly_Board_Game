package org.example.model;

public enum Character {
    DOG("dog.png");

    String CharacterUrl;

    Character(String url){
        CharacterUrl = url;
    }

    public String getUrl() {
        return CharacterUrl;
    }

}
