package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class BaseAbsorbingModule extends BaseModule implements AbsorbingModule {
    private int heatAbsorbing;

    protected BaseAbsorbingModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Heat Absorbing: ").append(this.getHeatAbsorbing());
        return sb.toString();
    }
}
