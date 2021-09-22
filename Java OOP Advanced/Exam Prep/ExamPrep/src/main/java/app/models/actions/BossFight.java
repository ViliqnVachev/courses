package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {

    //•	BossFight – X number of heroes try to defeat the boss. If there are no heroes that try to enter the boss fight, print the following message: "There should be at least 1 participant for boss fight!". The combat mechanics are as follows:
    //o	First hero attacks, boss attacks first hero
    //o	Second hero attacks, boss attacks second hero and so on…
    //There should not be any attempts to attack a dead target, or a dead hero/boss attacking


    @Override
    public String executeAction(List<Targetable> participants) {

        List<Targetable> hero = participants.stream()
                .filter(Targetable::isAlive)
                .filter(p -> !p.getClass().getSimpleName().equals("Boss"))
                .collect(Collectors.toList());

        if (participants.size() < 1) {
            return "There should be at least 1 participant for boss fight!";
        }

        Targetable boss = participants.get(0);

        StringBuilder sb = new StringBuilder();

        while (boss.isAlive() && hero.size() > 0) {
            for (int i = 0; i < hero.size(); i++) {
                Targetable participantHero = hero.get(i);
                if (participantHero.isAlive()) {
                    participantHero.attack(boss);
                } else {
                    hero.remove(i);
                    i--;
                    continue;
                }

                if (!boss.isAlive()) {
                    break;
                } else {
                    boss.attack(participantHero);
                }
            }
        }

        if (boss.isAlive()) {
            sb.append("Boss slain them all");
            boss.levelUp();
        } else {
            sb.append("Boss has been slain by:").append(System.lineSeparator());
            hero.sort(Comparator.comparing(Targetable::getName));
            for (Targetable participant : hero) {
                participant.levelUp();
                participant.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
                sb.append(participant).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
