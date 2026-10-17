package net.sashabambolbi.sashaeternal.item;

import net.sashabambolbi.sashaeternal.procedures.WeaponClassCheckProcedure;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

public class RestrictedBowItem extends BowItem {
	public RestrictedBowItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, net.minecraft.world.InteractionHand hand) {
		if (!WeaponClassCheckProcedure.canUseWeapon(player, "bow")) {
			if (!level.isClientSide && player != null) {
				player.displayClientMessage(Component.literal("§c" + WeaponClassCheckProcedure.getClassRequirement("bow")), true);
			}
			return InteractionResultHolder.fail(player.getItemInHand(hand));
		}

		return super.use(level, player, hand);
	}
}
