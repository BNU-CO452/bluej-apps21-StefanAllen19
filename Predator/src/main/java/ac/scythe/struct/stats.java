package ac.scythe.struct;

public class stats {
    private Integer damage;
    private Integer warmth;
    private Integer protection;
    private Integer light;
    private Integer energy;
    private Boolean requireEnergy;
    private Boolean dealsDamage;

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
