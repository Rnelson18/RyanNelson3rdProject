package comp.comp152;

import javax.lang.model.element.Name;
import java.util.ArrayList;

public class BusinessCustomer extends Customer {

    public int purchaseOrderBalance;

    public BusinessCustomer(String custName){
        super(custName);
    }
    public double PayForOrder(ArrayList<merchandiseItem> itemsinOrder ){
        return 0;

    }
    public int currentOutstandingBalance;

    public double payOutstandingBalance(){
         int balance = 1000;
         double discount = 0.05;

        final boolean b = purchaseOrderBalance > balance;
        if (purchaseOrderBalance > balance)
            return discount;
         currentOutstandingBalance = (int) (purchaseOrderBalance - discount);
        return currentOutstandingBalance;
    }
    private String Name;
    public String getName() {
        return Name;
    }
    @Override
    public void arrangeDelivery() {
        super.arrangeDelivery();
        System.out.println("To " + Name + " all deliveries must be from 9-5 Monday-Friday.");
    }
}
