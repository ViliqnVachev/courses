package app;

import app.Manager.WarManager;
import app.contracts.Arena;
import app.contracts.ComicCharacter;
import app.contracts.Manager;
import app.contracts.SuperPower;
import app.impl.anti_heroes.Titan;
import app.impl.anti_heroes.Villain;
import app.impl.arena.ArenaImpl;
import app.impl.heroes.DCHero;
import app.impl.heroes.MarvelHero;
import app.impl.power.Power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        Manager manager = new WarManager();

        while (!"WAR_IS_OVER".equals(line)) {
            String[] tokens = line.split("\\s+");

            String command = tokens[0];
            String characterName;
            String arenaName;
            String powerName;

            switch (command) {
                case "CHECK_CHARACTER":
                    characterName = tokens[1];

                    System.out.println(manager.checkComicCharacter(characterName));
                    break;

                case "REGISTER_HERO":
                    characterName = tokens[1];
                    String characterType = tokens[2];
                    int energy = Integer.parseInt(tokens[3]);
                    double health = Double.parseDouble(tokens[4]);
                    double intelligence = Double.parseDouble(tokens[5]);
                    double heroism = Double.parseDouble(tokens[6]);
                    ComicCharacter character = null;

                    try {
                        if (characterType.equals("MarvelHero")) {
                            character = new MarvelHero(characterName, energy, health, intelligence, heroism);
                        } else {
                            character = new DCHero(characterName, energy, health, intelligence, heroism);
                        }
                        System.out.println(manager.addHero(character));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "REGISTER_ANTI_HERO":
                    characterName = tokens[1];
                    String characterTypeA = tokens[2];
                    int energyAnti = Integer.parseInt(tokens[3]);
                    double healthAnti = Double.parseDouble(tokens[4]);
                    double intelligenceAnti = Double.parseDouble(tokens[5]);
                    double evilness = Double.parseDouble(tokens[6]);
                    ComicCharacter antiCharacter = null;

                    try {
                        if (characterTypeA.equals("Titan")) {
                            antiCharacter = new Titan(characterName, energyAnti, healthAnti, intelligenceAnti, evilness);
                        } else {
                            antiCharacter = new Villain(characterName, energyAnti, healthAnti, intelligenceAnti, evilness);

                        }
                        System.out.println(manager.addAntiHero(antiCharacter));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "BUILD_ARENA":
                    arenaName = tokens[1];
                    int capacity = Integer.parseInt(tokens[2]);

                    Arena arena = new ArenaImpl(arenaName, capacity);

                    System.out.println(manager.addArena(arena));
                    break;

                case "SEND_HERO":
                    arenaName = tokens[1];
                    characterName = tokens[2];

                    System.out.println(manager.addHeroToArena(arenaName, characterName));
                    break;

                case "SEND_ANTI_HERO":
                    arenaName = tokens[1];
                    characterName = tokens[2];

                    System.out.println(manager.addAntiHeroToArena(arenaName, characterName));
                    break;

                case "SUPER_POWER":
                    powerName = tokens[1];
                    double points = Double.parseDouble(tokens[2]);

                    try {
                        SuperPower superPower = new Power(powerName, points);
                        System.out.println(manager.loadSuperPowerToPool(superPower));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "ASSIGN_POWER":
                    characterName = tokens[1];
                    powerName = tokens[2];

                    System.out.println(manager.assignSuperPowerToComicCharacter(characterName, powerName));
                    break;

                case "UNLEASH":
                    characterName = tokens[1];

                    System.out.println(manager.usePowers(characterName));
                    break;

                case "COMICS_WAR":
                    arenaName = tokens[1];
                    System.out.println(manager.startBattle(arenaName));
                    break;
            }

            line = reader.readLine();
        }

        System.out.println(manager.endWar());


    }
}
