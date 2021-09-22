import java.util.Scanner;

public class Problem_03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int days = Integer.parseInt(s.nextLine());
        String typeRoom = s.nextLine().toLowerCase();
        String raiting = s.nextLine().toLowerCase();

        int nights = days - 1;

        double room = 18.00;
        double apartment = 25.00;
        double presidentApartment = 35.00;

        double price = 0;

        double discunt=0;
        double discount2=0;

        if (typeRoom.equals("room for one person")) {
            //todo
            if (days < 10) {
                price = nights * room;
                if(raiting.equals("positive")){
                    discount2=(price*25)/100;
                    price=price+discount2;
                }else {
                    discount2=(price*10)/100;
                    price=price-discount2;
                }

            } else if (days >= 10 && days <= 15) {
                price = nights * room;
                if(raiting.equals("positive")){
                    discount2=(price*25)/100;
                    price=price+discount2;
                }else {
                    discount2=(price*10)/100;
                    price=price-discount2;
                }
            } else {
                price = nights * room;
                if(raiting.equals("positive")){
                    discount2=(price*25)/100;
                    price=price+discount2;
                }else {
                    discount2=(price*10)/100;
                    price=price-discount2;
                }
            }


        } else if (typeRoom.equals("apartment")) {

            if (days < 10) {
                discunt=(nights*apartment*30)/100;
                price = nights * apartment-discunt;
                if(raiting.equals("positive")){
                    discount2=(price*25)/100;
                    price=price+discount2;
                }else {
                    discount2=(price*10)/100;
                    price=price-discount2;
                }




            } else if (days >= 10 && days <= 15) {


                discunt=(nights*apartment*35)/100;
                price = nights * apartment-discunt;
                if(raiting.equals("positive")){
                    discount2=(price*25)/100;
                    price=price+discount2;
                }else {
                    discount2=(price*10)/100;
                    price=price-discount2;
                }





            } else {
                discunt=(nights*apartment*50)/100;
                price = nights * apartment-discunt;
                if(raiting.equals("positive")){
                    discount2=(price*25)/100;
                    price=price+discount2;
                }else {
                    discount2=(price*10)/100;
                    price=price-discount2;
                }
            }



        } else if (typeRoom.equals("president apartment")) {
            if (days < 10) {
                discunt=(nights*presidentApartment*100)/100;
                price = nights * presidentApartment-discunt;
                if(raiting.equals("positive")){
                    discount2=(price*25)/100;
                    price=price+discount2;
                }else {
                    discount2=(price*10)/100;
                    price=price-discount2;
                }




            } else if (days >= 10 && days <= 15) {


                discunt=(nights*presidentApartment*15)/100;
                price = nights * presidentApartment-discunt;
                if(raiting.equals("positive")){
                    discount2=(price*25)/100;
                    price=price+discount2;
                }else {
                    discount2=(price*10)/100;
                    price=price-discount2;
                }





            } else {
                discunt=(nights*presidentApartment*20)/100;
                price = nights * presidentApartment-discunt;
                if(raiting.equals("positive")){
                    discount2=(price*25)/100;
                    price=price+discount2;
                }else {
                    discount2=(price*10)/100;
                    price=price-discount2;
                }
            }
        }
        System.out.printf("%.2f",price);
    }
}
