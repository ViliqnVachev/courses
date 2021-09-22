package border_control;

public class Robot extends Population {


    protected Robot(String model, String id) {
        super(model, id);
    }


    @Override
    public boolean getFakeId(String lastDigits) {
        if (super.getId().endsWith(lastDigits)) {
            return true;
        }
        return false;
    }
}
