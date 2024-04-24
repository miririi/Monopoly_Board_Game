package org.example.entity;

import java.util.LinkedList;

public class MonopolyGame {
    private LinkedList<Player> players;

    public MonopolyGame(){
        players = new LinkedList<>();
    }

    public void start_game(){
        // pass
    }

    public void add_player(Player player){
        players.add(player);
    }

}
