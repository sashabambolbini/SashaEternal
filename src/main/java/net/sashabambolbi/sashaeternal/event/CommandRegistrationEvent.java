package net.sashabambolbi.sashaeternal.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.sashabambolbi.sashaeternal.command.SashaeternalCommands;

@Mod.EventBusSubscriber(modid = "sashaeternal", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommandRegistrationEvent {
	@SubscribeEvent
	public static void onCommandRegister(RegisterCommandsEvent event) {
		SashaeternalCommands.register(event.getDispatcher());
	}
}
