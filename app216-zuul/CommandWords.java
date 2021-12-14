
/**
 * This contains all the possible command words
 * for the game of Zuul
 *
 * @author  Stefan Allen, " Mo's full name " And " Ben's full name "
 * @version 14/12/2021
 */
public enum CommandWords
{
    GO   ("go","Exit location in <direction>"),
    TAKE ("take", "Take <item> from location"),
    HELP ("help", "List all available commands"),
    QUIT ("quit", "End the game");
    
    public final String word;
    public final String description;
    
    CommandWords(String word, String description)
    {
        this.word = word;
        this.description = description;
    }
}
