package net.sashabambolbi.sashaeternal.item;

import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class SpireIronItem extends SwordItem {
	public SpireIronItem(Tier tier) {
		super(tier, 3, -2.4f, new Item.Properties());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(net.minecraft.world.level.Level level, Player player, net.minecraft.world.InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);
		return InteractionResultHolder.pass(itemStack);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, EntityLiving target, EntityLiving attacker) {
		stack.hurtAndBreak(1, attacker, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}
}
