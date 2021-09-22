package cresla.entities.containers;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.Cryo;
import cresla.entities.reactors.Heat;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private static final int START_ID = 1;

    private Map<Integer, Reactor> reactors;
    private List<Reactor> listReactors;
    private List<Module> modules;
    private int id;


    public ManagerImpl() {
        this.reactors = new LinkedHashMap<>();
        this.listReactors = new ArrayList<>();
        this.modules = new ArrayList<>();
        this.id = START_ID;

    }


    @Override
    public String reactorCommand(List<String> arguments) {
        //Parameters – type (string), additionalParameter (int), moduleCapacity (int).
        //Creates a Reactor of the given type, with the next id.
        //The type will either be “Cryo” or “Heat”.
        //Depending on the type, the additionalParameter will be set to either cryoProductionIndex or heatAbsorbing.
        //The moduleCapacity is set to the ModuleContainer of the Reactor.
        //•	Reactor {reactorType} {additionalParameter} {moduleCapacity}
        Reactor reactor = null;

        String typeReactor = arguments.get(1);


        switch (typeReactor) {
            case "Cryo":
                reactor = new Cryo(this.id++, Integer.parseInt(arguments.get(2)), Integer.parseInt(arguments.get(3)));

                break;
            case "Heat":
                reactor = new Heat(this.id++, Integer.parseInt(arguments.get(2)), Integer.parseInt(arguments.get(3)));
                break;
        }
        this.listReactors.add(reactor);
        return String.format("Created %s Reactor - %d", reactor.getClass().getSimpleName(), reactor.getId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        //Parameters – reactorId (int), type (string), additionalParameter (int).
        //Creates a Module of the given type with the next id and adds it to the ModuleContainer of the Reactor with the given reactorId.
        //The type will either be “CryogenRod”, “HeatProcessor” or “CoolingSystem”.
        //Depending on the Module type, the additionalParameter will be set to a different property:
        //•	If it’s a CryogenRod the additionalParameter will be set ot the energyOutput.
        //•	If it’s a CooldownSystem the additionalParameter will be set ot the heatAbsorbing.
        //•	If it’s a HeatProcessor the additionalParameter will be set ot the heatAbsorbing.
        //•	Module {reactorId} {type} {additionalParameter}


        int idReactor = Integer.parseInt(arguments.get(1));
        Reactor reactor = null;
        for (Reactor reactor1 : this.listReactors) {
            if (idReactor == reactor1.getId()) {
                reactor = reactor1;
            }
        }
        Module module = null;
        String typeModule = arguments.get(2);
        switch (typeModule) {
            case "CryogenRod":
                module = new CryogenRod(this.id++, Integer.parseInt(arguments.get(3)));
                reactor.addEnergyModule((EnergyModule) module);
                break;
            case "HeatProcessor":
                module = new HeatProcessor(this.id++, Integer.parseInt(arguments.get(3)));
                reactor.addAbsorbingModule((AbsorbingModule) module);
                break;
            case "CooldownSystem":
                module = new CooldownSystem(this.id++, Integer.parseInt(arguments.get(3)));
                reactor.addAbsorbingModule((AbsorbingModule) module);
                break;
        }
        this.modules.add(module);

//Added {moduleType} - {moduleId} to Reactor - {reactorId}
        return String.format("Added %s - %d to Reactor - %d", module.getClass().getSimpleName(), module.getId(), reactor.getId());
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(1));

        for (Reactor listReactor : listReactors) {
            if (id == listReactor.getId()) {
                return listReactor.toString();
            }
        }
        for (Module module : modules) {
            if (id == module.getId()) {
                return module.toString();
            }
        }
        return null;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        //Cryo Reactors: 2
        //Heat Reactors: 0
        //Energy Modules: 5
        //Absorbing Modules: 1
        //Total Energy Output: 4000
        //Total Heat Absorbing: 10000
        int cryoReactors = 0;
        int heatReactors = 0;
        for (Reactor listReactor : this.listReactors) {
            if (listReactor.getClass().getSimpleName().equals("Cryo")) {
                cryoReactors++;
            } else {
                heatReactors++;
            }
        }

        int energyModuls = 0;
        int absorModuls = 0;

        for (Module module : modules) {
            if (module.getClass().getSimpleName().equals("CryogenRod")) {
                energyModuls++;
            } else {
                absorModuls++;
            }
        }

        long energy = this.listReactors.stream().mapToLong(Reactor::getTotalEnergyOutput).sum();
        long abs = this.listReactors.stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum();

        sb.append(String.format("Cryo Reactors: %d", cryoReactors))
                .append(System.lineSeparator())
                .append(String.format("Heat Reactors: %d", heatReactors))
                .append(System.lineSeparator())
                .append(String.format("Energy Modules: %d", energyModuls))
                .append(System.lineSeparator())
                .append(String.format("Absorbing Modules: %d", absorModuls))
                .append(System.lineSeparator())
                .append(String.format("Total Energy Output: %d",energy))
                .append(System.lineSeparator())
                .append(String.format("Total Heat Absorbing: %d",abs));

        return sb.toString();
    }
}
