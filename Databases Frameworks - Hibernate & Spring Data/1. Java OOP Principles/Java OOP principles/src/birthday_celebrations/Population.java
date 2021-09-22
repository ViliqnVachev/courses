package birthday_celebrations;

public abstract class Population implements Contollable {
    private String name;
    private String id;


    protected Population(String name, String id) {
        this.name = name;
        this.id = id;
    }

    protected String getId() {
        return id;
    }



    @Override
    public boolean getFakeId(String lastDigit) {
        if (this.getId().endsWith(lastDigit)) {
            return true;
        }
        return false;
    }
}
