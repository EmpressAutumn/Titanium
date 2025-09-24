package com.atom596.titanium.datagen;

import com.atom596.titanium.Titanium;
import com.atom596.titanium.block.TitaniumBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TitaniumBlockTagProvider extends BlockTagsProvider {
    public TitaniumBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper exFileHelper) {
        super(output, completableFuture, Titanium.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Titanium.MOD_ID, "titanium_ores"))).add(
                TitaniumBlocks.TITANIUM_ORE.get(),
                TitaniumBlocks.TITANIUM_BLOCK.get(),
                TitaniumBlocks.END_TITANIUM_ORE.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                TitaniumBlocks.TITANIUM_ORE.get(),
                TitaniumBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                TitaniumBlocks.END_TITANIUM_ORE.get(),
                TitaniumBlocks.RAW_TITANIUM_BLOCK.get(),
                TitaniumBlocks.TITANIUM_BLOCK.get(),
                TitaniumBlocks.TITANIUM_LANTERN.get(),
                TitaniumBlocks.TITANIUM_BRICKS.get(),
                TitaniumBlocks.TITANIUM_BRICK_SLAB.get(),
                TitaniumBlocks.TITANIUM_BRICK_STAIRS.get(),
                TitaniumBlocks.TITANIUM_BRICK_WALL.get(),
                TitaniumBlocks.CHISELED_TITANIUM_BRICKS.get()
        );

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                TitaniumBlocks.TITANIUM_ORE.get(),
                TitaniumBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                TitaniumBlocks.END_TITANIUM_ORE.get(),
                TitaniumBlocks.RAW_TITANIUM_BLOCK.get(),
                TitaniumBlocks.TITANIUM_BLOCK.get(),
                TitaniumBlocks.TITANIUM_BRICKS.get(),
                TitaniumBlocks.TITANIUM_BRICK_SLAB.get(),
                TitaniumBlocks.TITANIUM_BRICK_STAIRS.get(),
                TitaniumBlocks.TITANIUM_BRICK_WALL.get(),
                TitaniumBlocks.CHISELED_TITANIUM_BRICKS.get()
        );

        this.tag(BlockTags.WALLS).add(TitaniumBlocks.TITANIUM_BRICK_WALL.get());

        this.tag(BlockTags.BEACON_BASE_BLOCKS).add(TitaniumBlocks.TITANIUM_BLOCK.get());
    }
}
