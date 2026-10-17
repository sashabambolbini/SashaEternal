package net.sashabambolbi.sashaeternal.client.screens;

import net.sashabambolbi.sashaeternal.procedures.EteruosbarcountTextProcedure;
import net.sashabambolbi.sashaeternal.procedures.EteruosBarCountProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class EteruosBarOverlay {
	private static final ResourceLocation SPRITE_0 = new ResourceLocation("sashaeternal:textures/screens/eteruosbar.png");
	private static int cachedBarValue = 0;
	private static String cachedBarText = "";
	private static int lastUpdateTick = -1;

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		Player entity = Minecraft.getInstance().player;
		if (entity == null) return;

		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();

		int currentTick = (int) (System.currentTimeMillis() / 50);
		if (currentTick != lastUpdateTick) {
			cachedBarValue = Mth.clamp((int) EteruosBarCountProcedure.execute(entity) * 7, 0, 210);
			cachedBarText = EteruosbarcountTextProcedure.execute(entity);
			lastUpdateTick = currentTick;
		}

		event.getGuiGraphics().blit(SPRITE_0, w / 2 + 13, h - 41, 0, cachedBarValue, 78, 7, 78, 217);
		event.getGuiGraphics().drawString(Minecraft.getInstance().font, cachedBarText, w / 2 + 92, h - 41, -16737895, false);
	}
}