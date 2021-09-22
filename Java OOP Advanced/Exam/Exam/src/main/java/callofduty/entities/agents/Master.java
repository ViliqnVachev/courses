package callofduty.entities.agents;

import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;

import java.util.ArrayList;
import java.util.List;

public class Master extends BaseAgent implements BountyAgent {
    private static final Double START_BOUNTY = 0.0;

    private double bounty;
    private List<Mission> masterAccespMission;
    private List<Mission> masterCompleteMission;
    private double notEnarnt;

    public Master(String id, String name, Double rating, List<Mission> completeMission) {
        super(id, name, rating);
        this.bounty = getBounty();
        this.masterCompleteMission = new ArrayList<>();
        super.setCompletedMissions(completeMission);
        this.notEnarnt = completeMission.stream().mapToDouble(Mission::getBounty).sum();
    }


    @Override
    public Double getBounty() {
        Double temp = super.getCompletedMissions().stream().mapToDouble(Mission::getBounty).sum() - this.notEnarnt;
        return this.bounty + temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        //{agentType} Agent – {name}
        //Personal Code: {id}
        //Assigned Missions: {assignedMissionsCount}
        //Completed Missions: {completedMissionsCount}
        //Rating: {rating}
        //Bounty Earned: ${bounty}

        sb.append(System.lineSeparator())
                .append(String.format("Bounty Earned: $%.2f", this.getBounty()));

        return sb.toString();
    }
}
