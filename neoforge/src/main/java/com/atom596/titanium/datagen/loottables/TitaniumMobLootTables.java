package com.atom596.titanium.datagen.loottables;

import com.atom596.titanium.Titanium;
import com.atom596.titanium.item.TitaniumItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class TitaniumMobLootTables implements LootTableSubProvider {
    public TitaniumMobLootTables(HolderLookup.Provider registries) {}

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer) {
        consumer.accept(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/shulker_bullet")), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(TitaniumItems.END_POWDER.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 4.0f)))
                        )
                )
        );
    }
}
