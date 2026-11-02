package dev.latvian.mods.betteradvancedtooltips;

import net.minecraft.resources.ResourceLocation;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.client.ConfigScreenFactoryRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.Event;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;

public class BATMod implements ClientModInitializer {
	public static final String ID = "betteradvancedtooltips";
	public static final String NAME = "Better Advanced Tooltips";

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(ID, path);
	}

	@Override
	public void onInitializeClient() {
		NeoForgeConfigRegistry.INSTANCE.register(ID, ModConfig.Type.CLIENT, BATConfig.CONFIG_SPEC, "better-advanced-tooltips-client.toml");
		ConfigScreenFactoryRegistry.INSTANCE.register(ID, ConfigurationScreen::new);
		ResourceLocation phase = id("tooltip");
		ItemTooltipCallback.EVENT.addPhaseOrdering(Event.DEFAULT_PHASE, phase);
		ItemTooltipCallback.EVENT.register(phase, BATClientEventHandler::onItemTooltip);
	}
}
