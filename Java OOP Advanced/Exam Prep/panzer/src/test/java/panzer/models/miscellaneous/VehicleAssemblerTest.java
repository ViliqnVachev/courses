package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VehicleAssemblerTest {

    private Assembler assembler;
    private AttackModifyingPart attackModifyingPart;
    private DefenseModifyingPart defenseModifyingPart;
    private HitPointsModifyingPart hitPointsModifyingPart;

    @Before
    public void setUp() throws Exception {
        this.assembler = new VehicleAssembler();
        this.attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        this.defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
    }

    @Test
    public void getTotalWeight() {
        // Arrange
        Mockito.when(this.attackModifyingPart.getWeight()).thenReturn(20.0);
        Mockito.when(this.defenseModifyingPart.getWeight()).thenReturn(20.0);
        Mockito.when(this.hitPointsModifyingPart.getWeight()).thenReturn(20.0);

        // Act
        this.assembler.addArsenalPart(attackModifyingPart);
        this.assembler.addEndurancePart(hitPointsModifyingPart);
        this.assembler.addShellPart(defenseModifyingPart);

        //Assert
        Assert.assertEquals(60.0, this.assembler.getTotalWeight(), 0.1);
    }

    @Test
    public void getTotalPrice() {
        // Arrange
        Mockito.when(this.attackModifyingPart.getPrice()).thenReturn(BigDecimal.ONE);
        Mockito.when(this.defenseModifyingPart.getPrice()).thenReturn(BigDecimal.TEN);
        Mockito.when(this.hitPointsModifyingPart.getPrice()).thenReturn(BigDecimal.ZERO);

        // Act
        this.assembler.addArsenalPart(attackModifyingPart);
        this.assembler.addEndurancePart(hitPointsModifyingPart);
        this.assembler.addShellPart(defenseModifyingPart);

        BigDecimal actual = this.assembler.getTotalPrice();
        BigDecimal expect = BigDecimal.valueOf(11);

        //Assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void getTotalAttackModification() {
        //Arrange
        AttackModifyingPart mock = Mockito.mock(AttackModifyingPart.class);
        Mockito.when(mock.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.attackModifyingPart.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        // Act
        this.assembler.addArsenalPart(mock);
        this.assembler.addArsenalPart(this.attackModifyingPart);
        long actual = this.assembler.getTotalAttackModification();
        long expect = 2L * Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void getTotalDefenseModification() {
        //Arrange
        DefenseModifyingPart mock = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(mock.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.defenseModifyingPart.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        // Act
        this.assembler.addShellPart(mock);
        this.assembler.addShellPart(this.defenseModifyingPart);
        long actual = this.assembler.getTotalDefenseModification();
        long expect = 2L * Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void getTotalHitPointModification() {
        //Arrange
        HitPointsModifyingPart mock = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(mock.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.hitPointsModifyingPart.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        // Act
        this.assembler.addEndurancePart(mock);
        this.assembler.addEndurancePart(this.hitPointsModifyingPart);
        long actual = this.assembler.getTotalHitPointModification();
        long expect = 2L * Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expect,actual);

    }

    @Test
    public void addArsenalPart() {
        // Arrange
        AttackModifyingPart attack = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addArsenalPart(attack);
        Mockito.when(attack.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.attackModifyingPart.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        this.assembler.addArsenalPart(this.attackModifyingPart);

        // Act
        long actualTotalAttackModification = this.assembler.getTotalAttackModification();
        long expectedTotalAttackModification = (long)Integer.MAX_VALUE+Integer.MAX_VALUE;

        // Assert
        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification);
    }

    @Test
    public void addShellPart() {
        //Arrange
        DefenseModifyingPart mock = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(mock.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.defenseModifyingPart.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        // Act
        this.assembler.addShellPart(mock);
        this.assembler.addShellPart(this.defenseModifyingPart);
        long actual = this.assembler.getTotalDefenseModification();
        long expect = 2L * Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void addEndurancePart() {
        //Arrange
        HitPointsModifyingPart mock = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(mock.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.hitPointsModifyingPart.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        // Act
        this.assembler.addEndurancePart(mock);
        this.assembler.addEndurancePart(this.hitPointsModifyingPart);
        long actual = this.assembler.getTotalHitPointModification();
        long expect = 2L * Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expect,actual);
    }
}