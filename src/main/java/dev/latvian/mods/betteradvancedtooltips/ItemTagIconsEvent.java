package dev.latvian.mods.betteradvancedtooltips;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

import java.util.Map;
import java.util.stream.Stream;

public class ItemTagIconsEvent {
	@FunctionalInterface
	public interface Callback {
		void onItemTagIcons(ItemTagIconsEvent event);
	}

	public static final Event<Callback> EVENT = EventFactory.createArrayBacked(Callback.class, listeners -> event -> {
		for (var listener : listeners) {
			listener.onItemTagIcons(event);
		}
	});

	private final ItemTooltipContext parentEvent;
	private final Map<ResourceLocation, TagInstance> map;

	public ItemTagIconsEvent(ItemTooltipContext parentEvent, Map<ResourceLocation, TagInstance> map) {
		this.parentEvent = parentEvent;
		this.map = map;
	}

	public ItemTooltipContext getParentEvent() {
		return parentEvent;
	}

	public ItemStack getItem() {
		return parentEvent.getItemStack();
	}

	public <T> void append(TooltipTagType<T> type, Stream<? extends TagKey<T>> tags) {
		tags.forEach(tag -> map.computeIfAbsent(tag.location(), TagInstance::new).registries.add(type));
	}
}
