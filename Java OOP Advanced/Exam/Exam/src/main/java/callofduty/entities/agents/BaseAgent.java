package callofduty.entities.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAgent implements Agent {

    private String id;
    private String name;
    private double rating;
    private List<Mission> allMissions;
    private List<Mission> acceptMissions;
    private List<Mission> completedMissions;

    protected BaseAgent(String id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.allMissions = new ArrayList<>();
        this.acceptMissions = new ArrayList<>();
        this.completedMissions = new ArrayList<>();
    }

    protected void setCompletedMissions(List<Mission> completedMissions) {
        this.completedMissions = completedMissions;
    }

    protected void setAcceptMissions(List<Mission> acceptMissions) {
        this.acceptMissions = acceptMissions;
    }

    protected List<Mission> getCompletedMissions() {
        return completedMissions;
    }

    protected void setAllMissions(List<Mission> allMissions) {
        this.allMissions = allMissions;
    }

    //Complete;
    @Override
    public void acceptMission(Mission mission) {
        this.allMissions.add(mission);
        this.acceptMissions.add(mission);
    }

    //TODO: maybe problem
    @Override
    public void completeMissions() {
        this.completedMissions.addAll(this.acceptMissions);
        this.acceptMissions = new ArrayList<>();
    }


    //Complete
    @Override
    public String getId() {
        return this.id;
    }


    //Complete
    @Override
    public String getName() {
        return this.name;
    }


    //Complete
    @Override
    public Double getRating() {
        Double temp = this.completedMissions.stream().mapToDouble(Mission::getRating).sum();
        return  temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s Agent - %s", this.getClass().getSimpleName(), this.getName()))
                .append(System.lineSeparator())
                .append(String.format("Personal Code: %s", this.getId()))
                .append(System.lineSeparator())
                .append(String.format("Assigned Missions: %d", this.acceptMissions.size()))
                .append(System.lineSeparator())
                .append(String.format("Completed Missions: %d", this.completedMissions.size()))
                .append(System.lineSeparator())
                .append(String.format("Rating: %.2f", this.getRating()));

        return sb.toString();
    }
}
