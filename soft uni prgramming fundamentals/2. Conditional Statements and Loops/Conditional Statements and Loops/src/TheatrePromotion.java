import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String day =s.nextLine().toLowerCase();
        int age = Integer.parseInt(s.nextLine());
        int price=0;
        if (age<0 || age>122){
            System.out.println("Error!");
            return;

        }
        if(age>=0 && age<=18){
            if(day.equals("weekday")){
                price=12;
            }else if(day.equals("weekend")){
                price=15;
            }else if(day.equals("holiday")){
                price=5;

            }
        }else if(age>18 && age<=64){
            if(day.equals("weekday")){
                price=18;
            }else if(day.equals("weekend")){
                price=20;
            }else if(day.equals("holiday")){
                price=12;

            }
        }else if (age>64&&age<=122){
            if(day.equals("weekday")){
                price=12;
            }else if(day.equals("weekend")){
                price=15;
            }else if(day.equals("holiday")){
                price=10;

            }
        }
        System.out.println(price+"$");
    }
}
