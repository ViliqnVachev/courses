package food_shortage;

public class Pet implements Identifiable, Birthtable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getBirthday() {
        return this.birthDate;
    }
}
