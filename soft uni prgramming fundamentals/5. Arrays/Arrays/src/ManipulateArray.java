import java.util.Scanner;

public class ManipulateArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] arr = s.nextLine().split(" ");
        int allComands = Integer.parseInt(s.nextLine());
        String [] revers;
        String [] distinct;

        for (int i = 0; i < allComands; i++) {
            String comand = s.nextLine();
            switch (comand) {

                case "Reverse":
                    for (int reversIndex = 0; reversIndex < arr.length; reversIndex++) {

                    }
                    break;






                case "Distinct":
                    int position=0;
                    for (int index   = 0; index < arr.length; index++) {
                        int next=i+1;
                        if(next==arr.length-1){
                            break;
                        }
                            if(arr[index].equals(arr[next])){


                        }

                    }
                    break;



                case "Replace":
                    break;
            }
        }

    }
}
