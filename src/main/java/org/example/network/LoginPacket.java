package org.example.network;

import java.nio.charset.StandardCharsets;

public class LoginPacket extends Packet{

    private String username;
    private int x, y;

    public LoginPacket(byte[] data){
        super(00);

    }

    @Override
    public void writeData(GameClient client){
        client.sendData(getData());
    }

    @Override
    public void writeData(GameServer server){
        server.sendDataToAllClients(getData());
    }

    @Override
    public byte[] getData() {
        return ("00" + this.username + "," + getX() + "," + getY()).getBytes(StandardCharsets.UTF_8);
    }

    public String getUsername(){
        return username;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }
}
