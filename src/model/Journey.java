package model;
import java.util.List;

public class Journey {
    String uuid;

    String name;
    List<Stage> stages;
    boolean isActive;
    Type type;
    // TODO Change datatype 
    String duration;

    public Journey(String uuid, String name, List<Stage> stages, boolean isActive, Type type, String duration) {
        this.uuid = uuid;
        this.name = name;
        this.stages = stages;
        this.isActive = isActive;
        this.type = type;
        this.duration = duration;
    }
    public Journey(String uuid, String name, List<Stage> stages, boolean isActive, Type type) {
        this.uuid = uuid;
        this.name = name;
        this.stages = stages;
        this.isActive = isActive;
        this.type = type;
    }
    public String getUuid() {
        return uuid;
    }
    public String getName() {
        return name;
    }
    public List<Stage> getStages() {
        return stages;
    }
    public boolean isActive() {
        return isActive;
    }
    public Type getType() {
        return type;
    }
    public String getDuration() {
        return duration;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    @Override
    public String toString() {
        return "Journey [uuid=" + uuid + ", name=" + name + ", stages=" + stages + ", isActive=" + isActive + ", type="
                + type + ", duration=" + duration + "]";
    }
    

}
