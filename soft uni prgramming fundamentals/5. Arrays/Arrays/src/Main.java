import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfDay=Integer.parseInt(s.nextLine());
        String [] namesDays= new String[7];
        namesDays[0]="Monday";
        namesDays[1]="Tuesday";
        namesDays[2]="Wednesday";
        namesDays[3]="Thursday";
        namesDays[4]="Friday";
        namesDays[5]="Saturday";
        namesDays[6]="Sunday";

        if(numberOfDay>0 && numberOfDay<=7){

            System.out.println(namesDays[numberOfDay-1]);
        }else{
            System.out.println("Invalid Day!");
        }
    }
}
