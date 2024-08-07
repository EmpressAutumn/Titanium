package com.atom596.titanium.block;

import com.atom596.titanium.Titanium;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class TitaniumBlocks {
    public static final Block TITANIUM_ORE = new Block(AbstractBlock.Settings.create().strength(4.0F).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block DEEPSLATE_TITANIUM_ORE = new Block(AbstractBlock.Settings.create().strength(4.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool());
    public static final Block END_TITANIUM_ORE = new Block(AbstractBlock.Settings.create().strength(4.0F).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block RAW_TITANIUM_BLOCK = new Block(AbstractBlock.Settings.create().strength(4.0F).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block TITANIUM_BLOCK = new Block(AbstractBlock.Settings.create().strength(4.0F).sounds(BlockSoundGroup.METAL).requiresTool());
    public static final Block TITANIUM_LANTERN = new TitaniumLanternBlock();

    public static void register() {
        Registry.register(Registries.BLOCK, new Identifier(Titanium.MOD_ID, "titanium_ore"), TITANIUM_ORE);
        Registry.register(Registries.BLOCK, new Identifier(Titanium.MOD_ID, "deepslate_titanium_ore"), DEEPSLATE_TITANIUM_ORE);
        Registry.register(Registries.BLOCK, new Identifier(Titanium.MOD_ID, "end_titanium_ore"), END_TITANIUM_ORE);
        Registry.register(Registries.BLOCK, new Identifier(Titanium.MOD_ID, "raw_titanium_block"), RAW_TITANIUM_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(Titanium.MOD_ID, "titanium_block"), TITANIUM_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(Titanium.MOD_ID, "titanium_lantern"), TITANIUM_LANTERN);
    }
}
