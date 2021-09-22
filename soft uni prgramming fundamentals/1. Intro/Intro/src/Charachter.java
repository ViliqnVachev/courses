import java.util.Scanner;

public class Charachter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        int health=Integer.parseInt(s.nextLine());
        int healthmax=Integer.parseInt(s.nextLine());
        int energy=Integer.parseInt(s.nextLine());
        int energymax=Integer.parseInt(s.nextLine());

        System.out.println("Name: "+name);
        System.out.print("Health: ");
        System.out.print(repaeatStr("|",health+1));
        System.out.print(repaeatStr(".",healthmax-health));
        System.out.println("|");
        System.out.print("Energy: ");
        System.out.print(repaeatStr("|",energy+1));
        System.out.print(repaeatStr(".",energymax-energy));
        System.out.println("|");
    }
    public static String repaeatStr(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
