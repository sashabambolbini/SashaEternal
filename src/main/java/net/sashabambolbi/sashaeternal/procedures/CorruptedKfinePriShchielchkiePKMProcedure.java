package net.sashabambolbi.sashaeternal.procedures;

import net.sashabambolbi.sashaeternal.network.SashaeternalModVariables;
import net.sashabambolbi.sashaeternal.init.SashaeternalModItems;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;

public class CorruptedKfinePriShchielchkiePKMProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 4);
		if (entity instanceof Player _player)
			_player.causeFoodExhaustion((float) 0.3);
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(SashaeternalModItems.CRYSTALLIZED_BLOOD.get()).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(4, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		{
			var _playerVars = entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElse(null);
			if (_playerVars != null) {
				_playerVars.Eteruos = entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElseGet(SashaeternalModVariables.PlayerVariables::new).Eteruos - 10;
				_playerVars.markSyncDirty();
			}
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
	}
}