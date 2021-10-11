package com.gildedrose.update;

import com.gildedrose.Item;

public class BackstagePassesUpdateStrategy extends ItemUpdateStrategy {

	@Override
	public void updateQuality(Item item) {
		item.sellIn -= 1;
		if (item.sellIn < 0) {
			item.quality = QUALITY_MIN;
		} else if (item.sellIn < 5) {
			incrementQuality(item, 3);
		} else if (item.sellIn < 10) {
			incrementQuality(item, 2);
		} else {
			incrementQuality(item, 1);
		}
	}

	private void incrementQuality(Item item, int val) {
		if (item.quality + val > QUALITY_CAP) {
			item.quality = QUALITY_CAP;
		} else {
			item.quality += val;
		}
	}

}
