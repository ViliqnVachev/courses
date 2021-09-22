package constructors;

import define_bank_account.BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, BankAccount> accounts = new HashMap<>();

        String line = reader.readLine();

        while (!"End".equals(line)) {
            String command = line.split(" ")[0];
            //

            switch (command) {
                case "Create":
                    BankAccount ba = new BankAccount();
                    accounts.put(ba.getId(), ba);
                    System.out.println("Account ID" + ba.getId() + " created");
                    break;
                case "Deposit":
                    DecimalFormat df = new DecimalFormat("###.##");
                    int id = Integer.parseInt(line.split(" ")[1]);
                    if (!accounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount acc = accounts.get(id);
                        double amount = Double.parseDouble(line.split(" ")[2]);
                        acc.deposit(amount);
                        System.out.printf("Deposited %s to ID%d%n", df.format(amount), acc.getId());
                    }
                    break;
                case "GetInterest":
                    id = Integer.parseInt(line.split(" ")[1]);
                    if (!accounts.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        int years = Integer.parseInt(line.split(" ")[2]);
                        System.out.printf("%.2f%n", accounts.get(id).getInterest(years));
                    }

                    break;
                case "SetInterest":
                    BankAccount.setInterest(Double.parseDouble(line.split(" ")[1]));

                    break;

            }

            line = reader.readLine();
        }

    }
}
