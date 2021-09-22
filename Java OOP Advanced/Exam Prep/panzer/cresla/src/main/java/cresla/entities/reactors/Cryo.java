package cresla.entities.reactors;

public class Cryo extends BaseReactor {
    private int cryoProductionIndex;

    public Cryo(int id, int cryoProductionIndex, int moduleCapacity) {
        super(id, moduleCapacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    //COMPLETE
    @Override
    public long getTotalEnergyOutput() {
        long result = super.getModuleContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
        if (result > this.getTotalHeatAbsorbing()) {
            return 0;
        }
        return result;
    }


    //COMPLETE
    @Override
    public long getTotalHeatAbsorbing() {
        return super.getModuleContainer().getTotalHeatAbsorbing();
    }

}
