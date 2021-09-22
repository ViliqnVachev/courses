import java.util.Scanner;

public class CharacterStats {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        int currentHealth=Integer.parseInt(s.nextLine());
        int maxHealth=Integer.parseInt(s.nextLine());
        int currentEnergy=Integer.parseInt(s.nextLine());
        int maxEnergy=Integer.parseInt(s.nextLine());

        System.out.println("Name: "+name);
        System.out.print("Health: ");
        for (int i = 0; i < currentHealth+1; i++) {
            System.out.print("|");

        }

        for (int i = 0; i < maxHealth-currentHealth; i++) {
            System.out.print(".");
        }
        System.out.println("|");
        System.out.print("Energy: ");
        for (int i = 0; i < currentEnergy+1; i++) {
            System.out.print("|");

        }

        for (int i = 0; i < maxEnergy-currentEnergy; i++) {
            System.out.print(".");
        }
        System.out.println("|");
    }
    }


