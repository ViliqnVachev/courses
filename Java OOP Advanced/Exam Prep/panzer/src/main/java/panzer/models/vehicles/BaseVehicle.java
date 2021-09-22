package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseVehicle implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler assembler;
    private List<Part> parts;

    protected BaseVehicle(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = new VehicleAssembler();
        this.parts = new ArrayList<>();
    }

    //COMPLETE
    @Override
    public double getTotalWeight() {
        return this.assembler.getTotalWeight() + this.weight;
    }


    //COMPLETE
    @Override
    public BigDecimal getTotalPrice() {
        return this.assembler.getTotalPrice().add(this.price);
    }


    //COMPLETE
    @Override
    public long getTotalAttack() {
        return this.assembler.getTotalAttackModification() + this.attack;
    }


    //COMPLETE
    @Override
    public long getTotalDefense() {
        return this.assembler.getTotalDefenseModification() + this.defense;
    }


    //COMPLETE
    @Override
    public long getTotalHitPoints() {
        return this.assembler.getTotalHitPointModification() + this.hitPoints;
    }


    //COMPLETE
    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
        this.parts.add(arsenalPart);
    }


    //COMPLETE
    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
        this.parts.add(shellPart);
    }


    //COMPLETE
    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
        this.parts.add(endurancePart);
    }

    //COMPLETE
    @Override
    public Iterable<Part> getParts() {
        return Collections.unmodifiableCollection(this.parts);
    }


    //COMPLETE
    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder vehicle = new StringBuilder();
        StringBuilder prats = new StringBuilder();

        if (this.parts.size() > 0) {
            for (int i = 0; i < this.parts.size() - 1; i++) {
                Part temp = this.parts.get(i);
                prats.append(temp.getModel()).append(", ");
            }
            prats.append(this.parts.get(this.parts.size() - 1));
        } else {
            prats.append(" None");
        }

        vehicle.append(String.format("%s - %s", this.getClass().getSimpleName(), this.getModel()))
                .append(System.lineSeparator())
                .append(String.format("Total Weight: %.3f", this.getTotalWeight()))
                .append(System.lineSeparator())
                .append(String.format("Total Price: %.3f", this.getTotalPrice()))
                .append(System.lineSeparator())
                .append(String.format("Attack: %d", this.getTotalAttack()))
                .append(System.lineSeparator())
                .append(String.format("Defense: %d", this.getTotalDefense()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d", this.getTotalHitPoints()))
                .append(System.lineSeparator())
                .append(String.format("Parts: %s", prats.toString()));


        return vehicle.toString();
    }
}
