package main;

public class SpecialAccount extends Account {
    /**
     * Constructor that sets the Balance
     * @param balance The passed Balance
     */
    public SpecialAccount(double balance) {
        super(balance);
    }
    /**
     * Default Constructor that initialize the Balance with 0
     */
    public SpecialAccount() {
        super();
    }

    /**
     * Overriding the Parent's Withdraw Function to make the client able to loan 1000 from the account
     * @param value Money Withdrawn from the Account
     * @return True if money can be withdrawn, False Otherwise.
     */

    @Override
    public boolean withdraw(double value) {
        if (getBalance() + 1000 >= value && value >= 0) {
            setBalance(getBalance() - value);
            return true;
        }
        return false;
    }

    /**
     * Overriding the toString Function to be valid to our Code
     * @return The Info of this Special Account
     */
    @Override
    public String toString() {
        String info = "Account type: Special\n" + "Balance: " + getBalance() + "\nAccount Number: " + getAccountNumber();
        return info;
    }
}
