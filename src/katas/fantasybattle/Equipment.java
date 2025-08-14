package katas.fantasybattle;

import katas.fantasybattle.item.Item;
import katas.fantasybattle.item.ItemType;

import java.util.EnumMap;
import java.util.Map;

public class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    Map<ItemType, Item> equipmentMap;

    public Equipment() {
        equipmentMap = new EnumMap<>(ItemType.class);
    }

    public void equipItem(Item item) {
        equipmentMap.put(item.getItemType(), item);
    }

    public float getDamageModifier() {
        return (float) equipmentMap.values().stream().mapToDouble(Item::getDamageModifier).sum();
    }

    public int getBaseDamage() {
        return equipmentMap.values().stream().mapToInt(Item::getBaseDamage).sum();
    }
}