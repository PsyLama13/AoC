package katas.gildedrose.main;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    public final List<ShopItem> shopItems = new ArrayList<>();

    public GildedRose(Item[] items) {
        for (Item item : items) {
            shopItems.add(new ShopItem(item));
        }
    }

    public void updateQuality() {
        shopItems.forEach(ShopItem::tick);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ShopItem item : shopItems) {
            sb.append(item.item).append("\n");
        }
        return sb.toString();
    }
}