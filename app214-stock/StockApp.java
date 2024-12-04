
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
    
    /**
     *  Display for user's to pick an imput from keyboard
     *  imput to execute an action
     */
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        if(choice.equals("add"))
        {
            addProduct();
        }
        if(choice.equals("print"))
        {
            printProduct();
        }
        else if(choice.equals("buy"))
        {
            buyProduct();
        }
        if(choice.equals("sell"))
        {
            sellProduct();
        }
        if(choice.equals("restock"))
        {
            stock.lowStockList();
        }
        if(choice.equals("search"))
        {
            searchProduct();
        }
        if (choice.equals("low stock")) 
        {
            stock.listLowStock();
        }
        if(choice.equals("remove"))
        {
            removeProduct();
        }
        return false;
    }
    
    /**
     *  Add's a new product to the stock with ID and name
     */
    private void addProduct()
    {
        int id = reader.getInt("Please enter the ID: ");
        String name = reader.getString("Please enter the name of the product: ");
        Product product = new Product(id, name);
        
        stock.add(product);
        System.out.println("Product " + product.getID() 
            + ", " + product.getName() + " has been ADDED");
    }
    
    /**
     *  Prints the stock list to user
     */
    private void printProduct()
    {
        stock.print();
        System.out.println("Stock list printed");
    }

    /**
     *  Buys a number of products based on user's imput
     *  displays which product was brought and how many
     */
    private void buyProduct()
    {
        System.out.println("Buying a Product");
        System.out.println();

        int id = reader.getInt("Please Enter a Product ID > ");
        int amount = reader.getInt("Please Enter the Amount to be Bought > ");
        
        Product product = stock.findProduct(id);
        stock.buyProduct(id, amount);
        stock.print();
        System.out.println("Bought "+ amount +" of ID "+product.getID()+": "+
        product.getName());
    }
    
    /**
     *  sells a number of products based on user's imput
     *  displays which product was sold and how many
     */
    private void sellProduct()
    {
        int id = reader.getInt("Please Enter a Product ID ");
        int amount = reader.getInt("Enter Amount to sell ");
        
        Product product = stock.findProduct(id);
        stock.sellProduct(id, amount);
        stock.print();
        System.out.println("Sold "+ amount +" of ID " + product.getID() + ": "+
        product.getName());
    }
    
    /**
     *  Restock all products below 3 to 10
     */
    private void restockProduct()
    {
        int id = reader.getInt("Please Enter a Product ID ");
        Product product = stock.findProduct(id);
        
        product.increaseQuantity(10);
        System.out.println("Restocked product: " + product.getID() +
        product.getName());
    }
    
    /**
     *  Search a product based on ID and name
     */
    private void searchProduct()
    {  
        int id = reader.getInt("Please enter the ID: "); 
        String name = reader.getString("Please enter the name of the product: ");
        Product product = new Product(id, name);
        
        stock.print();
        System.out.println(" ID: "+ product.getID()
            + "," + " " + "Product:" + " " + product.getName() + " Has been found");
    }
    
    /**
     *  Removes a product from the stock list
     */
    private void removeProduct()
    {
        int id = reader.getInt("Please enter the ID");
        System.out.println("Removing the product");
        System.out.println();
        
        stock.remove(id);
    }
    
    /**
     *  Display for user's to pick their required imput
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Print:      Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Buy:        Buy a product");
        System.out.println("    Sell:       Sell a product");
        System.out.println("    Search:     Find a product");
        System.out.println("    Low stock:  Restock product");
        System.out.println("    Restock:    Restock a product");
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