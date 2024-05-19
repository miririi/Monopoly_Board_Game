package org.example.entity;

import javafx.scene.canvas.Canvas;
import org.example.network.GameClient;
import org.example.network.GameServer;
import org.example.network.LoginPacket;

import javax.swing.*;
import java.util.LinkedList;


public class MonopolyGame extends Canvas implements Runnable {
    private LinkedList<Player> players;
    private GameClient gameClient;
    private GameServer server;
    private Thread thread;
    public boolean running =false;

    public MonopolyGame(){
        //thread = new Thread();
        players = new LinkedList<>();

    }



    public void start_game(){
        Player player = new Player("Test", null, -1);

        LoginPacket loginPacket = new LoginPacket(player.username.getBytes());
            if (server != null) {
                System.out.println("Alright");
                server.addConnection(player, loginPacket);
            }
            loginPacket.writeData(gameClient);
        }


    public synchronized void start(){
        running = true;
        new Thread(this).start();
        if (JOptionPane.showConfirmDialog(new JFrame(), "Do you want to run the server") == 0) {
            server = new GameServer(this);
            server.start();
        }
        gameClient = new GameClient(this, "localhost");
        gameClient.start();
    }

    public void add_player(Player player){
        players.add(player);
    }

    @Override
    public void run() {

    }
}
