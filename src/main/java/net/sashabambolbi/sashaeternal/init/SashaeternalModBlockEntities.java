/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sashabambolbi.sashaeternal.init;

import net.sashabambolbi.sashaeternal.block.entity.CrystalBallBlockEntity;
import net.sashabambolbi.sashaeternal.block.entity.CauldronFullBlockEntity;
import net.sashabambolbi.sashaeternal.block.entity.CauldronBlockEntity;
import net.sashabambolbi.sashaeternal.SashaeternalMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;

public class SashaeternalModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SashaeternalMod.MODID);
	public static final RegistryObject<BlockEntityType<CauldronBlockEntity>> CAULDRON = register("cauldron", SashaeternalModBlocks.CAULDRON, CauldronBlockEntity::new);
	public static final RegistryObject<BlockEntityType<CauldronFullBlockEntity>> CAULDRON_FULL = register("cauldron_full", SashaeternalModBlocks.CAULDRON_FULL, CauldronFullBlockEntity::new);
	public static final RegistryObject<BlockEntityType<CrystalBallBlockEntity>> CRYSTAL_BALL = register("crystal_ball", SashaeternalModBlocks.CRYSTAL_BALL, CrystalBallBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}