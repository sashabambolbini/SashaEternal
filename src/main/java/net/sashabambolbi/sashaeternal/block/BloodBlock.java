package net.sashabambolbi.sashaeternal.block;

import net.sashabambolbi.sashaeternal.init.SashaeternalModFluids;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class BloodBlock extends LiquidBlock {
	public BloodBlock() {
		super(() -> SashaeternalModFluids.BLOOD.get(),
				BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).lightLevel(state -> 2).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 9;
	}
}