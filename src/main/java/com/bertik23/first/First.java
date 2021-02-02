package com.bertik23.first;

import com.bertik23.first.registry.ModBiomes;
import com.bertik23.first.registry.ModBlocks;
import com.bertik23.first.registry.ModItems;
import com.bertik23.first.registry.ModOreGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetContentsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.util.Identifier;

public class First implements ModInitializer {

    public static final String MOD_ID = "bertikone";

    public static final ItemGroup ITEM_GROUP_GENERAL = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"), () -> new ItemStack(ModItems.RUBY));

    public static final ItemGroup ITEM_GROUP_GLOWING = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "glowing"))
            .icon(() -> new ItemStack(Items.TORCH))
            .appendItems(itemStacks -> {
                itemStacks.add(new ItemStack(ModItems.RUBY_BLOCK));
                itemStacks.add(new ItemStack(Items.TORCH));
                itemStacks.add(new ItemStack(Items.GLOWSTONE));
            }).build();

    public static final Identifier EMERALD_ORE_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/emerald_ore");

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        modifyLootTables();
        ModOreGen.registerOreGen();
        ModBiomes.registerBiomes();
    }

    private void modifyLootTables() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, identifier, lootSupplier, lootTableSetter) -> {
            if (EMERALD_ORE_LOOT_TABLE_ID.equals(identifier)) {
                // Add one item type
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(Items.EMERALD))
                        .withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(1f, 10f)).build());

                lootSupplier.withPool(poolBuilder.build());

                // Inject loot table
                FabricLootPoolBuilder poolBuilder2 = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(LootTableEntry.builder(new Identifier("minecraft", "blocks/gold_ore")));

                lootSupplier.withPool(poolBuilder2.build());

            }
        });
    }
}
