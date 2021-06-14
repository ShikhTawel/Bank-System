package main;

public class Client {
    private String name, nationalID, address, phone;
    private Account account;

    /**
     * Constructor that Sets the Client's Data
     * @param name
     * @param nationalID
     * @param address
     * @param phone
     * @param type
     */
    public Client(String name, String nationalID, String address, String phone, String type) {
        this.name = name;
        this.nationalID = nationalID;
        this.address = address;
        this.phone = phone;
        if (type.equalsIgnoreCase("normal"))
            this.account = new Account();
        else
            this.account = new SpecialAccount();
    }

    public String getName() {
        return name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Account getAccount() {
        return account;
    }

    /**
     * Overriding the toString Function to be valid to our Code
     * @return the Client's Info
     */
    @Override
    public String toString() {
        String info = "Client type: Normal\n" + "Name: " + name + "\nNational ID: " + nationalID + "\nAddress: " + address + "\nPhone: " + phone + "\n" + account.toString();
        return info;
    }

    /**
     * Checks if the passed ID is this Client's ID
     * @param id Which we want to Check
     * @return True if its the Client's
     */
    public boolean checkID(String id) {
        if (nationalID.equalsIgnoreCase(id))
            return true;
        return false;
    }
}
