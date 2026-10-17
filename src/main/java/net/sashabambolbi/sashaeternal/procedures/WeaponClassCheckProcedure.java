package net.sashabambolbi.sashaeternal.procedures;

import net.sashabambolbi.sashaeternal.network.SashaeternalModVariables;
import net.minecraft.world.entity.player.Player;

public class WeaponClassCheckProcedure {
	public static boolean canUseWeapon(Player player, String weaponType) {
		if (player == null) return false;

		var playerVars = player.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).orElse(null);
		if (playerVars == null) return false;

		int playerClass = (int) playerVars.player_class;

		switch (weaponType) {
			case "sword": // Мечник (класс 1)
				return playerClass == 1;
			case "spear": // Копейщик (класс 3)
				return playerClass == 3;
			case "bow": // Лучник (класс 2)
				return playerClass == 2;
			case "staff": // Маг (класс 4)
				return playerClass == 4;
			default:
				return false;
		}
	}

	public static String getClassRequirement(String weaponType) {
		switch (weaponType) {
			case "sword":
				return "Требуется класс: Мечник";
			case "spear":
				return "Требуется класс: Копейщик";
			case "bow":
				return "Требуется класс: Лучник";
			case "staff":
				return "Требуется класс: Маг";
			default:
				return "";
		}
	}
}
