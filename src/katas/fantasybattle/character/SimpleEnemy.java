package katas.fantasybattle.character;

import katas.fantasybattle.Armor;
import katas.fantasybattle.buff.Buff;

import java.util.List;

public class SimpleEnemy extends Enemy {

    private final Armor armor;
    private final List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    public float getTotalBuff() {
        float totalBuff = 1f;
        for (Buff buff : buffs) {
            totalBuff += buff.soakModifier();
        }
        return totalBuff;
    }

    Armor getArmor() {
        return this.armor;
    }
}