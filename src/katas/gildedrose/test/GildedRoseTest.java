package katas.gildedrose.test;

import katas.gildedrose.main.GildedRose;
import katas.gildedrose.main.GildedRoseOld;
import katas.gildedrose.main.Item;
import org.approvaltests.Approvals;
import org.approvaltests.namer.NamerFactory;
import org.approvaltests.reporters.Junit5Reporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                new Item("Conjured Mana Cake", 3, 6)
        });
    }

    // -------------------------------------------------------------------------
    // Parameterized Tests – spezifische Regeln
    // -------------------------------------------------------------------------

    @ParameterizedTest(name = "[{index}] sellIn={0}, quality={1} → sellIn={2}, quality={3}")
    @org.junit.jupiter.params.provider.CsvSource({
            " 10, 20,  9, 19",  // Normalfall: quality -1 vor Ablauf
            "  1, 10,  0,  9",  // letzter Tag vor Ablauf
            "  0, 10, -1,  8",  // Ablauftag: quality -2 (doppelte Degradierung)
            " -1, 10, -2,  8",  // abgelaufen: weiterhin -2 pro Tag
            "  5,  0,  4,  0",  // quality nie unter 0
            "  0,  1, -1,  0",  // quality kann nicht unter 0 fallen beim Ablauf
    })
    void normalItem_qualityDegrades(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        assertAfterOneDay("normal item", sellIn, quality, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest(name = "[{index}] sellIn={0}, quality={1} → sellIn={2}, quality={3}")
    @org.junit.jupiter.params.provider.CsvSource({
            " 10, 25,  9, 26",  // quality steigt vor Ablauf
            " -1, 48, -2, 50",  // nach Ablauf: quality +2 pro Tag, begrenzt auf 50
            "  0, 49, -1, 50",  // Grenzwert: 50 wird nicht überschritten
            "  0, 50, -1, 50",  // bereits bei 50: bleibt 50
    })
    void agedBrie_qualityIncreases(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        assertAfterOneDay("Aged Brie", sellIn, quality, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest(name = "[{index}] sellIn={0}, quality={1} → sellIn={2}, quality={3}")
    @org.junit.jupiter.params.provider.CsvSource({
            "  0, 80,  0, 80",
            " -1, 80, -1, 80",
            "  5, 80,  5, 80",
    })
    void sulfuras_neverChanges(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        assertAfterOneDay("Sulfuras, Hand of Ragnaros", sellIn, quality, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest(name = "[{index}] sellIn={0}, quality={1} → sellIn={2}, quality={3}")
    @org.junit.jupiter.params.provider.CsvSource({
            " 15, 20, 14, 21",  // +1 bei mehr als 10 Tagen
            " 11, 20, 10, 21",  // Grenzwert: +1 bei genau 11 Tagen
            " 10, 20,  9, 22",  // +2 ab genau 10 Tagen
            "  6, 20,  5, 22",  // Grenzwert: +2 bei genau 6 Tagen
            "  5, 20,  4, 23",  // +3 ab genau 5 Tagen
            "  1, 20,  0, 23",  // +3 am letzten Tag
            "  0, 20, -1,  0",  // Konzert vorbei: quality → 0
            " -1, 20, -2,  0",  // Konzert vorbei: quality bleibt 0
            " 10, 49,  9, 50",  // quality bei +2: auf 50 begrenzt
            "  5, 49,  4, 50",  // quality bei +3: auf 50 begrenzt
    })
    void backstagePass_qualityBehavior(int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        assertAfterOneDay("Backstage passes to a TAFKAL80ETC concert", sellIn, quality, expectedSellIn, expectedQuality);
    }

    // -------------------------------------------------------------------------
    // Hilfsmethode
    // -------------------------------------------------------------------------

    private void assertAfterOneDay(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedRoseOld app = new GildedRoseOld(new Item[]{new Item(name, sellIn, quality)});
        app.updateQuality();
        assertEquals(expectedSellIn, app.shopItems.getFirst().sellIn, "sellIn mismatch");
        assertEquals(expectedQuality, app.shopItems.getFirst().quality, "quality mismatch");
    }
}
