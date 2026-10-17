package net.sashabambolbi.sashaeternal.fluid;

import net.sashabambolbi.sashaeternal.init.SashaeternalModItems;
import net.sashabambolbi.sashaeternal.init.SashaeternalModFluids;
import net.sashabambolbi.sashaeternal.init.SashaeternalModFluidTypes;
import net.sashabambolbi.sashaeternal.init.SashaeternalModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

public abstract class BloodFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> SashaeternalModFluidTypes.BLOOD_TYPE.get(), () -> SashaeternalModFluids.BLOOD.get(), () -> SashaeternalModFluids.FLOWING_BLOOD.get())
			.explosionResistance(100f).tickRate(30).slopeFindDistance(3).bucket(() -> SashaeternalModItems.BLOOD_BUCKET.get()).block(() -> (LiquidBlock) SashaeternalModBlocks.BLOOD.get());

	private BloodFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.CRIMSON_SPORE;
	}

	public static class Source extends BloodFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends BloodFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}