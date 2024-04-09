package org.example.entity;
public class street {
    private int [] owner;
    private String name;

    public street(String name){
        name = name;
        owner = new int[]{0, 0};
    }

    public void buy_street(int player_no){
        owner = new int[]{1, player_no};
    }

    public void build_house(int player_no) {
        //
    }

}
