package net.sashabambolbi.sashaeternal.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.particles.DustParticleOptions;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class ThrownSpireIron extends ThrowableItemProjectile {
	private ItemStack itemStack = ItemStack.EMPTY;

	public ThrownSpireIron(EntityType<? extends ThrownSpireIron> type, Level level) {
		super(type, level);
	}

	public ThrownSpireIron(Level level, LivingEntity thrower) {
		super(net.sashabambolbi.sashaeternal.init.SashaeternalModEntities.SPIRE_IRON_PROJECTILE.get(), thrower, level);
	}

	public ThrownSpireIron(Level level, double x, double y, double z) {
		super(net.sashabambolbi.sashaeternal.init.SashaeternalModEntities.SPIRE_IRON_PROJECTILE.get(), x, y, z, level);
	}

	@Override
	protected Item getDefaultItem() {
		return net.sashabambolbi.sashaeternal.init.SashaeternalModItems.SPIRE_IRON.get();
	}

	@Override
	public void readAdditionalSaveData(net.minecraft.nbt.CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Item")) {
			this.itemStack = ItemStack.of(compound.getCompound("Item"));
		}
	}

	@Override
	public void addAdditionalSaveData(net.minecraft.nbt.CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		if (!this.itemStack.isEmpty()) {
			compound.put("Item", this.itemStack.save(new net.minecraft.nbt.CompoundTag()));
		}
	}

	@Override
	public void setItem(ItemStack stack) {
		this.itemStack = stack;
	}

	@Override
	public ItemStack getItem() {
		return this.itemStack;
	}

	@Override
	public void tick() {
		super.tick();

		if (this.tickCount > 60) {
			this.discard();
		}
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		if (result.getEntity() instanceof LivingEntity) {
			result.getEntity().hurt(this.level().damageSources().thrown(this, this.getOwner()), 6.0F);
		}
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
		this.discard();
	}
}
