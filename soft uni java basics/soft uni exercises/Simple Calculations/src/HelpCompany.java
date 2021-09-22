import java.util.Scanner;

public class HelpCompany {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);

        int dni=Integer.parseInt(s.nextLine());
        int sladkari=Integer.parseInt(s.nextLine());
        int torti=Integer.parseInt(s.nextLine());
        int gofreti=Integer.parseInt(s.nextLine());
        int palachinki=Integer.parseInt(s.nextLine());

        double t=torti*45.00;
        double g=gofreti*5.80;
        double p=palachinki*3.20;

        double suma=(t+g+p)*sladkari;
        double campany=suma*dni;
        System.out.printf("%.2f", campany-(0.125*campany));

    }
}
