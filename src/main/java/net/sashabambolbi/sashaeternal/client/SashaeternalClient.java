package net.sashabambolbi.sashaeternal.client;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.sashabambolbi.sashaeternal.client.renderer.ThrownSpireIronRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;

import com.mojang.blaze3d.vertex.PoseStack;

@OnlyIn(Dist.CLIENT)
public class SashaeternalClient {

	@SubscribeEvent
	public void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(net.sashabambolbi.sashaeternal.init.SashaeternalModEntities.SPIRE_IRON_PROJECTILE.get(), ThrownSpireIronRenderer::new);
	}
}
