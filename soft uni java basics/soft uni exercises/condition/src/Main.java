import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double age = Double.parseDouble(s.nextLine());
        String gender = s.nextLine().toLowerCase();

        if (age < 16) {
            if (gender.equals("m")) {
                System.out.println("Master");
            } else if (gender.equals("f")) {
                System.out.println("Miss");
            }
        }else {
                if (gender.equals("m")) {
                    System.out.println("Mr.");
                }else if (gender.equals("f")) {
                    System.out.println("Ms.");
                }
            }
        }
    }

