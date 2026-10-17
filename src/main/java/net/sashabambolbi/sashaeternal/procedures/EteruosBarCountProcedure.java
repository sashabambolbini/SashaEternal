package net.sashabambolbi.sashaeternal.procedures;

import net.sashabambolbi.sashaeternal.network.SashaeternalModVariables;

import net.minecraft.world.entity.Entity;

public class EteruosBarCountProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double result = 0;
		result = entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElseGet(SashaeternalModVariables.PlayerVariables::new).Eteruos
				/ entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElseGet(SashaeternalModVariables.PlayerVariables::new).maxEteruos;
		return Math.round(result * 30);
	}
}