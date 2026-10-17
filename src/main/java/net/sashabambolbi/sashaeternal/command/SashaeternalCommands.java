package net.sashabambolbi.sashaeternal.command;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.sashabambolbi.sashaeternal.network.SashaeternalModVariables;
import com.mojang.brigadier.CommandDispatcher;

public class SashaeternalCommands {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		// Команда /resetclass
		dispatcher.register(Commands.literal("resetclass")
			.executes(context -> resetClass(context.getSource()))
		);

		// Команда /seteteruos
		dispatcher.register(Commands.literal("seteteruos")
			.then(Commands.argument("amount", com.mojang.brigadier.arguments.IntegerArgumentType.integer(0))
				.executes(context -> setEteruos(context.getSource(), com.mojang.brigadier.arguments.IntegerArgumentType.getInteger(context, "amount")))
			)
		);
	}

	private static int resetClass(CommandSourceStack source) {
		Player player = source.getPlayer();
		if (player == null) {
			source.sendFailure(Component.literal("Команда может быть использована только игроком"));
			return 0;
		}

		player.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
			capability.player_class = 0;
			capability.markSyncDirty();
		});

		source.sendSuccess(() -> Component.literal("§aКласс сброшен на 0 (без класса)"), true);
		return 1;
	}

	private static int setEteruos(CommandSourceStack source, int amount) {
		Player player = source.getPlayer();
		if (player == null) {
			source.sendFailure(Component.literal("Команда может быть использована только игроком"));
			return 0;
		}

		player.getCapability(SashaeternalModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
			capability.Eteruos = amount;
			capability.markSyncDirty();
		});

		source.sendSuccess(() -> Component.literal("§aEteruos установлен на: " + amount), true);
		return 1;
	}
}
