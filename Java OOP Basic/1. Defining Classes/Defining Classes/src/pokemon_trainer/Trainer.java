package pokemon_trainer;

import java.util.List;

public class Trainer {
    private static final int DEFAULT_NUMBER_OF_BADGES = 0;
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
        this.numberOfBadges = DEFAULT_NUMBER_OF_BADGES;
    }

    public boolean isPokemonGetElement(String element) {

        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public void changedHealthOfPokemons() {
        for (int i = 0; i < this.pokemons.size(); i++) {
            Pokemon pokemon = this.pokemons.get(i);
            int health = pokemon.getHealth() - 10;
            if (health <= 0) {
                this.pokemons.remove(i);
                i--;
            }
            pokemon.setHealth(health);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}
