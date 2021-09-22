package border_control;

public abstract class Population implements Controlable {
    private String name;
    private String id;

    protected Population(String name, String id) {
        this.name = name;
        this.id = id;
    }

    protected String getId() {
        return id;
    }
}
