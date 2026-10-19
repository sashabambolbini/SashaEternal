package net.sashabambolbi.sashaeternal.init;

import net.sashabambolbi.sashaeternal.SashaeternalMod;
import net.sashabambolbi.sashaeternal.item.ThrownSpireIron;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SashaeternalModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SashaeternalMod.MODID);

	public static final RegistryObject<EntityType<ThrownSpireIron>> SPIRE_IRON_PROJECTILE = REGISTRY.register(
		"spire_iron_projectile",
		() -> EntityType.Builder.<ThrownSpireIron>of(ThrownSpireIron::new, MobCategory.MISC)
			.sized(0.5F, 0.5F)
			.build("spire_iron_projectile")
	);
}
