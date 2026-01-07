package dev.latvian.mods.betteradvancedtooltips.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.latvian.mods.betteradvancedtooltips.BATConfig;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(CreativeModeInventoryScreen.class)
public class CreativeModeInventoryScreenMixin {
	@ModifyExpressionValue(method = "getTooltipFromContainerItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/CreativeModeTabs;tabs()Ljava/util/List;"))
	private List<CreativeModeTab> bat$getTooltipFromContainerItem(List<CreativeModeTab> original) {
		return BATConfig.CONFIG.removeCreativeTabTooltip.getAsBoolean() ? List.of() : original;
	}
}
