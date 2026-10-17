/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sashabambolbi.sashaeternal.init;

import net.sashabambolbi.sashaeternal.SashaeternalMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class SashaeternalModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SashaeternalMod.MODID);
	public static final RegistryObject<CreativeModeTab> SASHA_ETERNAL = REGISTRY.register("sasha_eternal",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.sashaeternal.sasha_eternal")).icon(() -> new ItemStack(SashaeternalModItems.THE_CORRUPTION_CRYSTAL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SashaeternalModBlocks.THE_CORRUPTION_ORE.get().asItem());
				tabData.accept(SashaeternalModItems.THE_CORRUPTION_CRYSTAL.get());
				tabData.accept(SashaeternalModItems.CORRUPTED_KFINE.get());
				tabData.accept(SashaeternalModItems.CRYSTALLIZED_BLOOD.get());
				tabData.accept(SashaeternalModBlocks.CAULDRON.get().asItem());
				tabData.accept(SashaeternalModItems.ETERUOS_CRYSTAL.get());
				tabData.accept(SashaeternalModItems.BLOOD_BUCKET.get());
				tabData.accept(SashaeternalModBlocks.CRYSTAL_BALL.get().asItem());
				tabData.accept(SashaeternalModItems.SPIRE_IRON.get());
			}).build());
}