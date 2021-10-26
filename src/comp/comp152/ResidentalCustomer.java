package comp.comp152;

import java.util.ArrayList;

public class ResidentalCustomer extends Customer {

    public ResidentalCustomer(String custName) {
        super(custName);
    }

    public double PayForOrder(ArrayList<merchandiseItem> itemsinOrder) {
        var sum = 0;
        for (var item : itemsinOrder) {
            sum += item.getPrice();
        }
        return sum;

    }
}

