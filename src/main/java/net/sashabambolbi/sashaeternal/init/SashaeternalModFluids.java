/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.sashabambolbi.sashaeternal.init;

import net.sashabambolbi.sashaeternal.fluid.BloodFluid;
import net.sashabambolbi.sashaeternal.SashaeternalMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class SashaeternalModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, SashaeternalMod.MODID);
	public static final RegistryObject<FlowingFluid> BLOOD = REGISTRY.register("blood", BloodFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_BLOOD = REGISTRY.register("flowing_blood", BloodFluid.Flowing::new);

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(BLOOD.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BLOOD.get(), RenderType.translucent());
		}
	}
}