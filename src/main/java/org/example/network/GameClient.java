package org.example.network;
import org.example.entity.MonopolyGame;
import org.example.entity.Player;

import java.io.IOException;
import java.lang.*;
import java.net.*;

public class GameClient extends Thread {

    private InetAddress ipAddress;
    private DatagramSocket socket;
    private MonopolyGame game;

    public GameClient(MonopolyGame game, String ipAddress) {
        this.game = game;
        try {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
        } catch(SocketException e){
            e.printStackTrace();
        } catch(UnknownHostException e){
            e.printStackTrace();
        }
    }

    public void run() {
        byte[] data = new byte[1024];
        DatagramPacket packet =new DatagramPacket(data, data.length);
        try {
            socket.receive(packet);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private void parsePacket(byte[] data, InetAddress address, int port){
        String message = new String(data).trim();
        Packet.PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
        Packet packet = null;
        switch(type){
            case INVALID -> {break;}
            case LOGIN -> {
                packet = new LoginPacket(data);
                handleLogin((LoginPacket) packet, address, port);
                break;
            }
        }
    }

    public void sendData(byte[] data){
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 1331);
        try{
            socket.send(packet);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void handleLogin(LoginPacket packet, InetAddress address, int port){
        Player player = new Player("Test", address, port);

    }


}
