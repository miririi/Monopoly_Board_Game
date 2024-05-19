package org.example.network;

import org.example.entity.MonopolyGame;
import org.example.entity.Player;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class GameServer extends Thread {

    private DatagramSocket socket;
    private MonopolyGame game;
    private List<Player> players = new ArrayList<>();

    public GameServer(MonopolyGame game){
        this.game =game;
        try{
            this.socket = new DatagramSocket();
        } catch (SocketException e) {
            System.out.println("Test");
            throw new RuntimeException(e);
        }
    }


    public void run() {
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        try{
            socket.receive(packet);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
        this.parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
    }

    private void parsePacket(byte[] data, InetAddress address, int port){
        String message = new String(data).trim();
        Packet.PacketTypes type = Packet.lookupPacket(message.substring(0,2));
        Packet packet =null;
        switch(type){
            case INVALID -> {break;}
            case LOGIN -> {
                packet = new LoginPacket(data);
                Player player =new Player("Test", address, port);
                this.addConnection(player, (LoginPacket) packet);
                break;
            }
        }
    }

    public void addConnection(Player player, LoginPacket packet){
        boolean alreadyConnected = false;
        for(Player p: this.players){
            if(p.username.equalsIgnoreCase(player.username)){//getUsername() required
                if(p.ipAddress == null){
                    p.ipAddress = player.ipAddress;
                }
                if(p.port== -1){
                    p.port = player.port;
                }
                alreadyConnected = true;

            } else{
                sendData(packet.getData(), p.ipAddress, p.port);
                packet = new LoginPacket((byte[]) p.username.getBytes());
                sendData(packet.getData(), player.ipAddress, player.port);
            }
        }
        if(!alreadyConnected){
            this.players.add(player);
        }
    }

    public void sendData(byte[] data, InetAddress ipAddress, int port){
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
        try{
            this.socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendDataToAllClients(byte[] data){
        for(Player p: players){
            sendData(data, p.ipAddress, p.port);
        }
    }

}