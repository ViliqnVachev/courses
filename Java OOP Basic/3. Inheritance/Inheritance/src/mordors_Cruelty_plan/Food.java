package mordors_Cruelty_plan;

public class Food {
    private String name;

    public Food(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }
}
