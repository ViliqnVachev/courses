package app.Manager;

import app.contracts.Arena;
import app.contracts.ComicCharacter;
import app.contracts.Manager;
import app.contracts.SuperPower;

import java.util.LinkedHashMap;
import java.util.Map;

public class WarManager implements Manager {

    private Map<String, ComicCharacter> comicCharacters;
    private Map<String, Arena> arenas;
    private Map<String, SuperPower> powers;
    private int battlesHeroesWon;
    private int battlesAntiHeroesWon;

    public WarManager() {
        this.comicCharacters = new LinkedHashMap<>();
        this.arenas = new LinkedHashMap<>();
        this.powers = new LinkedHashMap<>();
        this.battlesHeroesWon = 0;
        this.battlesAntiHeroesWon = 0;
    }


    @Override
    public String checkComicCharacter(String characterName) {
        if (this.comicCharacters.containsKey(characterName)) {
            ComicCharacter character = this.comicCharacters.get(characterName);
            if (character.getHealth() <= 0) {
                return String.format("%s has fallen in battle!", characterName);
            } else {
                return character.toString();
            }
        }
        return String.format("Sorry, fans! %s doesn't exist in our comics!", characterName);
    }


    @Override
    public String addHero(ComicCharacter hero) {
        String nameHero = hero.getName();
        if (!this.comicCharacters.containsKey(nameHero)) {
            this.comicCharacters.put(nameHero, hero);

            return String.format("%s is ready for battle!", nameHero);

        } else {
            ComicCharacter character = this.comicCharacters.get(nameHero);
            int energy = hero.getEnergy();
            double health = hero.getHealth();
            double intelligence = hero.getIntelligence();
            character.boostCharacter(energy, health, intelligence);

            return String.format("%s evolved!", nameHero);
        }
    }


    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        String nameAntiHero = antiHero.getName();
        if (!this.comicCharacters.containsKey(nameAntiHero)) {
            this.comicCharacters.put(nameAntiHero, antiHero);

            return String.format("%s is ready for destruction!", nameAntiHero);

        } else {
            ComicCharacter character = this.comicCharacters.get(nameAntiHero);
            int energy = antiHero.getEnergy();
            double health = antiHero.getHealth();
            double intelligence = antiHero.getIntelligence();
            character.boostCharacter(energy, health, intelligence);

            return String.format("%s is getting stronger!", nameAntiHero);
        }
    }


    @Override
    public String addArena(Arena arena) {
        String arenaName = arena.getArenaName();

        if (!this.arenas.containsKey(arenaName)) {
            this.arenas.put(arenaName, arena);
            return String.format("%s is becoming a fighting ground!", arenaName);
        }
        return "A battle is about to start there!";
    }


    @Override
    public String addHeroToArena(String arena, String hero) {
        Arena currentArena = this.arenas.get(arena);
        ComicCharacter character = this.comicCharacters.get(hero);

        for (Map.Entry<String, Arena> entry : arenas.entrySet()) {
            if (entry.getValue().isContainsHero(hero)) {
                return String.format("%s is fighting!", hero);
            }
        }

        if (character.getHealth() <= 0.0) {
            return String.format("%s is dead!", hero);
        } else if (currentArena.isArenaFull()) {
            return "Arena is full!";
        } else {
            currentArena.addHero(character);
            return String.format("%s is fighting for your freedom in %s!", hero, arena);
        }

    }


    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        Arena currentArena = this.arenas.get(arena);
        ComicCharacter character = this.comicCharacters.get(antiHero);

        if (currentArena.isContainsAntiHero(antiHero)) {
            return String.format("%s is fighting!", antiHero);
        } else if (character.getHealth() <= 0.0) {
            return String.format("%s is dead!", antiHero);
        } else if (currentArena.isArenaFull()) {
            return "Arena is full!";
        } else {
            currentArena.addAntiHero(character);
            return String.format("%s and his colleagues are trying to take over %s!", antiHero, arena);
        }
    }


    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        String poweName = superPower.getName();
        if (!this.powers.containsKey(poweName)) {
            this.powers.put(poweName, superPower);
            return String.format("%s added to pool!", poweName);
        } else {
            return "This super power already exists!";
        }
    }


    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        SuperPower power = this.powers.get(superPower);
        ComicCharacter character = this.comicCharacters.get(comicCharacter);

        for (Map.Entry<String, ComicCharacter> entry : comicCharacters.entrySet()) {
            if (entry.getValue().isContainsSuperPower(superPower)) {
                return String.format("%s already assigned!", superPower);
            }
        }

        character.addSuperPower(power);
        return String.format("%s has a new super power!", comicCharacter);

    }


    @Override
    public String usePowers(String characterName) {
        ComicCharacter character = this.comicCharacters.get(characterName);
        return character.useSuperPowers();
    }

    //check the arena is in tha arenaMaps;
    @Override
    public String startBattle(String arena) {
        Arena arena1 = this.arenas.get(arena);
        this.arenas.remove(arena, arena1);

        if (arena1.isArenaHasParticipants()) {
            return "SAFE ZONE!";
        } else {
            if (arena1.fightHeroes()) {
                this.battlesHeroesWon++;
                return String.format("Heroes won the battle of %s!", arena);
            } else {
                this.battlesAntiHeroesWon++;
                return String.format("Anti Heroes won the battle of %s!", arena);

            }
        }
    }

    //•	IF heroes won battles are more or equal to anti heros, returns message "After <count of all battles> battles our FRIENDLY HEROES WON!"
//•	ELSE  returns message "WE ARE DOOMED!"
    @Override
    public String endWar() {
        if (this.battlesHeroesWon >= this.battlesAntiHeroesWon) {
            return String.format("After %d battles our FRIENDLY HEROES WON!", this.battlesHeroesWon + this.battlesAntiHeroesWon);
        } else {
            return "WE ARE DOOMED!";
        }
    }
}
