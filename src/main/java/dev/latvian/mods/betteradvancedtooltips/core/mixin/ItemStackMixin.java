package dev.latvian.mods.betteradvancedtooltips.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.latvian.mods.betteradvancedtooltips.BATConfig;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@ModifyExpressionValue(method = "getTooltipLines", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/component/PatchedDataComponentMap;size()I"))
	private int bat$getTooltipLines(int original) {
		return BATConfig.CONFIG.removeComponentCountTooltip.getAsBoolean() ? 0 : original;
	}
}
