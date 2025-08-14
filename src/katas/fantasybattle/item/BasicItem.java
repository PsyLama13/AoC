package katas.fantasybattle.item;

public class BasicItem implements Item {

    private String name;
    private final int baseDamage;
    private final float damageModifier;
    private final ItemType itemType;

    public BasicItem(String name, int baseDamage, float damageModifier, ItemType itemType) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.damageModifier = damageModifier;
        this.itemType = itemType;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }

    @Override
    public ItemType getItemType() {
        return itemType;
    }
}