package ac.scythe.struct;

public class stats {
    public Integer damage;
    public Integer warmth;
    public Integer protection;
    public Integer light;
    public Integer energy;
    public Boolean requireEnergy;
    public Boolean dealsDamage;

    public Integer getDamage() {
        return damage;
    }

    public Integer getWarmth() {
        return warmth;
    }

    public Integer getProtection() {
        return protection;
    }

    public Integer getLight() {
        return light;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Boolean getRequireEnergy() {
        return requireEnergy;
    }

    public Boolean getDealsDamage() {
        return dealsDamage;
    }

    public stats(Integer damage, Integer warmth, Integer protection, Integer light, Integer energy, Boolean requireEnergy, Boolean dealsDamage) {
        this.damage = damage;
        this.warmth = warmth;
        this.protection = protection;
        this.light = light;
        this.energy = energy;
        this.requireEnergy = requireEnergy;
        this.dealsDamage = dealsDamage;
    }
}
