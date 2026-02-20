package katas.gildedrose.test;

import katas.gildedrose.main.GildedRose;
import katas.gildedrose.main.Item;
import org.approvaltests.Approvals;
import org.approvaltests.namer.NamerFactory;
import org.approvaltests.reporters.Junit5Reporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@UseReporter(Junit5Reporter.class)
class GildedRoseTest {

    // -------------------------------------------------------------------------
    // Approval Test – parametrisiert nach Anzahl Tage
    // -------------------------------------------------------------------------
    // Beim ersten Ausführen: .received.txt prüfen → zu .approved.txt umbenennen
    // Beim Refactoring: Test bleibt grün solange das Verhalten identisch ist
    // -------------------------------------------------------------------------

    @ParameterizedTest(name = "day {0}")
    @ValueSource(ints = {0, 1, 5, 6, 10, 11, 15, 30})
    void approvalTest_shopStateAtDay(int days) {
        GildedRose app = createShopWithAllItems();
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        try (var _ = NamerFactory.withParameters(days)) {
            Approvals.verify(app.toString());
        }
    }

    private GildedRose createShopWithAllItems() {
        return new GildedRose(new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6),
                new Item("Conjured Aged Brie", 2, 0),
                new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 15, 20)
        });
    }
}