
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author (Stefan Allen) 
 * @version (02/11/2021)
 */
public class StockDemo
{
    // The stock manager.
    public StockList stock;
    private int amount;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "BMW M8 Grand Coupe"));
        stock.add(new Product(102, "Mercedes AMG GT Black Series"));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }
    
    private void buyProducts()
    {
        stock.buyProduct(101, 9);
        stock.buyProduct(102, 4);
    }

    private void sellProducts()
    {
        stock.sellProduct(101, 5);
        stock.sellProduct(102, 2);
    }    
    
}