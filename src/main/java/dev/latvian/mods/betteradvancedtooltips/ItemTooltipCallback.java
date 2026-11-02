package dev.latvian.mods.betteradvancedtooltips;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

@FunctionalInterface
public interface ItemTooltipCallback {
	Event<ItemTooltipCallback> EVENT = EventFactory.createArrayBacked(ItemTooltipCallback.class, listeners -> event -> {
		for (var listener : listeners) {
			listener.onItemTooltip(event);
		}
	});

	void onItemTooltip(ItemTooltipContext event);
}
