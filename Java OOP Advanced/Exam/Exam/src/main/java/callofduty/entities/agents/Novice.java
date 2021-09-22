package callofduty.entities.agents;

import callofduty.interfaces.Mission;

import java.util.List;

public class Novice extends BaseAgent {
    private static final double START_RATING = 0;

    public Novice(String id, String name) {
        super(id, name, START_RATING);
    }

    @Override
    protected List<Mission> getCompletedMissions() {
        return super.getCompletedMissions();
    }
}
