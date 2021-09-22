import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int photos = Integer.parseInt(s.nextLine());
        String type =s.nextLine();
        String order =s.nextLine();

        double price1=0.16;
        double price2=0.16;
        double price3=0.38;
        double price4=2.90;
        double fullPrice=0;


        if(type.equals("9X13")){
            if(photos>=50&& order.equals("online")){
                fullPrice=(photos*price1)*(1-0.07);

            }else if (photos<50&& order.equals("online")){
                fullPrice=(photos*price1)*(1-0.02);

            }else if(photos>=50&& order.equals("office")){
                fullPrice=(photos*price1)*(1-0.05);

            }else{
                fullPrice=photos*price1;
            }
        }if(type.equals("10X15")){
            if(photos>=80&& order.equals("online")){
                fullPrice=(photos*price2)*(1-0.05);

            }else if (photos<80&& order.equals("online")){
                fullPrice=(photos*price2)*(1-0.02);

            }else if(photos>=80&& order.equals("office")){
                fullPrice=(photos*price2)*(1-0.03);

            }else{
                fullPrice=photos*price2;
            }
        }if(type.equals("13X18")){
            if((photos>=50 && photos<=100) && order.equals("online")){
                fullPrice=(photos*price3)*(1-0.05);

            }else if(photos>100 && order.equals("online")){
                fullPrice=(photos*price3)*(1-0.07);

            } else if (photos<50&& order.equals("online")){
                fullPrice=(photos*price3)*(1-0.02);

            }else if((photos>=50&& photos<=100) && order.equals("office")){
                fullPrice=(photos*price3)*(1-0.03);

            }else if(photos>100 && order.equals("office")){
                fullPrice=(photos*price3)*(1-0.05);

            }
            else{
                fullPrice=photos*price3;
            }
        }if(type.equals("20X30")){
            if((photos>=10 && photos<=50) && order.equals("online")){
                fullPrice=(photos*price4)*(0.07);
                fullPrice=(photos*price4)*(0.02);

            }else if(photos>50 && order.equals("online")){
                fullPrice=(photos*price4)*(1-0.9);
                fullPrice=(photos*price4)*(1-0.2);

            } else if (photos<10&& order.equals("online")){
                fullPrice=(photos*price4)*(1-0.02);

            }else if((photos>=10&& photos<=50) && order.equals("office")){
                fullPrice=(photos*price4)*(1-0.07);

            }else if(photos>50 && order.equals("office")){
                fullPrice=(photos*price4)*(1-0.09);

            }
            else{
                fullPrice=photos*price4;
            }
        }
        System.out.printf("%.2fBGN",fullPrice);
    }
}
