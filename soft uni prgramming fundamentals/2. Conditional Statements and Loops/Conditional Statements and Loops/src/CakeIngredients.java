import java.util.Scanner;

public class CakeIngredients {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = 0;


        for (int i = 0; i <= 20; i++) {
            String ingredients = s.nextLine();
            if (ingredients.equals("Bake!")) {
                System.out.printf("Preparing cake with %d ingredients.",count);
                return;
            } else {
                System.out.printf("Adding ingredient %s.\n", ingredients);
                count++;
            }
        }
    }
}
