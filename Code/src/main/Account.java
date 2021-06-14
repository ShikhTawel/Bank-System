package main;

public class Account {
    private double balance;
    private int accountNumber;
    static int newAccountNumber = 0;

    /**
     * Constructor that initialize the Account's Balance with the passed balanced
     * @param balance
     */
    public Account(double balance) {
        this.balance = balance;
        this.accountNumber = ++newAccountNumber;
    }

    /**
     * Constructor that initialize the Acoount's Balance to Zero
     */
    Account() {
        this.balance = 0;
        this.accountNumber = ++newAccountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Overriding the toString Function to be valid to our Code
     * @return the Acoount's Data
     */
    @Override
    public String toString() {
        String info = "Account type: Normal\n" + "Balance: " + balance + "\nAccount Number: " + accountNumber;
        return info;
    }

    /**
     * Function that Withdraw Passed Amount of money from the Account's Balance
     * The Function Checks if the Value Withdrawn is bigger than the balance then it will return false
     * @param value Money Withdrawn from the Account
     * @return True if the amount of money can be withdrawn
     */
    public boolean withdraw(double value) {
        if (balance >= value && value >= 0) {
            balance -= value;
            return true;
        }
        return false;
    }

    /**
     * Function that Deposits Money to the Account if the Amount of the passed money is bigger than zero
     * @param value Money added to the Account
     * @return True if its not negative
     */
    public boolean deposit(double value) {
        if (value >= 0) {
            balance += value;
            return true;
        }
        return false;
    }
}