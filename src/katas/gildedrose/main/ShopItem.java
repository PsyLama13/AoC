package katas.gildedrose.main;

public class ShopItem {
    private Item item;
    UpdateRule rule;

    public ShopItem(Item item) {
        this.item = item;
        rule = Rules.getRuleByItemName(item.name);
    }

    @FunctionalInterface
    public interface UpdateRule {
        Item apply(Item s);
    }

    public void tick() {
        item = rule.apply(this.item);
    }

    public Item getItem() {
        return item;
    }
}