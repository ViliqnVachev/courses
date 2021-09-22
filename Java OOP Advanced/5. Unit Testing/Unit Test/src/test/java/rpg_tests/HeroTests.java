package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import rpg_lab.Hero;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTests {
    private static final int WEAPON_ATTACK_POINTS = 10;
    private static final int WEAPON_DURABILITY_POINTS = 10;
    private static final int TARGET_HEALTH = 10;
    private static final int TARGET_XP = 10;
    private static final int EXPECTED_HERO_XP = TARGET_XP;
    private static final String HERO_NAME = "Test";
    private static final String MESSAGE_ERROR = "Wrong Experience";

    private Weapon weapon;
    private Target target;

    /*@Before
    public void initializeObjects() {
        this.weapon = new Weapon() {
            public int getAttackPoints() {
                return WEAPON_ATTACK_POINTS;
            }

            public int getDurabilityPoints() {
                return WEAPON_DURABILITY_POINTS;
            }

            public void attack(Target target) {

            }
        };
        this.target = new Target() {
            public int getHealth() {
                return TARGET_HEALTH;
            }

            public void takeAttack(int attackPoints) {

            }

            public int giveExperience() {
                return TARGET_XP;
            }

            public boolean isDead() {
                return true;
            }
        };
    }*/

    @Test
    public void HeroGainsXPWhenTargetDies() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME,weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals(MESSAGE_ERROR, EXPECTED_HERO_XP, hero.getExperience());

    }
}


