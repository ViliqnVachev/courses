import java.util.Scanner;

public class CaloriesCounter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String products = "";
        int cheesCalories = 500;
        int tomateoSouceCalories = 150;
        int salamiCalories = 600;
        int pepperlories = 50;
        int totalCalories = 0;

        if (n <= 20) {
            for (int i = 0; i < n; i++) {
                products = s.nextLine().toLowerCase();
                switch (products) {
                    case "cheese":
                        totalCalories = totalCalories + cheesCalories;
                        break;
                    case "tomato sauce":
                        totalCalories = totalCalories + tomateoSouceCalories;
                        break;
                    case "salami":
                        totalCalories = totalCalories + salamiCalories;
                        break;
                    case "pepper":
                        totalCalories = totalCalories + pepperlories;
                        break;
                }
            }
        }
        System.out.println("Total calories: "+totalCalories);
    }
}
