import java.util.Scanner;

public class ChooseADrink {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String profesion=s.nextLine().toLowerCase();

        switch (profesion){
            case "athlete":
                System.out.println("Water");
                break;
                case "businessman":
                case "businesswoman":
                    System.out.println("Coffee");
                    break;
            case "softuni student":
                System.out.println("Beer");
                break;
                default:
                    System.out.println("Tea");
                    break;
        }
    }
}
