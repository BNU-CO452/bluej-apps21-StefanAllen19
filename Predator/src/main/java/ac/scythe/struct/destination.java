package ac.scythe.struct;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class destination {
    private String name;
    private Integer id;
    private String description;
    private HashMap<String, item> items;

    public destination(String name, Integer id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }


    //Gets

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public item getItem(String name) {
        System.out.println(items);
        for(Map.Entry<String, item> entry : items.entrySet())
        {
            if(entry.getValue().getName().toLowerCase(Locale.ROOT) == name.toLowerCase(Locale.ROOT)) return entry.getValue();
        }

        return null;
    }

    public HashMap<String, item> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    //Sets

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItems(HashMap<String, item> items) {
        this.items = items;
    }

    public void setName(String name) {
        this.name = name;
    }
}
