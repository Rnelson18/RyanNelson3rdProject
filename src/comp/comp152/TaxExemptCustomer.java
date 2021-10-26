package comp.comp152;

import java.util.ArrayList;

public class TaxExemptCustomer extends Customer {

    public TaxExemptCustomer(String custName) {
        super(custName);
    }

    public double PayForOrder(ArrayList<merchandiseItem> itemsinOrder) {
        var sum = 0;
        for(var item: itemsinOrder){
            sum += item.getPrice();
        }
        return sum;

    }
    private String Name;
    public String getName() {
        return Name;
    }

    @Override
    public void arrangeDelivery() {
        System.out.println("Please contact " + Name + " on the day of deliverly.");
    }
}