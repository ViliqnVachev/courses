package warning_levels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private Importance level;
    private List<Message> messages;

    public Logger(String level) {
        this.level = Enum.valueOf(Importance.class, level.toUpperCase());
        this.messages = new ArrayList<>();
    }

    public void addMessages(Message message) {
        if(message.getLevel().compareTo(level)>=0){
            this.messages.add(message);

        }
    }

    public Iterable<Message> getMessage() {
        return this.messages;
    }
}
