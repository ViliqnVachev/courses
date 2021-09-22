package football_team_generator;

import java.util.Objects;

public class Player {
    private String name;
    private Stats stats;

    public Player(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ConfigExMessage.INVALID_NAME_EX_MESSAGE);
        }
        this.name = name;
    }


    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
