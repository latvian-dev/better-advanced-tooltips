package dev.latvian.mods.betteradvancedtooltips;

import net.neoforged.neoforge.common.ModConfigSpec;

public class BATConfig {
	public static final BATConfig CONFIG;
	public static final ModConfigSpec CONFIG_SPEC;

	static {
		var pair = new ModConfigSpec.Builder().configure(BATConfig::new);
		CONFIG = pair.getLeft();
		CONFIG_SPEC = pair.getRight();
	}

	public final ModConfigSpec.BooleanValue removeCreativeTabTooltip;
	public final ModConfigSpec.BooleanValue removeComponentCountTooltip;
	public final ModConfigSpec.BooleanValue fuelTooltip;
	public final ModConfigSpec.BooleanValue tagTooltip;
	public final ModConfigSpec.BooleanValue componentTooltip;

	private BATConfig(ModConfigSpec.Builder builder) {
		this.removeCreativeTabTooltip = builder.define("remove_creative_tab_tooltip", true);
		this.removeComponentCountTooltip = builder.define("remove_component_count_tooltip", true);
		this.fuelTooltip = builder.define("fuel_tooltip", true);
		this.tagTooltip = builder.define("tag_tooltip", true);
		this.componentTooltip = builder.define("component_tooltip", true);
	}
}
