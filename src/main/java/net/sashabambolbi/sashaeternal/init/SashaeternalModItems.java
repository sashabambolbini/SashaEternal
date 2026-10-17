/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.sashabambolbi.sashaeternal.init;

import net.sashabambolbi.sashaeternal.item.TheCorruptionCrystalItem;
import net.sashabambolbi.sashaeternal.item.EteruosCrystalItem;
import net.sashabambolbi.sashaeternal.item.CrystallizedBloodItem;
import net.sashabambolbi.sashaeternal.item.CorruptedKfineItem;
import net.sashabambolbi.sashaeternal.item.BloodItem;
import net.sashabambolbi.sashaeternal.item.SpireIronItem;
import net.sashabambolbi.sashaeternal.SashaeternalMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Tiers;

public class SashaeternalModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SashaeternalMod.MODID);
	public static final RegistryObject<Item> THE_CORRUPTION_ORE;
	public static final RegistryObject<Item> THE_CORRUPTION_CRYSTAL;
	public static final RegistryObject<Item> CORRUPTED_KFINE;
	public static final RegistryObject<Item> CRYSTALLIZED_BLOOD;
	public static final RegistryObject<Item> CAULDRON;
	public static final RegistryObject<Item> CAULDRON_FULL;
	public static final RegistryObject<Item> ETERUOS_CRYSTAL;
	public static final RegistryObject<Item> BLOOD_BUCKET;
	public static final RegistryObject<Item> CRYSTAL_BALL;
	public static final RegistryObject<Item> SPIRE_IRON;
	static {
		THE_CORRUPTION_ORE = block(SashaeternalModBlocks.THE_CORRUPTION_ORE);
		THE_CORRUPTION_CRYSTAL = REGISTRY.register("the_corruption_crystal", TheCorruptionCrystalItem::new);
		CORRUPTED_KFINE = REGISTRY.register("corrupted_kfine", CorruptedKfineItem::new);
		CRYSTALLIZED_BLOOD = REGISTRY.register("crystallized_blood", CrystallizedBloodItem::new);
		CAULDRON = block(SashaeternalModBlocks.CAULDRON, new Item.Properties().rarity(Rarity.RARE));
		CAULDRON_FULL = block(SashaeternalModBlocks.CAULDRON_FULL);
		ETERUOS_CRYSTAL = REGISTRY.register("eteruos_crystal", EteruosCrystalItem::new);
		BLOOD_BUCKET = REGISTRY.register("blood_bucket", BloodItem::new);
		CRYSTAL_BALL = block(SashaeternalModBlocks.CRYSTAL_BALL, new Item.Properties().rarity(Rarity.RARE));
		SPIRE_IRON = REGISTRY.register("spire_iron", () -> new SpireIronItem(Tiers.IRON));
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return block(block, new Item.Properties());
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}