package warning_levels;

public class Message {

    private Importance level;
    private String message;

    public Message(String level, String message) {
        this.level = Enum.valueOf(Importance.class, level);
        this.message = message;
    }

    public Importance getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return this.getLevel() + ": " + this.message;
    }
}
