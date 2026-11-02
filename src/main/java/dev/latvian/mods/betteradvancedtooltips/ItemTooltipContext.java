package dev.latvian.mods.betteradvancedtooltips;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record ItemTooltipContext(ItemStack getItemStack, Item.TooltipContext getContext, @Nullable Player getEntity, TooltipFlag getFlags, List<Component> getToolTip) {
}
