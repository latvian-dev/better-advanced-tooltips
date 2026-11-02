package dev.latvian.mods.betteradvancedtooltips.core.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.latvian.mods.betteradvancedtooltips.BATConfig;
import dev.latvian.mods.betteradvancedtooltips.ItemTooltipCallback;
import dev.latvian.mods.betteradvancedtooltips.ItemTooltipContext;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@Inject(method = "getTooltipLines", at = @At("TAIL"))
	private void bat$onItemTooltip(Item.TooltipContext context, Player player, TooltipFlag flags, CallbackInfoReturnable<List<Component>> ci) {
		ItemTooltipCallback.EVENT.invoker().onItemTooltip(new ItemTooltipContext((ItemStack) (Object) this, context, player, flags, ci.getReturnValue()));
	}

	@ModifyExpressionValue(method = "getTooltipLines", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/component/PatchedDataComponentMap;size()I"))
	private int bat$getTooltipLines(int original) {
		return BATConfig.CONFIG.removeComponentCountTooltip.getAsBoolean() ? 0 : original;
	}
}
