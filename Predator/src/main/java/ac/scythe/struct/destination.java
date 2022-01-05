package ac.scythe.struct;

import java.util.HashMap;
import java.util.Map;

public class destination {
    public String name;
    public Integer id;
    public String description;
    public HashMap<String, item> items;

    public destination(String name, Integer id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public void setItems(HashMap<String, item> items) {
        this.items = items;
    }
}
