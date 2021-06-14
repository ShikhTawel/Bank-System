package main;

public class CommercialClient extends Client {
    private String commercialID;

    /**
     * Constructor that Sets the Commercial Client's Data
     * @param name
     * @param commercialID
     * @param address
     * @param phone
     * @param type
     */
    public CommercialClient(String name, String commercialID, String address, String phone, String type) {
        super(name, "00000000000000", address, phone, type);
        this.commercialID = commercialID;
    }

    /**
     * Set The Commercial ID
     * @param commercialID
     */
    public void setCommercialID(String commercialID) {
        this.commercialID = commercialID;
    }

    /**
     * Get the Commercial ID
     * @return The Commercial ID
     */
    public String getCommercialID() {
        return commercialID;
    }

    /**
     * Override the toString Function to return the data we want
     * @return the variable that have our Data
     */
    @Override
    public String toString() {
        String info = "Client type: Commercial\n" + "Name: " + getName() + "\nCommercial ID: " + commercialID + "\nAddress: " + getAddress() + "\nPhone: " + getPhone()
                + "\n" + getAccount().toString();
        return info;
    }

    /**
     * Overriding the Parent Check ID Function to Check the Commercial ID
     * @param id Which we want to Check
     * @return True if its the Same ID
     */
    @Override
    public boolean checkID(String id) {
        if (commercialID.equalsIgnoreCase(id))
            return true;
        return false;
    }
}
