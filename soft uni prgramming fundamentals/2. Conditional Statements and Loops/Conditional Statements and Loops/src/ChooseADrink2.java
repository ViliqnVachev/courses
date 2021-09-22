import java.util.Scanner;

public class ChooseADrink2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String profesion = s.nextLine();
        int numberPerson = Integer.parseInt(s.nextLine());

        double watherPrice = 0.70;
        double coffeePrice = 1.00;
        double beerPrice = 1.70;
        double teaPrice = 1.20;

        double price = 0;

        switch (profesion){
            case "Athlete":
                price=numberPerson*watherPrice;
                System.out.printf("The %s has to pay %.2f.",profesion,price);
                break;
            case "Businesswoman":
            case "Businessman":
                price=numberPerson*coffeePrice;
                System.out.printf("The %s has to pay %.2f.",profesion,price);
                break;
            case "SoftUni Student":
                price=numberPerson*beerPrice;
                System.out.printf("The %s has to pay %.2f.",profesion,price);
                break;
            default:
                price=numberPerson*teaPrice;
                System.out.printf("The %s has to pay %.2f.",profesion,price);
                break;
        }
        }
    }

