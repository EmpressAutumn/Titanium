package com.atom596.titanium;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;

public class TitaniumDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {/*
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(TitaniumBlockTagProvider::new);
		pack.addProvider(TitaniumItemTagProvider::new);
		pack.addProvider(TitaniumBlockLootTableProvider::new);
		pack.addProvider(TitaniumModelProvider::new);
		pack.addProvider(TitaniumRecipeProvider::new);
		pack.addProvider(TitaniumWorldGenerator::new);
		pack.addProvider(TitaniumAdvancementProvider::new);
		pack.addProvider(TitaniumChestLootTableProvider::new);
	*/}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {/*
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, TitaniumConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, TitaniumPlacedFeatures::bootstrap);
	*/}
}
