package callofduty.entities.missions;

public class Hunt extends BaseMission {
    public Hunt(String id, double rating, double bounty) {
        super(id, rating + (rating * 0.50), bounty * 2);
    }
}
