package callofduty.entities.missions;

public class Escort extends BaseMission {
    public Escort(String id, double rating, double bounty) {
        super(id, rating - (rating * 0.25), bounty + (bounty * 0.25));
    }
}
