import java.util.Scanner;

public class problem_06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int begin = Integer.parseInt(s.nextLine());
        int end = Integer.parseInt(s.nextLine());

        int a = begin / 1000;
        begin = begin % 1000;
        int b = begin / 100;
        begin = begin % 100;
        int c = begin / 10;
        begin = begin % 10;
        int d = begin;

        int a2 = end / 1000;
        end = end % 1000;
        int b2 = end / 100;
        end = end % 100;
        int c2 = end / 10;
        end = end % 10;
        int d2 = end;

    /*    int q = 0;
        int w = 0;
        int r = 0;
        int t = 0;*/

        for (int row = a; row <= a2; row++) {
            for (int i = b; i <= b2; i++) {
                for (int j = c; j <= c2; j++) {
                    for (int k = d; k <=d2; k++) {
                        if (row % 2 != 0 && i % 2 != 0 && j % 2 != 0 && k % 2 != 0){
                            System.out.printf("%d%d%d%d ",row,i,j,k);
                        }

                    }

                }

            }
        }





    }
}
