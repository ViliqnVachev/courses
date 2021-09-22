package extended_database;

public class People {
    private String username;
    private long Id;

    public People(String username, long id) {
        this.username = username;
        this.Id = id;
    }

    public String getUsername() {
        return username;
    }

    public long getId() {
        return Id;
    }
}
