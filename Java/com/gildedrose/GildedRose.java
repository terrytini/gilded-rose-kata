package com.gildedrose;

import java.util.Arrays;

import com.gildedrose.update.AgedBrieUpdateStrategy;
import com.gildedrose.update.BackstagePassesUpdateStrategy;
import com.gildedrose.update.ConjuredUpdateStrategy;
import com.gildedrose.update.ItemUpdateStrategy;
import com.gildedrose.update.SulfurasUpdateStrategy;

class GildedRose {
	Item[] items;

	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String TAFKAL80ETC_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String CONJURED = "Conjured ";

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		Arrays.asList(items).parallelStream().forEach(item -> updateItem(item));
	}

	private void updateItem(Item item) {
		ItemUpdateStrategy strategy = determineUpdateStrategy(item);
		strategy.updateQuality(item);
	}

	private ItemUpdateStrategy determineUpdateStrategy(Item item) {
		String itemName = item.name;
		ItemUpdateStrategy itemUpdateStrategyClass = new ItemUpdateStrategy();
		if (itemName.equals(AGED_BRIE)) {
			itemUpdateStrategyClass = new AgedBrieUpdateStrategy();
		} else if (itemName.equals(SULFURAS)) {
			itemUpdateStrategyClass = new SulfurasUpdateStrategy();
		} else if (itemName.equals(TAFKAL80ETC_PASSES)) {
			itemUpdateStrategyClass = new BackstagePassesUpdateStrategy();
		} else if (itemName.startsWith(CONJURED)) {
			itemUpdateStrategyClass = new ConjuredUpdateStrategy();
		}
		return itemUpdateStrategyClass;
	}

}
