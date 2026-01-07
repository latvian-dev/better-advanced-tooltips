package dev.latvian.mods.betteradvancedtooltips;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = BATMod.ID, dist = Dist.CLIENT)
public class BATMod {
	public static final String ID = "betteradvancedtooltips";
	public static final String NAME = "Better Advanced Tooltips";

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(ID, path);
	}

	public BATMod(ModContainer container) {
		container.registerConfig(ModConfig.Type.CLIENT, BATConfig.CONFIG_SPEC, "better-advanced-tooltips-client.toml");
		container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
	}
}
