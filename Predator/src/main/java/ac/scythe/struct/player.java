package ac.scythe.struct;

public class player {
    public Integer damage;
    public Integer destination;
    public Integer health;
    public String name;
    public Integer protection;
    public Integer score;
    public Integer warmth;



    public Integer getDamage() {
        return damage;
    }

    public Integer getDestination() {
        return destination;
    }

    public Integer getHealth() {
        return health;
    }

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

    public player(String name) {
        this.name = name;
        this.damage = 1;
        this.health = 100;
        this.destination = 0;
        this.protection = 1;
        this.score = 0;
        this.warmth = 0;
    }
}
