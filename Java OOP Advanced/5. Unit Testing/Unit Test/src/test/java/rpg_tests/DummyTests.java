package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int EXPECTED_DURABILITY = AXE_ATTACK - 1;
    private static final int EXPECTED_HEALTH_DUMMY = AXE_ATTACK - DUMMY_HEALTH;
    private static final int EXPECTED_XP_DUMMY = DUMMY_EXPERIENCE;
    private static final int ZERO = 0;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {
        this.axe.attack(this.dummy);
        Assert.assertEquals(EXPECTED_HEALTH_DUMMY, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

    @Test
    public void deadDummyCanGiveXP() {
        this.axe.attack(this.dummy);
        Assert.assertEquals(EXPECTED_XP_DUMMY, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveXP() {
        this.dummy.giveExperience();
    }
}
