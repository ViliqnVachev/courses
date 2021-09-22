import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numbers = Integer.parseInt(s.nextLine());
        int[] primesNumber = new int[numbers];
        boolean isPrimesNumber = true;
        long temp = 0;




                for (int j = 2; j < Math.sqrt(numbers); j++) {
                    temp = numbers % j;
                    if (temp == 0) {
                        break;
                    } else {
                        System.out.print(j + " ");
                    }
                }
            }
        }




