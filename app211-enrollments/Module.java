
/**
 * Write a description of class Module here.
 *
 * @author (Stefan)
 * @version (5/10/2021)
 */
public class Module
{
    // instance variables - replace the example below with your own
    private String code;
    private String title;
    private int credit;

    /**
     * Constructor for objects of class Module
     */
    public Module(String code, String title)
    {
        this.code = code;
        this.title = title;
        this.credit = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getCredit()
    {
        // put your code here
        return credit;
    }

    public String getCode()
    {
        return code;
    }    
    
    public String getitle()
    {
        return title;
    }  
    
   public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
    /**
     * Print the details of the course, the list
     * of students enrolled and the module
     */
    public void print()
    {
        System.out.println(" Course Code: " + code + ": " + title +" " + credit);
        System.out.println();
    }
}