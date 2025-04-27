package model;

public class Payload {
    String stageId;
    String timeStamp;
    public Payload(String stageId, String timeStamp) {
        this.stageId = stageId;
        this.timeStamp = timeStamp;
    }
    public String getStageId() {
        return stageId;
    }
    public String getTimeStamp() {
        return timeStamp;
    }

    


}
