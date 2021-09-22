

import java.util.Scanner;

public class VariableInHexFormat {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String hex=s.nextLine();
        hex=hex.substring(2);

        int a = Integer.parseInt(hex,16);

        System.out.println(a);
    }
}