package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class WarriorTest {
    private Hero warrior;

    @Before
    public void init() {
        this.warrior = new Warrior();
    }

    @Test
    public void takeDamage() {
        //act
        this.warrior.takeDamage(20d);
        double actualHealth = this.warrior.getHealth();
        double expectHealth = 30.0;
        //assert
        Assert.assertEquals(expectHealth, actualHealth, 1);
    }

    @Test
    public void testIsAlive() {
        //act
        this.warrior.isAlive();


        //assert
        Assert.assertTrue(this.warrior.isAlive());
    }

    @Test
    public void levelUpDoublesDexterity() {
        //act
        this.warrior.levelUp();


        //assert
        Assert.assertEquals(Config.WARRIOR_BASE_DEXTERITY * 2, this.warrior.getDexterity());


    }

    @Test
    public void levelUpDoubleStrength() {
        //act
        this.warrior.levelUp();

        //assert
        Assert.assertEquals(Config.WARRIOR_BASE_STRENGTH * 2, this.warrior.getStrength());
    }

    @Test
    public void levelUpDoubleIntelligence() {
        //act
        this.warrior.levelUp();

        //assert
        Assert.assertEquals(Config.WARRIOR_BASE_INTELLIGENCE * 2, this.warrior.getIntelligence());
    }

    @Test
    public void levelUpHealthMax() {
        //act
        this.warrior.levelUp();

        //assert
        Assert.assertEquals(100d, this.warrior.getHealth(), 0.1);
    }

     @Test
     public void giveReward() {
         double reward = this.warrior.getGold();

         Targetable mockTarget = Mockito.mock(Targetable.class);



         this.warrior.giveReward(mockTarget);

         Mockito.verify(mockTarget);

        // Assert.assertEquals(reward,mockTarget.getGold(),0.0);
     }
    @Test
    public void receiveReward() {
        double receiveReward = 20d;
        this.warrior.receiveReward(receiveReward);

        Assert.assertEquals(Config.HERO_START_GOLD + receiveReward, this.warrior.getGold(), 0.0);
    }
}