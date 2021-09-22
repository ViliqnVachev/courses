package exam_prep_01.cells.microbes;

import exam_prep_01.cells.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }


    protected int getVirulence() {
        return virulence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append(String.format("--------Health: %d | Virulence: %d | Energy: %d", super.getHealth(), this.virulence, this.getEnergy()));

        return sb.toString();
    }
}
