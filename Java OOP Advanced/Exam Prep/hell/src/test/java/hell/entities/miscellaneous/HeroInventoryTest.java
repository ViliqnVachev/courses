package hell.entities.miscellaneous;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class HeroInventoryTest {
    private static final int VALUE = Integer.MAX_VALUE;

    private Inventory inventory;

    @Before
    public void setUp() throws Exception {
        this.inventory = new HeroInventory();
    }

    private void initItems() {
        Item item1 = Mockito.mock(Item.class);
        Mockito.when(item1.getName()).thenReturn("item1");
        Mockito.when(item1.getStrengthBonus()).thenReturn(VALUE);
        Mockito.when(item1.getAgilityBonus()).thenReturn(VALUE);
        Mockito.when(item1.getDamageBonus()).thenReturn(VALUE);
        Mockito.when(item1.getHitPointsBonus()).thenReturn(VALUE);
        Mockito.when(item1.getIntelligenceBonus()).thenReturn(VALUE);

        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn("item2");
        Mockito.when(item2.getStrengthBonus()).thenReturn(VALUE);
        Mockito.when(item2.getAgilityBonus()).thenReturn(VALUE);
        Mockito.when(item2.getDamageBonus()).thenReturn(VALUE);
        Mockito.when(item2.getHitPointsBonus()).thenReturn(VALUE);
        Mockito.when(item2.getIntelligenceBonus()).thenReturn(VALUE);
        this.inventory.addCommonItem(item1);
        this.inventory.addCommonItem(item2);
    }

    @Test
    public void getTotalStrengthBonus() {
        // Arrange
        initItems();

        // Act
        long actual = this.inventory.getTotalStrengthBonus();
        long expect = 2L * VALUE;


        // Assert
        Assert.assertEquals(expect, actual);

    }

    @Test
    public void getTotalAgilityBonus() {
        // Arrange
        initItems();

        // Act
        long actual = this.inventory.getTotalAgilityBonus();
        long expect = 2L * VALUE;


        // Assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void getTotalIntelligenceBonus() {
        // Arrange
        initItems();

        // Act
        long actual = this.inventory.getTotalIntelligenceBonus();
        long expect = 2L * VALUE;


        // Assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void getTotalHitPointsBonus() {
        // Arrange
        initItems();

        // Act
        long actual = this.inventory.getTotalHitPointsBonus();
        long expect = 2L * VALUE;


        // Assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void getTotalDamageBonus() {
        // Arrange
        initItems();

        // Act
        long actual = this.inventory.getTotalDamageBonus();
        long expect = 2L * VALUE;


        // Assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void addCommonItem() {
    }

    @Test
    public void addRecipeItem() {
    }
}