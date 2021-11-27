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
        
        //stock.add(new Product(101, "RTX 3060"));
        //stock.add(new Product(102, "RTX 3060 TI"));
        //stock.add(new Product(103, "RTX 3070"));
        //stock.add(new Product(104, "RTX 3070 TI"));
        //stock.add(new Product(105, "RTX 3080"));
        //stock.add(new Product(106, "RTX 3080 TI"));
        //stock.add(new Product(107, "RTX 3090"));
        //stock.add(new Product(108, "RTX 3090 TI"));
        //stock.add(new Product(109, "RTX 6000"));
        //stock.add(new Product(110, "RTX 8000"));
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
    
    /**
     * Buy a product based on amount and ID
     */
    private void buyProducts()
    {
        stock.buyProduct(101, 9);
        stock.buyProduct(102, 4);
        stock.buyProduct(103, 9);
        stock.buyProduct(104, 3);
        stock.buyProduct(105, 7);
        stock.buyProduct(106, 5);
        stock.buyProduct(107, 2);
        stock.buyProduct(108, 9);
        stock.buyProduct(109, 8);
        stock.buyProduct(110, 4);
    }

    /**
     * Sell a product based on amount and ID
     */
    private void sellProducts()
    {
        stock.sellProduct(101, 5);
        stock.sellProduct(102, 2);
        stock.sellProduct(103, 4);
        stock.sellProduct(104, 1);
        stock.sellProduct(105, 5);
        stock.sellProduct(106, 4);
        stock.sellProduct(107, 1);
        stock.sellProduct(108, 6);
        stock.sellProduct(109, 4);
        stock.sellProduct(110, 2);
    }    
}