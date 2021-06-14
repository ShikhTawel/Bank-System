package main;

import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    /**
     * Function that displays the main menu and let the Clients Deal with a specific Bank
     * Clients can make a new account or Sign in to their Account
     * If User Chooses to Sign in he will be Sent to the Operation Function
     * @param bank that we will deal with
     */
    public static void menu(Bank bank) {
        String option;
        do {
            System.out.println("==========================================");
            System.out.println("1- Add new Client");
            System.out.println("2- Sign in");
            System.out.println("3- Exit");
            option = in.nextLine();
            int idx = -1;
            if (option.equals("1")) {
                bank.addClient();
            } else if (option.equals("2")) {
                System.out.println("Enter ID: ");
                String id;
                id = in.nextLine();
                idx = bank.signIn(id);
                if (idx == -1) {
                    System.out.println("Client not found");
                    menu(bank);
                    return;
                }
                else
                    bank.operations(idx);
            } else if (!option.equals("3")) {
                System.out.println("***Invalid Option***");
            }
        } while (!option.equals("3"));
    }

    public static void main(String[] args) {
        Bank bank = new Bank("Bank", "0110000000","Egypt");
        menu(bank);
    }
}
