import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String type=s.nextLine().toLowerCase();
        int row=Integer.parseInt(s.nextLine());
        int col=Integer.parseInt(s.nextLine());

        int full=row*col;
        double price=-1;
        double profit=-1;

        if(type.equals("premiere")){
            price=12.00;
            profit=full*price;
        }else if(type.equals("normal")){
            price=7.50;
            profit=full*price;

        }else if(type.equals("discount")){
            price=5.00;
            profit=full*price;
        }
        System.out.printf("%.2f leva",profit);

    }
}
