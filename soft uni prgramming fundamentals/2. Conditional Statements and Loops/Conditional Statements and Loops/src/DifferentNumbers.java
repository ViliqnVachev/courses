import java.util.Scanner;

public class DifferentNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int first = Integer.parseInt(s.nextLine());
        int second = Integer.parseInt(s.nextLine());
        if(first+5>second){
            System.out.println("No");
            return;
        }

        for (int i = first; i <= second - 4; i++) {
            for (int j = first + 1; j <= second - 3; j++) {
                for (int k = first + 2; k <= second - 2; k++) {
                    for (int l = first + 3; l <= second - 1; l++) {
                        for (int m = first + 4; m <= second; m++) {
                            if (i < j && j < k && k < l && l < m) {
                                System.out.printf("%d %d %d %d %d\n",i,j,k,l,m);
                            }
                        }
                    }
                }
            }
        }
    }
}
