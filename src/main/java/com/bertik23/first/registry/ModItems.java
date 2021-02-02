package com.bertik23.first.registry;

import com.bertik23.first.First;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    //Items
    public static final Item RUBY = new Item(new Item.Settings().group(First.ITEM_GROUP_GENERAL));

    //Block Items
    public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new Item.Settings().group(First.ITEM_GROUP_GENERAL));
    public static final BlockItem RUBY_ORE = new BlockItem(ModBlocks.RUBY_ORE, new Item.Settings().group(First.ITEM_GROUP_GENERAL));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(First.MOD_ID, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier(First.MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(First.MOD_ID, "ruby_ore"), RUBY_ORE);
    }
}
