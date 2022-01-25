package ac.scythe.struct;

import ac.scythe.app.Game;
import ac.scythe.util.Output;

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
        items =  new HashMap<>();
    }


    //Gets

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
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

    public void addItem(item Item) {
        items.put(Item.getName().toLowerCase(), Item);
    }

    public void removeItem(item Item) {
        items.remove(Item.getName().toLowerCase());
    }
}
