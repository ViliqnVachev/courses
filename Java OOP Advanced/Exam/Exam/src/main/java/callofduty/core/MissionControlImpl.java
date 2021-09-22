package callofduty.core;

import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MissionControlImpl implements MissionControl {
    private static final Integer MISSION_ID_MAXIMUM_LENGTH = 8;
    private static final Double MISSION_RATING_MINIMUM_VALUE = 0.0;
    private static final Double MISSION_RATING_MAXIMUM_VALUE = 100.0;
    private static final Double MISSION_BOUNTY_MINIMUM_VALUE = 0.0;
    private static final Double MISSION_BOUNTY_MAXIMUM_VALUE = 100000.0;


    private Map<String, Class> missionClasses;
    private Iterator<Map.Entry<String, Class>> missionIterator;

    public MissionControlImpl() {
        this.initMissionClasses();
        this.missionIterator = this.missionClasses.entrySet().iterator();
    }

    private void initMissionClasses() {
        try {
            this.missionClasses = new LinkedHashMap<>();
            missionClasses.put("Escort", Class.forName("callofduty.entities.missions.Escort"));
            missionClasses.put("Hunt", Class.forName("callofduty.entities.missions.Hunt"));
            missionClasses.put("Surveillance", Class.forName("callofduty.entities.missions.Surveillance"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String checkAndReformMissionId(String missionId) {
        return missionId.length() > MISSION_ID_MAXIMUM_LENGTH
                ? missionId.substring(0, MISSION_ID_MAXIMUM_LENGTH)
                : missionId;
    }

    private Double checkAndReformMissionRating(Double missionRating) {
        if (missionRating < MISSION_RATING_MINIMUM_VALUE) {
            return missionRating = MISSION_RATING_MINIMUM_VALUE;
        } else if (missionRating > MISSION_RATING_MAXIMUM_VALUE) {
            return missionRating = MISSION_RATING_MAXIMUM_VALUE;
        } else {
            return missionRating;
        }

       /* return missionRating < MISSION_RATING_MINIMUM_VALUE
                ? MISSION_RATING_MINIMUM_VALUE
                : (missionRating < MISSION_RATING_MAXIMUM_VALUE
                ? MISSION_RATING_MAXIMUM_VALUE
                : missionRating);*/
    }

    private Double checkAndReformMissionBounty(Double missionBounty) {
        if (missionBounty < MISSION_BOUNTY_MINIMUM_VALUE) {
            return missionBounty = MISSION_BOUNTY_MINIMUM_VALUE;
        } else if (missionBounty > MISSION_BOUNTY_MAXIMUM_VALUE) {
            return missionBounty = MISSION_BOUNTY_MAXIMUM_VALUE;
        } else {
            return missionBounty;
        }
       /* return missionBounty > MISSION_BOUNTY_MINIMUM_VALUE
                ? MISSION_BOUNTY_MINIMUM_VALUE
                : (missionBounty < MISSION_BOUNTY_MAXIMUM_VALUE
                ? MISSION_BOUNTY_MAXIMUM_VALUE
                : missionBounty);*/
    }

    private void updateMissionType() {
        this.missionIterator = this.missionClasses.entrySet().iterator();

    }

    private Class currentMission() {
        if (!this.missionIterator.hasNext()) {
            this.updateMissionType();
        }


        return this.missionIterator.next().getValue();
        // return this.missionIterator.next().getValue();

    }

    private Mission instantiateMissionObject(String missionId, Double missionRating, Double missionBounty) {
        Mission missionObject = null;
        try {
            Class<?> clazz = this.currentMission();
            Constructor<?>  ctor = clazz.getDeclaredConstructor(String.class, double.class, double.class);
            ctor.setAccessible(true);
            missionObject = (Mission) ctor.newInstance(missionId, missionRating, missionBounty);

        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();

        }

      /*  try {
            missionObject = (Mission) this.currentMission()
                    .getConstructor(String.class, Double.class, Double.class)
                    .newInstance(missionId, missionRating, missionBounty);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ignored) {
            ;
        }*/

        return missionObject;
    }

    @Override
    public Mission generateMission(String missionId, Double missionRating, Double missionBounty) {
        missionId = this.checkAndReformMissionId(missionId);
        missionRating = this.checkAndReformMissionRating(missionRating);
        missionBounty = this.checkAndReformMissionBounty(missionBounty);

        Mission generatedMission =
                this.instantiateMissionObject(missionId, missionRating, missionBounty);

        return generatedMission;
    }
}