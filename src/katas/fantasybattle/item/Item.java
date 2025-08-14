package katas.fantasybattle.item;

public interface Item {
    int getBaseDamage();
    float getDamageModifier();
    ItemType getItemType();
}