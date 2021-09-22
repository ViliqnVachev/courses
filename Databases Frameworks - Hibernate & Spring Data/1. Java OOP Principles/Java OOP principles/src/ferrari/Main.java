package ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String driverName=reader.readLine();
        Vechicle ferrari=new Ferrari(driverName);

        System.out.printf("%s/%s/%s/%s",ferrari.getModel(), ferrari.useBreaks(),ferrari.useGas(),ferrari.getDriverName());

    }
}
