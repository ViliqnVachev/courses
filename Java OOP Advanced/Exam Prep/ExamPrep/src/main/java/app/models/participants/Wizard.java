package app.models.participants;

import app.models.Config;

public class Wizard extends BaseHero {

    public Wizard(String name) {
        super(name, Config.WIZARD_BASE_STRENGTH, Config.WIZARD_BASE_DEXTERITY, Config.WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public void takeDamage(double damage) {
        super.setHealth(super.getHealth() - damage);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 5) + super.getDexterity();
    }
}
