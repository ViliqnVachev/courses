package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

public class OneVsOne implements Action {
    //•	OneVsOne – Two heroes fight to the death. If there are more or less participants you should print the following message: “There should be exactly 2 participants for OneVsOne!”. The combat mechanics are as follows – the first entered hero attacks, then the second one attacks and so on until one of them is dead. When the fight is over, you should print the following message: “{winner name} is victorious!”.


    public String executeAction(List<Targetable> participants) {

        if (participants.size() > 2) {
            return "here should be exactly 2 participants for OneVsOne!";
        }

        StringBuilder sb = new StringBuilder();

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        while (firstHero.isAlive()) {
            sb.append(firstHero.attack(secondHero)).append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero)).append(System.lineSeparator());
            } else {
                break;
            }
        }

        if (firstHero.isAlive()) {
            sb.append(String.format("%s is victorious!%s%s", firstHero.getName(), System.lineSeparator(), firstHero.toString()));
        } else {
            sb.append(String.format("%s is victorious!%s%s", firstHero.getName(), System.lineSeparator(), firstHero.toString()));
        }

        return sb.toString();
    }
}
