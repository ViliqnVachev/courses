package panzer.core;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.parts.Arsenal;
import panzer.models.parts.Endurance;
import panzer.models.parts.Shell;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImp implements Manager {
    private Map<String, Vehicle> vehicles;
    private List<String> defeatedVehicles;
    private List<String> remainingVehicles;
    private Map<String, Part> parts;
    private BattleOperator battleOperator;

    public ManagerImp() {
        this.vehicles = new LinkedHashMap<>();
        this.defeatedVehicles = new ArrayList<>();
        this.remainingVehicles = new ArrayList<>();
        this.parts = new LinkedHashMap<>();
        this.battleOperator = new PanzerBattleOperator();
    }


    //COMPLETE
    @Override
    public String addVehicle(List<String> arguments) {
        Vehicle vehicle = null;
        String type = arguments.get(1);

        switch (type) {
            case "Revenger":
                vehicle = new Revenger(arguments.get(2),
                        Double.parseDouble(arguments.get(3)),
                        new BigDecimal(arguments.get(4)),
                        Integer.parseInt(arguments.get(5)),
                        Integer.parseInt(arguments.get(6)),
                        Integer.parseInt(arguments.get(7)));

                break;

            case "Vanguard":
                vehicle = new Vanguard(arguments.get(2),
                        Double.parseDouble(arguments.get(3)),
                        new BigDecimal(arguments.get(4)),
                        Integer.parseInt(arguments.get(5)),
                        Integer.parseInt(arguments.get(6)),
                        Integer.parseInt(arguments.get(7)));

                break;
        }

        vehicles.put(vehicle.getModel(), vehicle);
        remainingVehicles.add(vehicle.getModel());
        return String.format("Created %s Vehicle - %s", vehicle.getClass().getSimpleName(), vehicle.getModel());
    }

    //COMPLETE
    @Override
    public String addPart(List<String> arguments) {
        Part part = null;
        String type = arguments.get(2);

        switch (type) {
            case "Arsenal":
                part = new Arsenal(arguments.get(3),
                        Integer.parseInt(arguments.get(4)),
                        new BigDecimal(arguments.get(5)),
                        Integer.parseInt(arguments.get(6)));
                vehicles.get(arguments.get(1)).addArsenalPart(part);
                break;

            case "Endurance":
                part = new Endurance(arguments.get(3),
                        Integer.parseInt(arguments.get(4)),
                        new BigDecimal(arguments.get(5)),
                        Integer.parseInt(arguments.get(6)));
                vehicles.get(arguments.get(1)).addEndurancePart(part);
                break;
            case "Shell":
                part = new Shell(arguments.get(3),
                        Integer.parseInt(arguments.get(4)),
                        new BigDecimal(arguments.get(5)),
                        Integer.parseInt(arguments.get(6)));
                vehicles.get(arguments.get(1)).addShellPart(part);
                break;
        }
       this.parts.put(arguments.get(3), part);

        //Added {partType} - {partModel} to Vehicle - {vehicleModel}
        return String.format("Added %s - %s to Vehicle - %s", part.getClass().getSimpleName(), part.getModel(), vehicles.get(arguments.get(1)).getModel());
    }

    //COMPLETE
    @Override
    public String inspect(List<String> arguments) {
        Vehicle vehicle = vehicles.get(arguments.get(1));
        return vehicle.toString();
    }

    //COMPLETE
    @Override
    public String battle(List<String> arguments) {
        Vehicle attacker = vehicles.get(arguments.get(1));
        Vehicle target = vehicles.get(arguments.get(2));

        String winner = this.battleOperator.battle(attacker, target);
        if (winner.equals(attacker.getModel())) {
            this.defeatedVehicles.add(target.getModel());
            this.vehicles.remove(target.getModel());
            this.remainingVehicles.remove(target.getModel());
        } else {
            this.defeatedVehicles.add(attacker.getModel());
            this.vehicles.remove(attacker.getModel());
            this.remainingVehicles.remove(attacker.getModel());

        }
        return String.format("%s versus %s -> %s Wins! Flawless Victory!", attacker.getModel(), target.getModel(), winner);
    }


    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();

        String defeatedVehicles = this.defeatedVehicles.size() == 0 ? "None" : String.join(", ", this.defeatedVehicles);
        String rem = this.remainingVehicles.size() == 0 ? "None" : String.join(", ", this.remainingVehicles);

        sb.append("Remaining Vehicles: ").append(rem)
                .append(System.lineSeparator())
                .append("Defeated Vehicles: ")
                .append(defeatedVehicles)
                .append(System.lineSeparator())
                .append("Currently Used Parts: ").append(this.parts.size());

        return sb.toString();
    }
}
