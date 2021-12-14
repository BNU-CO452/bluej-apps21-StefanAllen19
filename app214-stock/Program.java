/**
 * Write a description of class Program here.
 *
 * @author (Stefan Allen)
 * @version (21/11/2021)
 */
public class Program
{
    private static StockApp app;
    
    /**
     *  Runs the application from stock app but from a different class
     */
    public static void main(String[] args)
    {
        app = new StockApp();
        app.run();
    }
}
