import java.util.Scanner;

public class DNA {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

       String first="";
       String second="";
       String third="";
       String fourth="";

        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {

                    String preSufix = n > i + j + k ? "X" : "O";
                    String firstChar = i == 1 ? "A" : i == 2 ? "C" : i == 3 ? "G" : "T";
                    String secondChar = j == 1 ? "A" : j == 2 ? "C" : j == 3 ? "G" : "T";
                    String thirdChar = k == 1 ? "A" : k == 2 ? "C" : k == 3 ? "G" : "T";

                    if (j >= 1)

                        System.out.print(" ");


                    System.out.print(preSufix + firstChar + secondChar + thirdChar + preSufix);
                    }
                System.out.println();
                }
            }
        }
    }
//System.out.printf("%s%s%s \n", i, j, k);