package comp.comp152;

import java.util.ArrayList;

public class TaxExemptCustomer extends Customer {

    public TaxExemptCustomer(String custName) {
        super(custName);
    }

    public double PayForOrder(ArrayList<merchandiseItem> itemsinOrder) {
        return 0;
        //Fix me
    }
}