import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Stefan Allen) 
 * @version (02/11/2021)
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Remove a product based on product ID
     */
     public void remove(int productID)
    {
        Product product = findProduct(productID);
        if(product != null)
        {
           stock.remove(product);  
           System.out.println("Product Removed " + product.getName());
        }
        else
        {
            System.out.println("ID doesn't exist ");
        }
     }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        if(product != null) 
        {
            if(product.getQuantity() < 100) 
            {
                product.increaseQuantity(amount);
                System.out.println("Brought " + amount + " of " + product.getName());
                // printout message
            }
            else if(product.getQuantity() == 0) 
            {
                System.out.println("Not enough space for " + product.getName() 
                                    + ". Please sell the existing stock");
                // printout message
            }
        }
        else
        {
            System.out.println("Couldn't find ID");
        }
    }   
    
    /**
     * If stock level below 3 increase stock level by 10 
     */
    public void lowStockList()
    {
        printHeading();
        for (Product product : stock) 
            {
            if(product.getQuantity() < 3)

                product.increaseQuantity(10);
            }
            System.out.println("If below 3 Increase stock level by 10");
        for(Product product : stock)
            {
                product.print();
            }
    }
    
    /**
     * Print a list of products that are below 2 stock level 
     */
    public void listLowStock()
    {
        printHeading();
        for (Product product : stock)
        {
            if (product.getQuantity() < 5)
            {
                System.out.println(product);
            }
        }
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for (Product product : stock)
        {
            if(product.getID() == productID)
                return product;
        }
        return null;
    }
    
    /**
     * find a product base on product name 
     */
     public Product findProductName(String productName)
    {
        for(Product product : stock)
        {
            if(product.getName() == productName)
                return product;
            System.out.print(product);
        }
        return null;
    }
    
     /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID)
    {
        sellProduct(productID, 1);
    }
   
    /**
     * Sell many of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() > 0 && product.getQuantity() > amount) 
            {
                product.decreaseQuantity(amount);
                System.out.println("Sold " + amount + " of " + product.getName());
                // printout message
            }
            else if(product.getQuantity() == 0) 
            {
                System.out.println("Restock the " + product.getName() + 
                                    " is out of stock");
                // printout message
            }
            else 
            {
                System.out.println("Can't sell " + amount + " of " + product.getName() + 
                                    " becuase only have " + product.getQuantity());
                // printout message
            }
        }
        else
        {
            System.out.println("Couldn't find product");
            // printout message
        }
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Stefan Allen's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
}