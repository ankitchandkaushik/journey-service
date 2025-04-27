package model;

public class Message {

    String userID;
    Payload payload;
    public Message(String userID, Payload payload) {
        this.userID = userID;
        this.payload = payload;
    }
    public String getUserID() {
        return userID;
    }
    public Payload getPayload() {
        return payload;
    }

    
    
}
