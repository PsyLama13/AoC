package katas.gildedrose.main;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseOld {
    public List<Item> shopItems = new ArrayList<>();

    public GildedRoseOld(Item[] items) {
        for (Item item : items) {
            shopItems.add(item);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : shopItems) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

    public void updateQuality() {
        for (int i = 0; i < shopItems.size(); i++) {
            if (!shopItems.get(i).name.equals("Aged Brie")
                    && !shopItems.get(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (shopItems.get(i).quality > 0) {
                    if (!shopItems.get(i).name.equals("Sulfuras, Hand of Ragnaros")) {
                        shopItems.get(i).quality = shopItems.get(i).quality - 1;
                    }
                }
            } else {
                if (shopItems.get(i).quality < 50) {
                    shopItems.get(i).quality = shopItems.get(i).quality + 1;

                    if (shopItems.get(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (shopItems.get(i).sellIn < 11) {
                            if (shopItems.get(i).quality < 50) {
                                shopItems.get(i).quality = shopItems.get(i).quality + 1;
                            }
                        }

                        if (shopItems.get(i).sellIn < 6) {
                            if (shopItems.get(i).quality < 50) {
                                shopItems.get(i).quality = shopItems.get(i).quality + 1;
                            }
                        }
                    }
                }
            }

            if (!shopItems.get(i).name.equals("Sulfuras, Hand of Ragnaros")) {
                shopItems.get(i).sellIn = shopItems.get(i).sellIn - 1;
            }

            if (shopItems.get(i).sellIn < 0) {
                if (!shopItems.get(i).name.equals("Aged Brie")) {
                    if (!shopItems.get(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (shopItems.get(i).quality > 0) {
                            if (!shopItems.get(i).name.equals("Sulfuras, Hand of Ragnaros")) {
                                shopItems.get(i).quality = shopItems.get(i).quality - 1;
                            }
                        }
                    } else {
                        shopItems.get(i).quality = shopItems.get(i).quality - shopItems.get(i).quality;
                    }
                } else {
                    if (shopItems.get(i).quality < 50) {
                        shopItems.get(i).quality = shopItems.get(i).quality + 1;
                    }
                }
            }
        }
    }
}