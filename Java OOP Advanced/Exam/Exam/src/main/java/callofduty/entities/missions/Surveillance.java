package callofduty.entities.missions;

public class Surveillance extends BaseMission {
    public Surveillance(String id, double rating, double bounty) {
        super(id, (rating - rating * 0.75), bounty + bounty * 0.50);
    }
}
