package katas.fantasybattle.character;


import katas.fantasybattle.Equipment;
import katas.fantasybattle.Stats;
import katas.fantasybattle.item.Item;

public class Character extends Enemy {
    private final Equipment equipment;
    private final Stats stats;

    public Character(Stats stats) {
        this.equipment = new Equipment();
        this.stats = stats;
    }

    public void equipItem(Item item) {
        equipment.equipItem(item);
    }

    public int calculateDamage(SimpleEnemy other) {
        int baseDamage = calculateBaseDamage();
        float damageModifier = calculateDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = calculateSoak(other, totalDamage);
        return Math.max(0, totalDamage - soak);
    }

    private int calculateSoak(Enemy other, int totalDamage) {
        int soak = 0;
        if (other instanceof Character) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (other instanceof SimpleEnemy enemy) {
            soak = Math.round(enemy.getArmor().getDamageSoak() * enemy.getTotalBuff());
        }
        return soak;
    }

    private float calculateDamageModifier() {
        if (stats == null) {
            return 0;
        }
        float strengthModifier = stats.strength() * 0.1f;
        return strengthModifier + this.equipment.getDamageModifier();
    }

    private int calculateBaseDamage() {
        return this.equipment.getBaseDamage();
    }
}