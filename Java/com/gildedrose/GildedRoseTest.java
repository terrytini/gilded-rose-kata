package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
	
	@Test
	public void test_ConjuredItem_shouldDecaryTwiceAsFast() {
		Item[] items = new Item[] { new Item("Conjured foo", 2, 3), new Item("Conjured foo", 2, 1),
				new Item("Conjured foo", -1, 5)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertItemAttributes(app.items[0], "Conjured foo", 1, 1);
		assertItemAttributes(app.items[1], "Conjured foo", 1, 0);
		assertItemAttributes(app.items[2], "Conjured foo", -2, 1);
	}

	@Test
	public void pinningTest_normalItem_shouldDecrementSellInAndQuality() {
		Item[] items = new Item[] { new Item("foo", 0, 0), new Item("foo", 1, 1) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertItemAttributes(app.items[0], "foo", -1, 0);
		assertItemAttributes(app.items[1], "foo", 0, 0);
	}

	@Test
	public void pinningTest_normalItemSellInPassedQualityOne_shouldDecrementQualityBy2() {
		Item[] items = new Item[] { new Item("foo", -1, 4) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertItemAttributes(app.items[0], "foo", -2, 2);
	}

	@Test
	public void pinningTest_normalItemSellInPassedQualityOne_shouldNotMakeQualityNegative() {
		Item[] items = new Item[] { new Item("foo", -1, 1) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertItemAttributes(app.items[0], "foo", -2, 0);
	}

	@Test
	public void pinningTest_agedBrie_shouldIncrementQuality() {
		Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertItemAttributes(app.items[0], "Aged Brie", 1, 1);
	}

	@Test
	public void pinningTest_agedBrieQuality50_shouldKeepMaxQuality50() {
		Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertItemAttributes(app.items[0], "Aged Brie", 1, 50);
	}

	@Test
	public void pinningTest_sulfuras_shouldNotDecrementSellInAndShouldKeepQuality() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertItemAttributes(app.items[0], "Sulfuras, Hand of Ragnaros", 0, 80);
		assertItemAttributes(app.items[1], "Sulfuras, Hand of Ragnaros", -1, 80);
	}

	@Test
	public void pinningTest_tickets_shouldDecrementSellInIncrementQualities() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertItemAttributes(app.items[0], "Backstage passes to a TAFKAL80ETC concert", 14, 21);
		assertItemAttributes(app.items[1], "Backstage passes to a TAFKAL80ETC concert", 10, 21);
		assertItemAttributes(app.items[2], "Backstage passes to a TAFKAL80ETC concert", 9, 22);
		assertItemAttributes(app.items[3], "Backstage passes to a TAFKAL80ETC concert", 8, 22);
		assertItemAttributes(app.items[4], "Backstage passes to a TAFKAL80ETC concert", 5, 22);
		assertItemAttributes(app.items[5], "Backstage passes to a TAFKAL80ETC concert", 4, 23);
		assertItemAttributes(app.items[6], "Backstage passes to a TAFKAL80ETC concert", 3, 23);
	}
	
	@Test
	public void pinningTest_expiringTicket_shouldLostAllQuality() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 45),
				new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
				new Item("Backstage passes to a TAFKAL80ETC concert", -1, 1)};
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertItemAttributes(app.items[0], "Backstage passes to a TAFKAL80ETC concert", -1, 0);
		assertItemAttributes(app.items[1], "Backstage passes to a TAFKAL80ETC concert", -2, 0);
		assertItemAttributes(app.items[1], "Backstage passes to a TAFKAL80ETC concert", -2, 0);
	}
	

	private void assertItemAttributes(Item item, String name, int sellIn, int quality) {
		assertEquals(name, item.name);
		assertEquals(sellIn, item.sellIn);
		assertEquals(quality, item.quality);
	}

}
