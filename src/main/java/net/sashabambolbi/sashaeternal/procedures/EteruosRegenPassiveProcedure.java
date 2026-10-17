package net.sashabambolbi.sashaeternal.procedures;

import net.sashabambolbi.sashaeternal.network.SashaeternalModVariables;
import net.sashabambolbi.sashaeternal.SashaeternalMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EteruosRegenPassiveProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		SashaeternalMod.queueServerWork(20, () -> {
			if (entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElseGet(SashaeternalModVariables.PlayerVariables::new).Eteruos < entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES)
					.orElseGet(SashaeternalModVariables.PlayerVariables::new).maxEteruos) {
				{
					var _playerVars = entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElse(null);
					if (_playerVars != null) {
						_playerVars.Eteruos = entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElseGet(SashaeternalModVariables.PlayerVariables::new).Eteruos + 0.1;
						_playerVars.markSyncDirty();
					}
				}
			}
		});
	}
}