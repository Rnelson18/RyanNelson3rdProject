package comp.comp152;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    //Ryan Nelson
    private ArrayList<Order> Orders;
    private ArrayList<String> Customers;

    public Main () {
        Orders = new ArrayList<Order>();
        Customers = new ArrayList<String>();
    }


    public static void main(String[] args) throws IOException
    {
        var comp152Inc = new Main();
        comp152Inc.runStore();

    }

    public void runStore() throws IOException
    {
        var inputReader = new Scanner(System.in);
        loadStartingCustomers(inputReader);
        while(true){ //the main run loop
            printMainMenu();
            var userChoice = inputReader.nextInt();
            switch (userChoice){
                case 1:
                    addCustomer(inputReader);
                    break;
                case 2:
                    Optional<String> selectedCustomer =selectCustomer(inputReader);
                    if(selectedCustomer.isPresent())
                        manageCustomer(selectedCustomer.get());
                    break;
                case 3:
                    System.exit(0);

                default:
                    System.out.println("\n%%%%%%Invalid selection, please choose one of the options from the menu%%%%%%\n");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("Welcome to the the 1980s Comp152 Store interface, what would you like to do?");
        System.out.println("   [1] Add Customer");
        System.out.println("   [2] Select Customer");
        System.out.println("   [3] Exit the program");
        System.out.print("Enter the number of your choice:");
    }

    private void loadStartingCustomers(Scanner inputReader) throws IOException {
        Path fullPathName;
        String filename;
        while(true) {
            System.out.print("Enter the name of the file to load customers:");
            filename = inputReader.nextLine();
            fullPathName = Paths.get(filename);
            if (!Files.exists(fullPathName)){
                System.out.println("No file with that name, please try again....");
            }
            else
                break;
        }

        var allLines = Files.readAllLines(fullPathName);
        for(var line: allLines){
            var splitLine = line.split(",");
            if (splitLine[2].equals("Residential"){
            }
            Object params;
            var currentCustomer = new ResidentialCustomer(params);
            Customers.add(currentCustomer);



        }
    }

    public void makeOrder(ShippingAddress address, String cust)
    {
        var newOrder = new Order(address,cust);
        Orders.add(newOrder);
        System.out.println(".......New order successfully created");
    }

    public void addCustomer(Scanner inputReader)
    {
        inputReader.nextLine();
        System.out.println("Adding Customer........");
        System.out.print("Enter the new Customers name:");
        var newName = inputReader.nextLine();
        var newCustomer = (newName);
        Customers.add(newCustomer);
        System.out.println(".....Finished adding new Customer Record");
    }

    public Optional<String> selectCustomer(Scanner reader)
    {
        System.out.print("Enter the ID of the customer to select:");
        var enteredID = reader.nextInt();
        for(String currentCustomer: Customers){
            if(currentCustomer.getCustomerID()==enteredID)
                return Optional.of(currentCustomer);
        }

        System.out.println("==========================> No customer with customer ID:"+enteredID);
        return Optional.empty();
    }

    public void manageCustomer(String selectedCustomer)
    {
        Scanner secondScanner = new Scanner(System.in);
        while(true){
            printCustomerMenu(selectedCustomer.getName());
            var userChoice = secondScanner.nextInt();
            switch (userChoice){
                case 1 ->addAddress(secondScanner, selectedCustomer);
                case 2->{
                    ShippingAddress selectedAddress = pickAddress(secondScanner,selectedCustomer);
                    makeOrder(selectedAddress,selectedCustomer);
                }
                case 3-> {return;}
                default->System.out.println("Invalid option selected");
            }
        }
    }

    private ShippingAddress pickAddress(Scanner secondScanner, String selectedCustomer) {
        var customerAddresses = selectedCustomer.getAddresses();
        if (customerAddresses.size() ==0){
            System.out.println("This customer has no addresses on file, please add an address");
            addAddress(secondScanner,selectedCustomer);
            return selectedCustomer.getAddresses().get(0);
        }

        var count = 0;
        System.out.println("Please select a shipping address from those the customer has on file");
        for (var address : customerAddresses) {
            System.out.print("[" + count + "]");
            System.out.println(address.toString());
            count++;
        }
        System.out.print("Enter the number of the address for this order:");
        var addressNum = secondScanner.nextInt();

        if (addressNum >= customerAddresses.size()){
            System.out.println("Invalid entry, defaulting to the first address on file...");
            return customerAddresses.get(0);
        }
        else
            return customerAddresses.get(addressNum);
    }

    private void addAddress(Scanner secondScanner, String selectedCustomer) {
        System.out.println("Adding new address for "+ selectedCustomer.getName());
        secondScanner.nextLine();
        System.out.print("Enter Address Line 1:");
        var line1 = secondScanner.nextLine();
        System.out.print("Enter Address Line 2 or <enter> if there is none:");
        var line2 = secondScanner.nextLine();
        System.out.print("Enter the address City:");
        var city = secondScanner.nextLine();
        System.out.print("Enter address state:");
        var state = secondScanner.nextLine();
        System.out.print("Enter the postal code:");
        var postCode = secondScanner.nextLine();
        var newAddress  = new ShippingAddress(line1,line2,city,state,postCode);
        selectedCustomer.addAddress(newAddress);
    }

    private void printCustomerMenu(String custName) {
        System.out.println("What do you want to do for Customer " + custName+"?");
        System.out.println("   [1] Add Address to customer");
        System.out.println("   [2] Make an order for the customer");
        System.out.println("   [3] return to the main menu");
        System.out.print("Enter the number of your choice:");
    }


}
