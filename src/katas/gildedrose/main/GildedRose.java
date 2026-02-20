package katas.gildedrose.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {
    public final List<ShopItem> shopItems = new ArrayList<>();

    public GildedRose(Item[] items) {
        this.shopItems.addAll(Arrays.stream(items).map(ShopItem::new).toList());
    }

    public void updateQuality() {
        shopItems.forEach(ShopItem::tick);
    }

    @Override
    public String toString() {
        return shopItems.stream()
                .map(si -> si.getItem().toString())
                .collect(Collectors.joining("\n", "", "\n"));
    }
}