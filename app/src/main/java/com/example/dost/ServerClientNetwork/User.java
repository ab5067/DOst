package com.example.dost.ServerClientNetwork;

public class User {
    /**
     * Enumerator that defines the type of the user
     */
    public enum TYPE{
        VOLUNTEER,AFFLICTED
    }

    private static TYPE type;
    private static String username;

    public User(TYPE type, String username) {
        this.type=type;
        this.username=username;
    }

    /**
     * User want to send a particular message
     * @param message: The message that has to be sent
     */
    public void sendMessage(String message){

    }

    public String readMessage(String msg){
        // somehow tells the UI that they have a new message and displays that
        return msg;
    }

}
