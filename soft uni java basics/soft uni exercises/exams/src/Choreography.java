import java.util.Scanner;

public class Choreography {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double steps=Integer.parseInt(s.nextLine());
        double dancers=Integer.parseInt(s.nextLine());
        double days=Integer.parseInt(s.nextLine());

        double stpesPerDay=steps/days/steps*100;

        double stepsPerPerson=Math.ceil(stpesPerDay)/dancers;

        if(stpesPerDay<=13){
            System.out.printf("Yes, they will succeed in that goal! %.2f%%.",stepsPerPerson);
        }else{
            System.out.printf("No, They will not succeed in that goal! Required %.2f%% steps to be learned per day.",stepsPerPerson);
        }
    }
}
