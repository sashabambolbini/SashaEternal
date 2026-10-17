package net.sashabambolbi.sashaeternal.procedures;

import net.sashabambolbi.sashaeternal.network.SashaeternalModVariables;

import net.minecraft.world.entity.Entity;

public class EteruosbarcountTextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(entity.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElseGet(SashaeternalModVariables.PlayerVariables::new).Eteruos);
	}
}