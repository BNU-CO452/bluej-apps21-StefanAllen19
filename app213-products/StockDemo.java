
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
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Mercedes AMG GT"));
        stock.add(new Product(102, "BMW M8 GC"));
        stock.add(new Product(103, "Audi RS3"));
        stock.add(new Product(104, "Brabus E63S AMG"));
        stock.add(new Product(105, "Lamborghini SVJ"));
        stock.add(new Product(106, "ABT RS6"));
        stock.add(new Product(107, "Lamborghini Performante"));
        stock.add(new Product(108, "Audi RS3"));
        stock.add(new Product(109, "BMW M5"));
        stock.add(new Product(110, "Brabus Rocket 900"));
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
        stock.buyProduct(101, 4);
        stock.buyProduct(102, 8);
        stock.buyProduct(103, 3);
        stock.buyProduct(104, 7);
        stock.buyProduct(105, 9);
        stock.buyProduct(106, 2);
        stock.buyProduct(107, 7);
        stock.buyProduct(108, 4);
        stock.buyProduct(109, 9);
        stock.buyProduct(110, 3);
    }

    private void sellProducts()
    {
        stock.sellProduct(101, 2);
        stock.sellProduct(102, 4);
        stock.sellProduct(103, 1);
        stock.sellProduct(104, 6);
        stock.sellProduct(105, 5);
        stock.sellProduct(106, 1);
        stock.sellProduct(107, 4);
        stock.sellProduct(108, 2);
        stock.sellProduct(109, 4);
        stock.sellProduct(110, 2);
    }    
    
}