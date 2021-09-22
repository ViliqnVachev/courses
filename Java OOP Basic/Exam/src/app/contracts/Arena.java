package app.contracts;

public interface Arena {
    boolean isArenaHasParticipants();

    boolean isContainsHero(String nameHero);

    boolean isContainsAntiHero(String antiHeroName);

    String getArenaName();

    boolean isArenaFull();

    void addHero(ComicCharacter hero);

    void addAntiHero(ComicCharacter antiHero);

    boolean fightHeroes();

}
