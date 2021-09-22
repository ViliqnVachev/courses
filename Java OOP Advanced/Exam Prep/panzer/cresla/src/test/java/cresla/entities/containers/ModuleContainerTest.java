package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ModuleContainerTest {
    private static final int CAPACITY = 3;

    private Container container;
    private AbsorbingModule absorbingModule1;
    private AbsorbingModule absorbingModule2;
    private EnergyModule energyModule1;
    private EnergyModule energyModule2;

    @Before
    public void setUp() throws Exception {
        this.container = new ModuleContainer(CAPACITY);
        this.absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        this.energyModule1 = Mockito.mock(EnergyModule.class);
        this.energyModule2 = Mockito.mock(EnergyModule.class);

        Mockito.when(this.absorbingModule1.getHeatAbsorbing()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.absorbingModule1.getId()).thenReturn(1);
        Mockito.when(this.absorbingModule2.getHeatAbsorbing()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.absorbingModule2.getId()).thenReturn(2);


        Mockito.when(this.energyModule1.getEnergyOutput()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.energyModule1.getId()).thenReturn(3);
        Mockito.when(this.energyModule2.getEnergyOutput()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(this.energyModule2.getId()).thenReturn(4);
    }

    @Test
    public void addEnergyModule() {
        //Arrange
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule2);

        //Act
        long actual = this.container.getTotalEnergyOutput();
        long expect = 2L * Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expect, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleEx() {
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModuleEx() {
        this.container.addEnergyModule(null);
    }

    @Test
    public void addAbsorbingModule() {
        //Arrange
        this.container.addAbsorbingModule(this.absorbingModule1);
        this.container.addAbsorbingModule(this.absorbingModule2);

        //Act
        long actual = this.container.getTotalHeatAbsorbing();
        long expect = 2L * Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void getTotalEnergyOutput() {
        //Arrange
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule2);

        //Act
        long actual = this.container.getTotalEnergyOutput();
        long expect = 2L * Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void getTotalHeatAbsorbing() {
        //Arrange
        this.container.addAbsorbingModule(this.absorbingModule1);
        this.container.addAbsorbingModule(this.absorbingModule2);

        //Act
        long actual = this.container.getTotalHeatAbsorbing();
        long expect = 2L * Integer.MAX_VALUE;

        //Assert
        Assert.assertEquals(expect, actual);
    }
    @Test
    public void expctRemoveModules(){
        this.container.addAbsorbingModule(this.absorbingModule1);
        this.container.addAbsorbingModule(this.absorbingModule2);
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule2);


        Assert.assertEquals(2L*Integer.MAX_VALUE,this.container.getTotalEnergyOutput());
        Assert.assertEquals(Integer.MAX_VALUE,this.container.getTotalHeatAbsorbing());
    }
    @Test
    public void emtyContainres(){



        Assert.assertEquals(0,this.container.getTotalEnergyOutput());
        Assert.assertEquals(0,this.container.getTotalHeatAbsorbing());
    }
}