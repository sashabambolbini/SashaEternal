package net.sashabambolbi.sashaeternal.network;

import net.sashabambolbi.sashaeternal.procedures.PlayerClassWarriorProcedure;
import net.sashabambolbi.sashaeternal.procedures.PlayerClassSpearmanProcedure;
import net.sashabambolbi.sashaeternal.procedures.PlayerClassMageProcedure;
import net.sashabambolbi.sashaeternal.procedures.PlayerClassArcherProcedure;
import net.sashabambolbi.sashaeternal.SashaeternalMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.SectionPos;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record CrystalballguButtonMessage(int buttonID, int x, int y, int z) {
	public CrystalballguButtonMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	public static void buffer(CrystalballguButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CrystalballguButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> handleButtonAction(context.getSender(), message.buttonID, message.x, message.y, message.z));
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			PlayerClassArcherProcedure.execute(entity);
		}
		if (buttonID == 1) {

			PlayerClassSpearmanProcedure.execute(entity);
		}
		if (buttonID == 2) {

			PlayerClassMageProcedure.execute(entity);
		}
		if (buttonID == 3) {

			PlayerClassWarriorProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SashaeternalMod.addNetworkMessage(CrystalballguButtonMessage.class, CrystalballguButtonMessage::buffer, CrystalballguButtonMessage::new, CrystalballguButtonMessage::handler);
	}
}