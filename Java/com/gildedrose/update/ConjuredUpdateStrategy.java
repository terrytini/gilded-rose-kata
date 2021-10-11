package com.gildedrose.update;

import com.gildedrose.Item;

public class ConjuredUpdateStrategy extends ItemUpdateStrategy {

	@Override
	protected void decrementQuality(Item item) {
		if (item.quality > QUALITY_MIN + 2) {
			item.quality -= 2;
		} else if (item.quality == QUALITY_MIN + 1) {
			item.quality -= 1;
		}
	}

}
