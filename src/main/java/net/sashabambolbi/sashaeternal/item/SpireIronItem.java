package net.sashabambolbi.sashaeternal.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

public class SpireIronItem extends SwordItem {
	public SpireIronItem() {
		super(Tiers.IRON, 3, -2.4f, new Item.Properties());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);

		if (player.isShiftKeyDown()) {
			// Бросок копья
			if (!level.isClientSide) {
				ThrownSpireIron spire = new ThrownSpireIron(level, player);
				spire.setItem(itemStack);
				level.addFreshEntity(spire);
			}

			// Уменьшаем стек на 1
			if (!player.getAbilities().instabuild) {
				itemStack.shrink(1);
			}

			return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
		}

		return InteractionResultHolder.pass(itemStack);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == net.minecraft.world.item.Items.IRON_INGOT || super.isValidRepairItem(toRepair, repair);
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}
}
