import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String country = s.nextLine().toLowerCase();

        switch (country){
            case "usa":
                System.out.println("English");
                break;
            case"england":
                System.out.println("English");
                break;
            case "spain":
            case "argentina":
            case "mexico":
                System.out.println("Spanish");
                break;
                default:
                    System.out.println("unknown");
                    break;
        }
    }
}
