package comp.comp152;

import java.util.ArrayList;

public abstract class Customer implements Customers {

    private ArrayList<ShippingAddress> Addresses;
    private String Name;
    private int customerID;
    private static int nextID = 5000;

    public abstract double PayForOrder(ArrayList<merchandiseItem> itemsinOrder);

    public Customer(String Name, int ID) {
        this.Name = Name;
        customerID = ID;
        Addresses = new ArrayList<ShippingAddress>();
    }

    ;

    public Customer(String custName) {
        Name = custName;
        nextID++;
        customerID = nextID;
        Addresses = new ArrayList<ShippingAddress>();
    }

    public ArrayList<ShippingAddress> getAddresses() {

        return new ArrayList<ShippingAddress>(Addresses);
    }

    public String getName() {
        return Name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void addAddress(ShippingAddress newAddress) {
        Addresses.add(newAddress);
    }

    @Override
    public String toString() {
        return "Customer Name: " + Name + "\nCustomerID: " + customerID + "\nWith " + Addresses.size() + " addresses on file";
    }

    public double payOutstandingBalance() {
        return 0;
    }

    @Override
    public void arrangeDelivery() {
        System.out.println(Name + "deliver any time");
    }
}




