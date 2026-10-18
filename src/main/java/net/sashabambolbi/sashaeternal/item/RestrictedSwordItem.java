package net.sashabambolbi.sashaeternal.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.network.chat.Component;

public class RestrictedSwordItem extends SwordItem {
	public RestrictedSwordItem(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
		super(tier, attackDamage, attackSpeed, properties);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}
}
