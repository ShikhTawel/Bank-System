package main;

import java.util.*;

public class Bank {

    private String Name, phone,address;
    private ArrayList<Client> clients;
    private ArrayList<Account> accounts;

    /**
     * Constructor that takes two parameters which are The Bank Name and Phone
     * @param name
     * @param phone
     */
    public Bank(String name, String phone,String address) {
        Name = name;
        this.phone = phone;
        this.address = address;
        clients = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    /**
     * Set the Bank's Name
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Sets the Bank's Phone
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the Bank Name
     * @return The Bank Name
     */
    public String getName() {
        return Name;
    }

    /**
     * Gets the Bank's Phone
     * @return Phone Number of the Bank
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Function that gets the Bank's Clients
     * @return Clients of the bank
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * Function that gets the Bank's Accounts
     * @return Accounts of the bank
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * Function that adds new Clients to the Bank ..
     * The Function Checks if the Clients is Commercial or Normal Client
     * The Function Checks if the Account is Special or Normal Account
     */
    public void addClient() {
        System.out.print("Enter the type of Client (Commercial or Normal): ");
        Scanner in = new Scanner(System.in);
        String clientType = in.nextLine();

        while (!clientType.equalsIgnoreCase("commercial") && !clientType.equalsIgnoreCase("normal")) {
            System.out.println("Invalid Input");
            System.out.println("Enter the type of Client (Commercial or Normal): ");
            clientType = in.nextLine();
        }
        String name, ID, address, phone;
        System.out.print("Enter Name: ");
        name = in.nextLine();
        System.out.print("Address: ");
        address = in.nextLine();
        System.out.print("Phone: ");
        phone = in.nextLine();
        if (clientType.equalsIgnoreCase("normal")) {
            System.out.print("Enter National ID: ");
            ID = in.nextLine();
        } else {
            System.out.print("Enter Commercial ID: ");
            ID = in.nextLine();
        }
        System.out.print("Enter the type of Account (Special or Normal): ");
        String accountType = in.nextLine();

        while (!accountType.equalsIgnoreCase("special") && !accountType.equalsIgnoreCase("normal")) {
            System.out.println("Invalid Input");
            System.out.println("Enter the type of Account (Special or Normal): ");
            accountType = in.nextLine();
        }
        if (clientType.equalsIgnoreCase("normal")) {
            clients.add(new Client(name, ID, address, phone, accountType.toLowerCase()));
        } else {
            clients.add(new CommercialClient(name, ID, address, phone, accountType.toLowerCase()));
        }
        accounts.add(clients.get(clients.size() - 1).getAccount());
        System.out.println("Client Added Successfully");
    }

    /**
     * Function the Displays All Bank's Clients and their Accounts using toString()
     */
    public void display() {
        System.out.println("Clients: ");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i).toString());
            System.out.print("Account: ");
            System.out.println(accounts.get(i).toString());
        }
    }

    /**
     * Function that Sign in the user by searching for his ID in the system and compare it to the IDs by the Function checkID until the ID is found
     * @param id which is the User's ID used in signing in
     * @return the index of the required ID in the system
     */
    public int signIn(String id) {
        for (int i = 0; i < getClients().size(); i++) {
            if (getClients().get(i).checkID(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Function that preform The required operations on the Signed in User
     * @param idx the index that was given from the sign in function
     */
    public void operations(int idx) {

        String cond;
        do {
            System.out.println("-----------------------------------------");
            System.out.println("1- Display Client Info");
            System.out.println("2- Deposit");
            System.out.println("3- Withdraw");
            String option;
            Scanner in = new Scanner(System.in);
            option = in.nextLine();
            if (option.equals("1")) {
                System.out.println(clients.get(idx).toString());
            } else if (option.equals("2")) {
                System.out.print("Enter value to deposit: ");
                double value;
                value = in.nextDouble();
                in.skip("\n");
                if (clients.get(idx).getAccount().deposit(value)) {
                    System.out.println("Deposited " + value + " successfully");
                } else {
                    System.out.println("Deposit value is invalid");
                }
            } else if (option.equals("3")) {
                System.out.println("Enter value to withdraw");
                double value;
                value = in.nextDouble();
                in.skip("\n");
                if (clients.get(idx).getAccount().withdraw(value)) {
                    System.out.println("Withdrew " + value + " successfully");
                } else {
                    System.out.println("Value could not be withdrawn");
                }
            } else {
                System.out.println("***Invalid Option***");
            }
            System.out.println("Do you want to do another operation (Y/N)");
            cond = in.nextLine();
            while (!cond.equalsIgnoreCase("Y") && !cond.equalsIgnoreCase("N")) {
                System.out.println("***Enter valid option***");
                cond = in.nextLine();
            }
        } while (cond.equalsIgnoreCase("Y"));
    }
}