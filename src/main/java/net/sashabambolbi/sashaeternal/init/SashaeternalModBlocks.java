/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sashabambolbi.sashaeternal.init;

import net.sashabambolbi.sashaeternal.block.TheCorruptionOreBlock;
import net.sashabambolbi.sashaeternal.block.CrystalBallBlock;
import net.sashabambolbi.sashaeternal.block.CauldronFullBlock;
import net.sashabambolbi.sashaeternal.block.CauldronBlock;
import net.sashabambolbi.sashaeternal.block.BloodBlock;
import net.sashabambolbi.sashaeternal.SashaeternalMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class SashaeternalModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SashaeternalMod.MODID);
	public static final RegistryObject<Block> THE_CORRUPTION_ORE;
	public static final RegistryObject<Block> CAULDRON;
	public static final RegistryObject<Block> CAULDRON_FULL;
	public static final RegistryObject<Block> BLOOD;
	public static final RegistryObject<Block> CRYSTAL_BALL;
	static {
		THE_CORRUPTION_ORE = REGISTRY.register("the_corruption_ore", TheCorruptionOreBlock::new);
		CAULDRON = REGISTRY.register("cauldron", CauldronBlock::new);
		CAULDRON_FULL = REGISTRY.register("cauldron_full", CauldronFullBlock::new);
		BLOOD = REGISTRY.register("blood", BloodBlock::new);
		CRYSTAL_BALL = REGISTRY.register("crystal_ball", CrystalBallBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}