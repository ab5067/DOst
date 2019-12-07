package com.example.dost.ServerClientNetwork;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class client implements Protocols {
    private Duplexer duplexer;
    private String username;
    private User.TYPE type;
    private Boolean serverStatus;
    private ArrayList<String> activeVolunteers;
    private String channelID;
    private User user;
    public client(String hostname, int port, String username, User.TYPE type) throws IOException {
        this.duplexer=new Duplexer(new Socket(hostname,port));// creating a new Duplexer object
        this.username=username;
        this.type=type;
        this.serverStatus=true;
        this.channelID=null;
        this.user=new User(type,username);
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
    public void run() throws CommException {
        while (serverStatus){
            if(!this.duplexer.nextLine()){
                try {
                    throw new CommException("The server is down");
                } catch (CommException e) {
                    e.printStackTrace();
                }
            }
            String message=this.duplexer.read();
            ArrayList<String> messages=null;
            messages.addAll(Arrays.asList(message.split(" ")));
            switch (messages.get(0)) {
                case ONLINE:
                    // convey user the message that they are online
                    System.out.println("Connected to the server");
                    break;
                case ACTIVE_USERS:
                    this.activeVolunteers.addAll(messages.subList(1, messages.size() - 1));// this list will contain all the active Volunteers
                    break;
                case CONNECTED:
                    this.channelID=messages.get(1);
                case SENT:
                    if(channelID.equals(messages.get(1))){
                        System.out.println("The message was successfully delivered");
                        // Show in the app that the message was sent
                    }
                    else{
                        System.out.println("Message was not delivered by the server");
                    }
                    break;
                case USER_OFFLINE:// messages.get(1) will have the username of the person that they were connected to who just went offline
                    System.out.println("The user they were talking to just went offline");
                    break;
                case ERROR:
                    serverStatus = false;
                    throw new CommException("There is a error in the server");
            }

        }
    }
    /**
     * For closing the client side of the game
     * @throws Exception
     */
    public void close() throws Exception {
        this.duplexer.close();
    }
    /**
     * To create and start a thread of the run method when the GUI is initialized and running
     */
    public void startListener(){
        new Thread(()->{
            try {
                this.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
