package callofduty.core;

import callofduty.entities.agents.Master;
import callofduty.entities.agents.Novice;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MissionManagerImpl implements MissionManager {
    private Map<String, Agent> allAgents;
    private Map<String, Mission> missions;
    private List<Mission> missionsCompleted;
    private MissionControl missionControl;

    public MissionManagerImpl() {
        this.allAgents = new LinkedHashMap<>();
        this.missions = new LinkedHashMap<>();
        this.missionsCompleted = new ArrayList<>();
        this.missionControl = new MissionControlImpl();
    }

    @Override

    public String agent(List<String> arguments) {
        String id = arguments.get(0);
        String name = arguments.get(1);

        Agent agent = new Novice(id, name);
        this.allAgents.put(id, agent);


        return String.format("Registered Agent - %s:%s", name, id);
    }

    @Override
    public String request(List<String> arguments) {
        //•	Request {agentId} {missionId} {missionRating} {missionBounty}
        String agentId = arguments.get(0);
        String missionId = arguments.get(1);
        Double missionRating = Double.parseDouble(arguments.get(2));
        Double missionBounty = Double.parseDouble(arguments.get(3));

        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);

        this.missions.put(missionId, mission);
        Agent agent = this.allAgents.get(agentId);
        agent.acceptMission(mission);


        return String.format("Assigned %s Mission - %s to Agent - %s", mission.getClass().getSimpleName(), missionId, agent.getName());
    }

    @Override
    public String complete(List<String> arguments) {
        String agentId = arguments.get(0);
        Agent agent = this.allAgents.get(agentId);
        agent.completeMissions();

        List<Mission> allMissions = null;

        try {
            Method completedMissions = agent.getClass().getDeclaredMethod("getCompletedMissions");
            completedMissions.setAccessible(true);
            allMissions = (List<Mission>) completedMissions.invoke(agent);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        String masterID = agent.getId();
        String masterName = agent.getName();
        Double masterRating = agent.getRating();

        if (allMissions.size() >= 3) {
            this.allAgents.remove(agentId);
            Agent master = new Master(masterID, masterName, masterRating, allMissions);
            this.allAgents.put(masterID, master);
        }

        this.missionsCompleted.addAll(allMissions);

        return String.format("Agent - %s:%s has completed all assigned missions.", masterName, masterID);
    }

    @Override
    public String status(List<String> arguments) {
        String id = arguments.get(0);

        if (this.allAgents.containsKey(id)) {

            Agent agent = this.allAgents.get(id);
            return agent.toString();
        } else {
            Mission mission = this.missions.get(id);
            String status = "Open";
            if (this.missionsCompleted.contains(mission)) {
                status = "Completed";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s Mission – %s", mission.getClass().getSimpleName(), mission.getId()))
                    .append(System.lineSeparator())
                    .append(String.format("Status: %s", status))
                    .append(System.lineSeparator())
                    .append(String.format("Rating: %.2f", mission.getRating()))
                    .append(System.lineSeparator())
                    .append(String.format("Bounty: %.2f", mission.getBounty()))
                    .append(System.lineSeparator());
            return sb.toString();
        }

    }


    @Override
    public String over(List<String> arguments) {
        List<Agent> novice = this.allAgents.values().stream().filter(a -> a.getClass().getSimpleName().equals("Novice")).collect(Collectors.toList());
        List<Agent> master = this.allAgents.values().stream().filter(a -> a.getClass().getSimpleName().equals("Master")).collect(Collectors.toList());

        double totalRating = this.missionsCompleted.stream().mapToDouble(Mission::getRating).sum();
        double totalBounty = master.stream().get;


        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Novice Agents: %d", novice.size()))
                .append(System.lineSeparator())
                .append(String.format("Master Agents: %d", master.size()))
                .append(System.lineSeparator())
                .append(String.format("Assigned Missions: %d", this.missions.size()))
                .append(System.lineSeparator())
                .append(String.format("Completed Missions: %d", this.missionsCompleted.size()))
                .append(System.lineSeparator())
                .append(String.format("Total Rating Given: %.2f", totalRating))
                .append(System.lineSeparator())
                .append(String.format("Total Bounty Given: %.2f", totalBounty))
                .append(System.lineSeparator());


        return sb.toString();
    }
}
