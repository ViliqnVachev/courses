package panzer.models.miscellaneous;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;


public class VehicleAssemblerTest {

    private Assembler assembler;
    private AttackModifyingPart arsenalParts;
    private HitPointsModifyingPart enduranceParts;
    private DefenseModifyingPart shellParts;

    @Before
    public void setUp() throws Exception {
        this.assembler = new VehicleAssembler();
        this.arsenalParts = Mockito.mock(AttackModifyingPart.class);
        this.enduranceParts = Mockito.mock(HitPointsModifyingPart.class);
        this.shellParts = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addArsenalPart(this.arsenalParts);
        this.assembler.addEndurancePart(this.enduranceParts);
        this.assembler.addShellPart(this.shellParts);
    }

    @Test
    public void getTotalWeight() {
        //Arrange
        Mockito.when(this.arsenalParts.getWeight()).thenReturn(20.0);
        Mockito.when(this.enduranceParts.getWeight()).thenReturn(20.0);
        Mockito.when(this.shellParts.getWeight()).thenReturn(20.0);

        //Act
        double actualTotalWeight = this.assembler.getTotalWeight();
        double expectedTotalWeight = 60.0;

        //Assert
        Assert.assertEquals(expectedTotalWeight, actualTotalWeight, 0.1);
    }

    @Test
    public void getTotalPrice() {
        // Arrange
        Mockito.when(this.arsenalParts.getPrice()).thenReturn(BigDecimal.ZERO);
        Mockito.when(this.enduranceParts.getPrice()).thenReturn(BigDecimal.TEN);
        Mockito.when(this.shellParts.getPrice()).thenReturn(BigDecimal.ONE);

        // Act
        BigDecimal actualTotalPrice = this.assembler.getTotalPrice();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(11);

        //Assert
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void getTotalAttackModification() {
        // Assert
        AttackModifyingPart attack = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addArsenalPart(attack);
        Mockito.when(this.arsenalParts.getAttackModifier()).thenReturn(20);
        Mockito.when(attack.getAttackModifier()).thenReturn(20);

        // Act
        long actualTotalAttackModification = this.assembler.getTotalAttackModification();
        long expectedTotalAttackModification = 40;

        // Assert
        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification);
    }

    @Test
    public void getTotalDefenseModification() {
        // Assert
        DefenseModifyingPart shell = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addShellPart(shell);
        Mockito.when(this.shellParts.getDefenseModifier()).thenReturn(20);
        Mockito.when(shell.getDefenseModifier()).thenReturn(20);

        // Act
        long actualTotalDefenseModification = this.assembler.getTotalDefenseModification();
        long expectedTotalDefenseModification = 40;

        // Assert
        Assert.assertEquals(expectedTotalDefenseModification, actualTotalDefenseModification);
    }

    @Test
    public void getTotalHitPointModification() {
        // Assert
        HitPointsModifyingPart hit = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addEndurancePart(hit);
        Mockito.when(this.enduranceParts.getHitPointsModifier()).thenReturn(20);
        Mockito.when(hit.getHitPointsModifier()).thenReturn(20);

        // Act
        long actualTotalHitPointModification = this.assembler.getTotalHitPointModification();
        long expectedTotalHitPointModification = 40;

        // Assert
        Assert.assertEquals(expectedTotalHitPointModification, actualTotalHitPointModification);
    }

    @Test
    public void addArsenalPart() {
        // Arrange
        AttackModifyingPart attack = Mockito.mock(AttackModifyingPart.class);
        this.assembler.addArsenalPart(attack);
        Mockito.when(attack.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.arsenalParts.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        // Act
        long actualTotalAttackModification = this.assembler.getTotalAttackModification();
        long expectedTotalAttackModification = (long)Integer.MAX_VALUE+Integer.MAX_VALUE;

        // Assert
        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification);
    }

    @Test
    public void addShellPart() {
        // Arrange
        DefenseModifyingPart shell = Mockito.mock(DefenseModifyingPart.class);
        this.assembler.addShellPart(shell);
        Mockito.when(shell.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.shellParts.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        // Act
        long actualTotalDefenseModification = this.assembler.getTotalDefenseModification();
        long expectedTotalDefenseModification =(long) Integer.MAX_VALUE+Integer.MAX_VALUE;

        // Assert
        Assert.assertEquals(expectedTotalDefenseModification, actualTotalDefenseModification);
    }

    @Test
    public void addEndurancePart() {
        // Arrange
        HitPointsModifyingPart hit = Mockito.mock(HitPointsModifyingPart.class);
        this.assembler.addEndurancePart(hit);
        Mockito.when(hit.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.enduranceParts.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        // Act
        long actualTotalHitPointModification = (long) this.assembler.getTotalHitPointModification();
        long expectedTotalHitPointModification =(long) Integer.MAX_VALUE+Integer.MAX_VALUE;

        // Assert
        Assert.assertEquals(expectedTotalHitPointModification, actualTotalHitPointModification);
    }
}