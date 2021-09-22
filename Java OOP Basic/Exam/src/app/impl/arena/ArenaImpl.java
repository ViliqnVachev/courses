package app.impl.arena;

import app.contracts.Arena;
import app.contracts.ComicCharacter;
import app.impl.anti_heroes.AntiHero;
import app.impl.heroes.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArenaImpl implements Arena {
    //•	arenaName – a string
    //•	heroes – a collection that contains the heroes fighting in the current arena
    //•	antiHeroes – a collection that contains the anti heroes fighting in the current arena;
    //•	capacity – an integer that holds the maximum characters that can participate;
    private String arenaName;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;
    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
        this.antiHeroes = new ArrayList<>();
        this.heroes = new ArrayList<>();
    }

    @Override
    public boolean isArenaHasParticipants() {
        if (this.antiHeroes.size() == 0 && this.heroes.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isContainsHero(String nameHero) {
        for (ComicCharacter hero : heroes) {
            if (hero.getName().equals(nameHero)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isContainsAntiHero(String antiHeroName) {
        for (ComicCharacter antiHero : antiHeroes) {
            if (antiHero.getName().equals(antiHeroName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
        if (this.heroes.size() + this.antiHeroes.size() == capacity) {
            return true;
        }
        return false;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.antiHeroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {
        boolean winner = false;

        while (this.heroes.size() != 0 || this.antiHeroes.size() != 0) {
            if (this.heroes.size() >= this.antiHeroes.size()) {
                //first attacked
                for (int i = 0; i < this.antiHeroes.size(); i++) {
                    ComicCharacter antiHero = this.antiHeroes.get(i);
                    ComicCharacter hero = this.heroes.get(i);
                    if(this.heroes.size()<=i){
                        break;
                    }
                    double damage = antiHero.attack();
                    hero.takeDamage(damage);
                }
                this.heroes = this.heroes.stream().filter(h -> h.getHealth() > 0.0).collect(Collectors.toList());

                if (this.heroes.size() == 0) {
                    winner = false;
                    break;
                }

                for (int i = 0; i < this.heroes.size(); i++) {
                    if(this.antiHeroes.size()<=i){
                        break;
                    }
                    ComicCharacter antiHero = this.antiHeroes.get(i);
                    ComicCharacter hero = this.heroes.get(i);
                    double damage = hero.attack();
                    antiHero.takeDamage(damage);
                }
                this.antiHeroes = this.antiHeroes.stream().filter(h -> h.getHealth() > 0.0).collect(Collectors.toList());
                if (this.antiHeroes.size() == 0) {
                    winner = true;
                    break;
                }
            } else {
                for (int i = 0; i < this.heroes.size(); i++) {
                    if (this.antiHeroes.size() <= i) {
                        break;
                    }
                    ComicCharacter antiHero = this.antiHeroes.get(i);
                    ComicCharacter hero = this.heroes.get(i);
                    double damage = hero.attack();
                    antiHero.takeDamage(damage);
                }
                this.antiHeroes = this.antiHeroes.stream().filter(h -> h.getHealth() > 0.0).collect(Collectors.toList());
                if (this.antiHeroes.size() == 0) {
                    winner = true;
                    break;
                }
                for (int i = 0; i < this.antiHeroes.size(); i++) {
                    if (this.heroes.size() <= i) {
                        break;
                    }
                    ComicCharacter antiHero = this.antiHeroes.get(i);
                    ComicCharacter hero = this.heroes.get(i);
                    double damage = antiHero.attack();
                    hero.takeDamage(damage);
                }
                this.heroes = this.heroes.stream().filter(h -> h.getHealth() > 0.0).collect(Collectors.toList());

                if (this.heroes.size() == 0) {
                    winner = false;
                    break;
                }
            }
        }
        return winner;

    }
}
