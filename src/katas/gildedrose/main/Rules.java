package katas.gildedrose.main;

public class Rules {
    private Rules() {
        throw new IllegalStateException("utility class");
    }

    public static ShopItem.UpdateRule normal() {
        return i -> {
            i.sellIn--;
            // if the item is "degraded", e.g., the age is higher than the sellIn; then it degrades at double speed
            if (i.sellIn < 0) {
                i.quality = Math.max(i.quality - 2, 0);
            } else {
                i.quality = Math.max(i.quality - 1, 0);
            }
            return i;
        };
    }

    public static ShopItem.UpdateRule brie() {
        // brie increases with age
        return i -> {
            i.sellIn--;
            if (i.sellIn < 0) {
                i.quality = Math.min(i.quality + 2, 50);
            } else {
                i.quality = Math.min(i.quality + 1, 50);
            }

            return i;
        };
    }

    public static ShopItem.UpdateRule legendary() {
        // legendary items always have quality 80 (or in this case the neither change sellIn nor quality)
        return s -> s;
    }

    public static ShopItem.UpdateRule backstagePass() {
        return i -> {
            i.sellIn--;
            i.quality = switch (i.sellIn) {
                case Integer d when d < 0 -> 0;
                case Integer d when d < 5 -> Math.min(i.quality + 3, 50);
                case Integer d when d < 10 -> Math.min(i.quality + 2, 50);
                default -> Math.min(i.quality + 1, 50);
            };
            return i;
        };
    }

    public static ShopItem.UpdateRule conjured(ShopItem.UpdateRule base) {
        return i -> {
            int qualityBefore = i.quality;
            base.apply(i);
            int qualityDelta = i.quality - qualityBefore;
            i.quality = Math.clamp(i.quality + qualityDelta, 0, 50);
            return i;
        };
    }

    public static ShopItem.UpdateRule getRuleByItemName(String name) {
        if (name.startsWith("Conjured ")) {
            return conjured(getRuleByItemName(name.substring("Conjured ".length())));
        }
        return switch (name) {
            case "Sulfuras, Hand of Ragnaros" -> legendary();
            case "Backstage passes to a TAFKAL80ETC concert" -> backstagePass();
            case "Aged Brie" -> brie();
            default -> normal();
        };
    }
}