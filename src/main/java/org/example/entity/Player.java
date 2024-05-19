package org.example.entity;

import java.net.InetAddress;
import java.util.LinkedList;

public class Player {
    private Character character;
    private int player_no;
    private LinkedList<String> streets;
    private Money money;
    public InetAddress ipAddress;
    public int port;
    public String username;


    public Player(String username, InetAddress address, int port){
        this.player_no =1;
        this.ipAddress = address;
        this.port = port;
        this.username = username;



    }
}
