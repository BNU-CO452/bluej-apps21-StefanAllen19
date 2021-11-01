import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Stefan Allen
 * @version 19/10/2021
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    public ArrayList<Module> modules;
    private String code;
    private String title;
    private Grades finalGrade;
     
    /**
     * course for students to enrol 
     */
    public Course()
    {
        this("BT1SFT1", "BSc Software Engineering");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        modules  = new ArrayList<Module>();
        createModules();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module co452 = new Module ("Co452", "programming Conceptes");
        Module co450 = new Module ("Co450", "Computer Architecture");
        Module co456 = new Module ("Co456", "Web Development" + "\t");
        Module co454 = new Module ("Co454", "Digi Tech" + "\t");
        addModule(co452);
        addModule(co450);
        addModule(co456);
        addModule(co454); 
    }
    
     /**
     * For random marks 
     */
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * This converts your total into grades
     */
    public Grades convertToGrade(int mark)
    {
        if(mark >= 0 && mark <= 39)
            return Grades.F;
        else if(mark <= 49)
            return Grades.D;
        else if(mark <= 59)
            return Grades.C;
        else if(mark <= 69)
            return Grades.B;
        else if(mark <= 100)
            return Grades.A;
        else 
            return Grades.NS;
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int total = 0;
        int finalMark = 0;
        for(ModuleMark mark : marks)
        {
            total = total + mark.getValue();
        }
        finalMark = total / MAXN_MODULES;
        finalGrade = convertToGrade(finalMark);
        return finalGrade;
    }
    
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        //System.out.println();
        
        printModules();
    }
    
    /**
     * Print the course's four modules
     */
    public void printModules()
    {
        for (Module module : modules)
        {
            module.print();
            module.printCredit();
        }
    }
}
