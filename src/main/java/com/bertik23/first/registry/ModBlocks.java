package com.bertik23.first.registry;

import com.bertik23.first.First;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
        .breakByTool(FabricToolTags.PICKAXES, 2)
        .requiresTool()
        .strength(5f, 20f)
        .sounds(BlockSoundGroup.METAL)
        .luminance(2));

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(First.MOD_ID, "ruby_block"), RUBY_BLOCK);
    }
}
