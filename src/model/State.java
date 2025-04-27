package model;

public class State {
    String stageId;
    String startTime;
    public State(String stageId, String startTime) {
        this.stageId = stageId;
        this.startTime = startTime;
    }
    public String getStageId() {
        return stageId;
    }
    public String getStartTime() {
        return startTime;
    }

    
}
