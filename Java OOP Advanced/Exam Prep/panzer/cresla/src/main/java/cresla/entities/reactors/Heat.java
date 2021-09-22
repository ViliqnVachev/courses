package cresla.entities.reactors;

public class Heat extends BaseReactor {
    private int heatReductionIndex;

    public Heat(int id, int heatReductionIndex, int moduleCapacity) {
        super(id, moduleCapacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    //COMPLETE
    @Override
    public long getTotalEnergyOutput() {
        long result = super.getModuleContainer().getTotalEnergyOutput();
        if (result > this.getTotalHeatAbsorbing()) {
            return 0;
        }
        return result;
    }


    //COMPLETE
    @Override
    public long getTotalHeatAbsorbing() {
        return super.getModuleContainer().getTotalHeatAbsorbing()+this.heatReductionIndex;
    }

}
