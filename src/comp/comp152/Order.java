package comp.comp152;
import java.util.ArrayList;

public class Order {



    private ArrayList<merchandiseItem> cartForOrder;



    private ShippingAddress destination;
    private Customer orderedBy;

    public Order(ShippingAddress dest, Customer cust)
    {
        destination = dest;
        cartForOrder = new ArrayList<merchandiseItem>();
        orderedBy = cust;
    }

    public String getDestination()
    {
        return destination.toString();
    }
    public String getOrderer()
    {
        return orderedBy.toString();
    }





}
