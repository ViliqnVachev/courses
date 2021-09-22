import java.util.Scanner;

public class ExcellentResult {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double ocenka= Double.parseDouble(s.nextLine());

        if(ocenka >=5.50){
            System.out.println("Excellent!");
        }
    }
}
