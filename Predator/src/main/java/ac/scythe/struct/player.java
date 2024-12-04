package ac.scythe.struct;

import ac.scythe.app.Game;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ac.scythe.util.Data.destinations;

public class player {
    private Integer damage;
    private Integer destination;
    private Integer health;
    private String name;
    private Integer protection;
    private Integer score;
    private Integer warmth;
    public ConcurrentHashMap<String, item> inventory;



    public Integer getDamage() {
        return damage;
    }

    public Integer getDestination() {
        return destination;
    }

    public Integer getHealth() {
        return health;
    }

    public Map<String, item> getInventory() { return inventory; }

    public String getName() {
        return name;
    }

    public Integer getProtection() {
        return protection;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getWarmth() {
        return warmth;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProtection(Integer protection) {
        this.protection = protection;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setWarmth(Integer warmth) {
        this.warmth = warmth;
    }

    public void removeItem(String Item) {
        inventory.remove(Item.toLowerCase(Locale.ROOT));
    }
    public void addItem(item Item) { inventory.put(Item.getName().toLowerCase(), Item);}

    public player(String name) {
        this.name = name;
        this.damage = 1;
        this.health = 100;
        this.destination = 0;
        this.protection = 1;
        this.score = 0;
        this.warmth = 0;
        inventory = new ConcurrentHashMap<>();
    }
}
