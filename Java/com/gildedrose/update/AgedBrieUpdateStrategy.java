package com.gildedrose.update;

import com.gildedrose.Item;

public class AgedBrieUpdateStrategy extends ItemUpdateStrategy {

	@Override
	public void updateQuality(Item item) {
		item.sellIn -= 1;
		if (item.quality < QUALITY_CAP) {
			item.quality += 1;
		}
	}

}
