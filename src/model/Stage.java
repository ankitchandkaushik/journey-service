package model;

public class Stage {
    String id;
    String name;
    String journeyId;
    Stage previousStage;

    public void setNextStage(Stage nextStage) {
        this.previousStage = nextStage;
    }

    public Stage(String id, String name, String journeyId, Stage previousStage) {
        this.id = id;
        this.name = name;
        this.journeyId = journeyId;
        this.previousStage= previousStage;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJourneyId() {
        return journeyId;
    }

    public Stage getPreviousStage() {
        return previousStage;
    }

    public Stage(String id, String name, String journeyId) {
        this.id = id;
        this.name = name;
        this.journeyId = journeyId;
        this.previousStage= null;
    }


    
}
