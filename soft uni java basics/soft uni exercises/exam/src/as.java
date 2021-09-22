import java.util.Scanner;

public class as {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = Integer.parseInt(s.nextLine()) ;

        int a = number%10;
        number=number/10;
        int b = number%10;
        number=number/10;
        int c = number;

        int result=0;


        for (int i = 1; i <=a ; i++) {
            for (int j = 1; j <=b ; j++) {
                for (int k = 1; k <=c ; k++) {

                    result=i*j*k;

                    System.out.printf("%d * %d * %d = %d;%n",i,j,k,result);
                }
                }
            }

        }

}

