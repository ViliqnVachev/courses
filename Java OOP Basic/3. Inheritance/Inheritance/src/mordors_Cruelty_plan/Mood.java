package mordors_Cruelty_plan;

public class Mood {
    private static final int cram = 2;
    private static final int lembas = 3;
    private static final int apple = 1;
    private static final int melon = 1;
    private static final int honeyCake = 5;
    private static final int mushrooms = -10;
    private static final int everything = -1;

    private Food[] foods;

    public Mood(Food[] foods) {
        this.foods = foods;
    }

    private int pointsOfHappiness() {
        int pointsOfHappiness = 0;
        for (Food food : foods) {
            switch (food.getName()) {
                case "cram":
                    pointsOfHappiness += cram;
                    break;
                case "lembas":
                    pointsOfHappiness += lembas;
                    break;
                case "apple":
                    pointsOfHappiness += apple;
                    break;
                case "melon":
                    pointsOfHappiness += melon;
                    break;
                case "honeycake":
                    pointsOfHappiness += honeyCake;
                    break;
                case "mushrooms":
                    pointsOfHappiness += mushrooms;
                    break;
                default:
                    pointsOfHappiness += everything;
                    break;
            }
        }

        return pointsOfHappiness;
    }

    private String moodGandolf() {
        int happiness = this.pointsOfHappiness();
        if (happiness < -5) {
            return "Angry";
        } else if (happiness < 0) {
            return "Sad";
        } else if (happiness < 15) {
            return "Happy";
        }
        return "JavaScript";
    }

    @Override
    public String toString() {
        return String.format("%d%n%s", this.pointsOfHappiness(), this.moodGandolf());
    }
}
