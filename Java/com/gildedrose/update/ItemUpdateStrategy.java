package com.gildedrose.update;

import com.gildedrose.Item;

public class ItemUpdateStrategy {
	
	protected static final int QUALITY_CAP = 50;
	protected static final int QUALITY_MIN = 0;
	
	public void updateQuality(Item item) {
		decrementQuality(item);
		item.sellIn -= 1;
		if (item.sellIn < 0) {
			decrementQuality(item);
		}
	}

	protected void decrementQuality(Item item) {
		if (item.quality > QUALITY_MIN) {
			item.quality -= 1;
		}
	}
}
