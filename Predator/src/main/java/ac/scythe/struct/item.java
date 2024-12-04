package ac.scythe.struct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class item {
    private String name;
    private String description;
    private stats stats;
    private String origin;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public stats getStats() {
        return stats;
    }

    public String getOrigin() {
        return origin;
    }

    public item(String name, String description, String origin, stats stats) {
        this.name = name;
        this.description = description;
        this.origin = origin;
        this.stats = stats;
    }
}
