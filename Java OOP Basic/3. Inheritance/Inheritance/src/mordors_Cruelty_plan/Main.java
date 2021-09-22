package mordors_Cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] foods = reader.readLine().split(" ");
        Food[] foods1 = new Food[foods.length];
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i]);
            foods1[i] = food;
        }

        Mood mood = new Mood(foods1);

        System.out.println(mood);
    }
}
