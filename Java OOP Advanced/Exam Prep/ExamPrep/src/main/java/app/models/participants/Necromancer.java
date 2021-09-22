package app.models.participants;

import app.models.Config;

public class Necromancer extends BaseHero {

    public Necromancer(String name) {
        super(name, Config.NECROMANCER_BASE_STRENGTH, Config.NECROMANCER_BASE_DEXTERITY, Config.NECROMANCER_BASE_INTELLIGENCE);
    }

    @Override
    public void takeDamage(double damage) {
        super.setHealth(super.getHealth() - damage);
    }

    //o	Necromancer – (Intelligence * 2) + (Dexterity * 2) + (Strength * 2)
    @Override
    public double getDamage() {
        return (super.getIntelligence() * 2) + (super.getDexterity() * 2) + (super.getStrength() * 2);
    }
}
