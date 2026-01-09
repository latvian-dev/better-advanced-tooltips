package dev.latvian.mods.betteradvancedtooltips;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

public interface BATIcons {
	Style ICONS = Style.EMPTY.withFont(BATMod.id("icons")).applyFormat(ChatFormatting.WHITE);

	private static Component icon(char c) {
		return Component.literal(String.valueOf(c)).setStyle(ICONS);
	}

	Component SMALL_SPACE = icon('.');
	Component ERROR = icon('!');
	Component PLUS = icon('+');
	Component MINUS = icon('-');
	Component TILDE = icon('~');
	Component COPY = icon('C');
	Component FIRE = icon('F');
	Component INFO = icon('I');
	Component CAMERA = icon('M');
	Component NO = icon('N');
	Component PROTOTYPE_COMPONENT = icon('P');
	Component PATCHED_COMPONENT = icon('Q');
	Component TAG = icon('T');
	Component WARN = icon('W');
	Component YES = icon('Y');
}
