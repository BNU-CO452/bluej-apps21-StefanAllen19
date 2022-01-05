package ac.scythe.struct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class item {
    public String name;
    public String description;
    public HashMap<String, stats> stats;
    public String origin;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, stats> getStats() {
        return stats;
    }

    public String getOrigin() {
        return origin;
    }

    public item(String name, String description, String origin, stats stats) {

    }
}
