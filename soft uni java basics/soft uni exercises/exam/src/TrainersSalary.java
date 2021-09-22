import java.util.Scanner;

public class TrainersSalary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lectures=Integer.parseInt(s.nextLine());
        double budget=Double.parseDouble(s.nextLine());

        double pricePerLecture=budget/lectures;

        int count1=0;
        int count2=0;
        int count3=0;
        int count4=0;
        int count5=0;
        int count6=0;

        for (int i = 0; i < lectures; i++) {
            String trainers = s.nextLine().toLowerCase();
            if (trainers.equals("jelev")) {
                count1++;
            } else if (trainers.equals("royal")) {
                count2++;
            } else if (trainers.equals("roli")) {
                count3++;
            } else if (trainers.equals("trofon")) {
                count4++;
            } else if (trainers.equals("sino")) {
                count5++;
            } else {
                count6++;
            }
        }
            System.out.printf("Jelev salary: %.2f lv%n",count1*pricePerLecture);
            System.out.printf("RoYaL salary: %.2f lv%n",count2*pricePerLecture);
            System.out.printf("Roli salary: %.2f lv%n",count3*pricePerLecture);
            System.out.printf("Trofon salary: %.2f lv%n",count4*pricePerLecture);
            System.out.printf("Sino salary: %.2f lv%n",count5*pricePerLecture);
            System.out.printf("Others salary: %.2f lv%n",count6*pricePerLecture);

    }
}
