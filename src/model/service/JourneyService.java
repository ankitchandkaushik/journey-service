package model.service;

import java.util.HashMap;

import model.Payload;
import model.Stage;
import model.State;
import model.User;

public class JourneyService {
    HashMap<String, User> userCatalog = new HashMap<>();


    public String currentState(String userID, String journeyID) {
        if(userExists(userID)) {
            User u = userCatalog.get(userID);
            if(u.getJourneyState().containsKey(journeyID)) {
                return u.getJourneyState().get(journeyID).getStageId();
            } else {
                System.out.println("User " + userID + " not on journey " + journeyID);
                return null;
            }
        }
        System.out.println("User does not exists");
        return null;
    }

    public boolean  isOnboarded(String userID, String journeyID) {
        if(userExists(userID)) {
            User u = userCatalog.get(userID);
            if(u.getJourneyState().containsKey(journeyID)) {
                return true;
            } else {
                return false;
            }
        }
        System.out.println("User does not exists");
        return false;
    }

    public void deactivatedJourneyCleanup(String journeyId) {
        for(String userId: userCatalog.keySet()) {
            HashMap<String, State> journey = userCatalog.get(userId).getJourneyState();
            for(String userJId: journey.keySet()) {
                if(userJId.equals(journeyId)) {
                    userCatalog.get(userId).getJourneyState().remove(journeyId);
                    System.out.println("Cleaned up journey " + journeyId + " for user " + userId);
                }
            }
        }
    }


    public void evaluate(String userId, Payload payload, Stage stage) {
        if(userExists(userId)) {
            String journeyId = stage.getJourneyId();
            User user = userCatalog.get(userId);
            if(user.getJourneyState().containsKey(journeyId)) {
                State state = user.getJourneyState().get(journeyId);
                if(state.getStageId().equals(stage.getPreviousStage().getId())) {
                    // TODO how to handle time and mismatches
                } else {
                    System.out.println("Disconnected states");
                }
            } else {
                System.out.println("User is not active on journey: " + journeyId);
            }
        } else {
            System.out.println("User " + userId + " does not exists ignoring message");
        }
    }


    boolean userExists(String userID) {
        return userCatalog.containsKey(userID);
    }
}
