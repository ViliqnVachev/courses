package cresla.entities.modules;

import cresla.interfaces.Module;

public abstract class BaseModule implements Module {
    private int id;

    protected BaseModule(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder module = new StringBuilder();
        //{moduleType} Module – {moduleId}
        //{additionalParam}: {additionalParamValue}
        module.append(String.format("%s Module - %s", this.getClass().getSimpleName(), this.getId()))
                .append(System.lineSeparator());
        return module.toString();
    }
}
