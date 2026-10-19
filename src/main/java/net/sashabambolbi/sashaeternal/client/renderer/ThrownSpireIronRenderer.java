package net.sashabambolbi.sashaeternal.client.renderer;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ThrownSpireIronRenderer extends EntityRenderer<net.sashabambolbi.sashaeternal.item.ThrownSpireIron> {

	public ThrownSpireIronRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public ResourceLocation getTextureLocation(net.sashabambolbi.sashaeternal.item.ThrownSpireIron entity) {
		return new ResourceLocation("sashaeternal:textures/item/spireirontesture.png");
	}
}
