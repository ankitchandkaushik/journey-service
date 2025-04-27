package model.service;

import java.util.HashMap;

import model.Journey;
import model.Payload;
import model.Stage;

public class AdminService {

    JourneyService journeyService;

    HashMap<String, Journey> journeyCatalog = new HashMap<>();
    HashMap<String, Stage> stageCatalog = new HashMap<>();

    public AdminService (JourneyService journeyService ) {
     this.journeyService = journeyService;
    }

    public boolean createJourney(Journey j) {
        if(j == null || journeyExists(j.getUuid())) {
            System.out.println("Journey cannot be created");
            return false;
        }
        journeyCatalog.put(j.getUuid(), j);
        return true;
    }

    public void updateState(String journeyId, boolean isActive) {
        if(!journeyExists(journeyId)) {
            System.out.println("No journey with " + " " + journeyId + " exists");
            return;
        } else {
            boolean currentState = journeyCatalog.get(journeyId).isActive();
            if(currentState == isActive) return ;
            if(!isActive) {
                // cleanup using userService
                journeyService.deactivatedJourneyCleanup(journeyId);
            }
            journeyCatalog.get(journeyId).setActive(isActive);

        }
    }

    public Journey getJourney(String journeyId) {
        if(journeyExists(journeyId)) {
            return journeyCatalog.get(journeyId);
        }

        // TODO is this correct way to write code
        new RuntimeException("Journey does not exist");
        return null;
    }


    public String currentStage(String userID, String journeyId) {
        if(journeyExists(journeyId)) {
            return journeyService.currentState(userID, journeyId);
        } else {
            System.out.println("Journey does not exists " + journeyId);
            return null;
        }
    }

    public boolean isOnboarded(String userID, String journeyId) {
        if(journeyExists(journeyId)) {
            return journeyService.isOnboarded(userID, journeyId);
        } else {
            System.out.println("Journey does not exists " + journeyId);
            return false;
        }
    }


    public void evaluate(String userId, Payload payload) {
        if(stageCatalog.containsKey(payload.getStageId())) {
            String journeyId = stageCatalog.get(payload.getStageId()).getJourneyId();
            if(journeyExists(journeyId) && journeyCatalog.get(journeyId).isActive()) {
                journeyService.evaluate(userId, payload, stageCatalog.get(payload.getStageId()));;
            } else {
                System.out.println(journeyId + " is inactive");
            }
            
        } else {
            System.out.println("This stage does not exists");
        }
        
    }


    public boolean journeyExists(String journeyId) {
        return journeyCatalog.containsKey(journeyId);
    }
}
