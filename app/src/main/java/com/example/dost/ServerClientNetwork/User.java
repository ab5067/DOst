package com.example.dost.ServerClientNetwork;

public class User {
    /**
     * Enumerator that defines the type of the user
     */
    public enum TYPE{
        VOLUNTEER,AFFLICTED
    }
    public enum STATUS{
        ONLINE,OFFLINE
    }

    private TYPE type;
    private String username;
    private STATUS status; // whether online/offline
    private String messageFromUI;
    private String messageFromServer;
    public Boolean updateServer;
    public Boolean updateUI;

    public User(TYPE type, String username,STATUS status) {
        this.type=type;
        this.username=username;
        this.status=status;
        this.messageFromServer=null;
        this.messageFromUI=null;
        this.updateServer=false;
        this.updateUI=false;
    }

    /**
     * Communication Between the server and the UI
     */

    /**
     * This function will be called in the server and will update the message
     * @param message message from the server
     */
    public void setMessageFromServer(String message){
        this.messageFromServer=message;
    }

    /**
     * This function will be called in the UI and will update the message
     * @param message message from the UI
     */
    public void setMessageFromUI(String message){
        this.messageFromUI=message;
    }

    /**
     * For getting the message from the UI
     * @return message from the UI
     */
    public String getMessageFromUI(){
        return this.messageFromUI;
    }

    /**
     * For getting the message from the server
     * @return message from the server
     */
    public String getMessageFromServer() {
        return this.messageFromServer;
    }

    /**
     * If there is a new message from the server, then set updateUI to be true
     * @param newMessage
     */
    public void newMessageFromServer(Boolean newMessage){
        this.updateUI=newMessage;
    }

    /**
     * If there is a newMessage from the UI, then set updateServer to be true
     * @param newMessage
     */
    public void newMessageFromUI(Boolean newMessage){
        this.updateServer=newMessage;
    }


    // STATUS OF THE USER
    /**
     * Setting the current status of the user
     * @param status: either OFFLINE or ONLINE
     */
    public void setStatus(STATUS status){
        // Also include in the UI if the user closes their chat they go offline and immediately let the server know of the status of the user
        this.status=status;
    }
    /**
     * The current status of the user
     * @return either OFFLINE or ONLINE
     */
    public STATUS getStatus(){
        return this.status;
    }
}
