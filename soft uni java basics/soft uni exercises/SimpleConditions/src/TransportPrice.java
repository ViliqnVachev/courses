import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int km=Integer.parseInt(s.nextLine());
        String time=s.nextLine();

        double price=0;
        if(time.equals("day")&&km<20){
            price=0.70+(km*0.79);
        }else if(time.equals("night")&&km<20) {
            price=0.70+(km*0.90);
        }
        if(km>=20){
            price=km*0.09;
        }if(km>=100){
            price=km*0.06;
        }
        System.out.println(price);
    }
}
