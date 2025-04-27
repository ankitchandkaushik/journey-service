package model;

import java.util.HashMap;

public class User {
    String userId;
    HashMap<String, State> journeyState;
    public User(String userId) {
        this.userId = userId;
        this.journeyState = new HashMap<>();
    }
    public String getUserId() {
        return userId;
    }
    public HashMap<String, State> getJourneyState() {
        return journeyState;
    }

    

    
    
}
