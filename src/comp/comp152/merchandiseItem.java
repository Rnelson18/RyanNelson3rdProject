package comp.comp152;

public class merchandiseItem {

private String Name;
private itemType taxibleType;
private double price;

    public merchandiseItem(String Name, double price, itemType Type){
        taxibleType = Type;
        this.Name = Name;
        this.price = price;
    }



    public String getName()
    {
        return Name;
    }

    public double getPrice() { return price; }

    public itemType getTaxibleType() {return taxibleType;}

}
