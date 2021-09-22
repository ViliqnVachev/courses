import java.util.Scanner;

public class LuckyNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        int firstSum = 0;
        int secondSum = 0;

        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        firstSum = a + b;
                        secondSum = c + d;

                        if (firstSum ==  secondSum ) {
                                if(n%firstSum==0){
                            System.out.printf("%d%d%d%d ", a, b, c, d);
                        }
                        }
                        }
                    }
                }
            }
        }

    }

