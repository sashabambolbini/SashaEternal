package net.sashabambolbi.sashaeternal.item;

import net.sashabambolbi.sashaeternal.procedures.WeaponClassCheckProcedure;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

public class SpireIronItem extends SwordItem {
	public SpireIronItem(Tier tier) {
		super(tier, 3, -2.4f, new Item.Properties());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, net.minecraft.world.InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);

		if (!WeaponClassCheckProcedure.canUseWeapon(player, "spear")) {
			if (!level.isClientSide && player != null) {
				player.displayClientMessage(Component.literal("§c" + WeaponClassCheckProcedure.getClassRequirement("spear")), true);
			}
			return InteractionResultHolder.fail(itemStack);
		}

		if (level.isClientSide) {
			return InteractionResultHolder.pass(itemStack);
		}

		if (player.isShiftKeyDown()) {
			// Кидаем копьё как трезубец
			ThrownTrident trident = new ThrownTrident(level, player, itemStack);
			trident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
			level.addFreshEntity(trident);
			itemStack.shrink(1);
			return InteractionResultHolder.success(itemStack);
		}

		return InteractionResultHolder.pass(itemStack);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, EntityLiving target, EntityLiving attacker) {
		if (attacker instanceof Player player) {
			if (!WeaponClassCheckProcedure.canUseWeapon(player, "spear")) {
				return false;
			}
		}
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


