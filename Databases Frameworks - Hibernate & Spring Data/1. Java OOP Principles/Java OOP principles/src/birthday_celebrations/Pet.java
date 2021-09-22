package birthday_celebrations;

public class Pet implements Birthtable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthdate() {
        return this.birthDate;
    }
}
