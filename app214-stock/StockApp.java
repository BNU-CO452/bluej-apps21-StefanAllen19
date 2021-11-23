
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author (Stefan Allen)
 * @version (21/11/2021)
 */
public class StockApp  
{
    private InputReader reader;
    
    private StockList stock;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        else if(choice.equals("add"))
        {
            int id = reader.getInt("Please enter the ID");
            String name = reader.getString("Please enter the name of the product:");
            Product product = new Product(id, name);
            stock.add(product);
            System.out.println("Product " + product.getID()
                + "," + product.getName() + " has been ADDED");
        }
        else if(choice.equals("print"))
        {
            stock.print();
            System.out.println("Stock list printed");
        }
        else if(choice.equals("buy"))
        {
            stock.listLowStock();
        }
        else if(choice.equals("sell"))
        {
            int id = reader.getInt("Please Enter a Product ID ");
            int amount = reader.getInt("Enter Amount to sell ");
        
            Product product = stock.findProduct(id);
            stock.sellProduct(id, amount);
            stock.print();
            System.out.println("Bought "+ amount +" of ID " + product.getID() + ": "+
            product.getName());
        }
        else if(choice.equals("restock"))
        {
            int id = reader.getInt("Please Enter a Product ID ");
            Product product = stock.findProduct(id);
            product.increaseQuantity(10);
            System.out.println("Restocked product: " + product.getID() +
            product.getName());
        }
        else if(choice.equals("search"))
        {
            int id = reader.getInt("Please Enter a Product ID "); 
            Product product = stock.findProduct(id);
            System.out.println("Product found: " + product.getID() + ": " +
            product.getName());
        }
        else if (choice.equals("low stock")) 
        {
         stock.listLowStock();
        }
        else if(choice.equals("remove"))
        {
            int id = reader.getInt("Please enter the ID");
            System.out.println("Removing the product");
            System.out.println();
            stock.remove(id);
        }
        else
        {
            System.out.println("ID doesn't exist ");
        }
        return false;
    }

    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    1) Add:        Add a new product");
        System.out.println("    2) Remove:     Remove an old product");
        System.out.println("    3) Buy:        Buy a product");
        System.out.println("    4) Sell:       Sell a product");
        System.out.println("    5) Restock:    Restock a product");
        System.out.println("    6) Search:     Find a product");
        System.out.println("    7) Low stock:  Restock product");
        System.out.println("    8) Print:      Print all products");
        System.out.println("    9) Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Stefan Allen");
        System.out.println("********************************");
    }
}