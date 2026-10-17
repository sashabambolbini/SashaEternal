package net.sashabambolbi.sashaeternal.procedures;

import net.sashabambolbi.sashaeternal.network.SashaeternalModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

public class PlayerClassWarriorProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElseGet(SashaeternalModVariables.PlayerVariables::new).player_class == 0) {
			{
				var _playerVars = entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElse(null);
				if (_playerVars != null) {
					_playerVars.player_class = 2;
					_playerVars.markSyncDirty();
				}
			}
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("sashaeternal:class_warrior"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
	}
}