package border_control;

public class Human extends Population {

    protected Human(String name, String id) {
        super(name, id);
    }

    @Override
    public boolean getFakeId(String lastDigit) {
        if (super.getId().endsWith(lastDigit)) {
            return true;
        }
        return false;
    }
}
