package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;

import java.lang.reflect.Field;
import java.util.List;

public abstract class BaseReactor implements Reactor {


    private int id;
    private Container moduleContainer;

    protected BaseReactor(int id, int moduleCapacity) {
        this.id = id;
        int moduleCapacity1 = moduleCapacity;
        this.moduleContainer = new ModuleContainer(moduleCapacity1);
    }

    protected Container getModuleContainer() {
        return moduleContainer;
    }


    @Override
    public long getTotalEnergyOutput() {
        return 0;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return 0;
    }

    //COMPLETE
    @Override
    public int getModuleCount() {
        List<Module> temp = null;
        try {
            Field field = this.moduleContainer.getClass().getDeclaredField("modulesByInput");
            field.setAccessible(true);
            temp = (List<Module>) field.get(this.moduleContainer);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return temp.size();
    }


    //COMPLETE
    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);

    }


    //COMPLETE
    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder reactor = new StringBuilder();
        //{reactorType} – {reactorId}
        //Energy Output: {energyOutput}
        //Heat Absorbing: {heatAbsorbing}
        //Modules: {moduleCount}

        reactor.append(String.format("%sReactor - %d", this.getClass().getSimpleName(), this.getId()))
                .append(System.lineSeparator())
                .append(String.format("Energy Output: %d", this.getTotalEnergyOutput()))
                .append(System.lineSeparator())
                .append(String.format("Heat Absorbing: %d", this.getTotalHeatAbsorbing()))
                .append(System.lineSeparator())
                .append("Modules: ").append(this.getModuleCount());

        return reactor.toString();
    }
}
