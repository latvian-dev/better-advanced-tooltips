package dev.latvian.mods.betteradvancedtooltips;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

public interface BATIcons {
	Style ICONS = Style.EMPTY.withFont(BATMod.id("icons")).applyFormat(ChatFormatting.WHITE);

	Component SMALL_SPACE = Component.literal(".").setStyle(ICONS);
	Component FUEL_PREFIX = Component.literal("F.").setStyle(ICONS);
	Component PROTOTYPE_COMPONENT_PREFIX = Component.literal("P.").setStyle(ICONS);
	Component PATCHED_COMPONENT_PREFIX = Component.literal("Q.").setStyle(ICONS);
	Component TAG_PREFIX = Component.literal("T.").setStyle(ICONS);
}
