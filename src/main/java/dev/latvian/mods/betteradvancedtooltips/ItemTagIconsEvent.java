package dev.latvian.mods.betteradvancedtooltips;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.Map;
import java.util.stream.Stream;

public class ItemTagIconsEvent extends Event {
	private final ItemTooltipEvent parentEvent;
	private final Map<ResourceLocation, TagInstance> map;

	public ItemTagIconsEvent(ItemTooltipEvent parentEvent, Map<ResourceLocation, TagInstance> map) {
		this.parentEvent = parentEvent;
		this.map = map;
	}

	public ItemTooltipEvent getParentEvent() {
		return parentEvent;
	}

	public ItemStack getItem() {
		return parentEvent.getItemStack();
	}

	public <T> void append(TooltipTagType<T> type, Stream<? extends TagKey<T>> tags) {
		tags.forEach(tag -> map.computeIfAbsent(tag.location(), TagInstance::new).registries.add(type));
	}
}
