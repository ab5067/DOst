package com.example.dost.ServerClientNetwork;

import java.io.IOException;
import java.net.Socket;

import static com.example.dost.ServerClientNetwork.Protocols.*;

public class client implements Runnable {
    private Duplexer duplexer;
    private String username;
    private String type;
    public client(String hostname,int port, String username,String type) throws IOException {
        this.duplexer=new Duplexer(new Socket(hostname,port));// creating a new Duplexer object
        this.username=username;
        this.type=type;
    }
    private void sendMessage(String message){
        this.duplexer.send(message);
    }

    private String readMessage(){
        return this.duplexer.read();
    }


    /**
     * Will be implementing the protocols for the server
     */
    @Override
    public void run() {
        while (true){
            String message=this.duplexer.read();
            String[] messages=message.split(" ");
            switch (messages[0]){
                case ONLINE:
                    System.out.println("Connected to the server");
                    break;
                case CONNECT:
                    break;
                case SEND:
                    break;
                case ACTIVE_USERS:
                    break;
                case DISCONNECT:
                    break;
                case TYPE:
                    break;
                case ERROR:
                    break;
            }
        }
    }

}
