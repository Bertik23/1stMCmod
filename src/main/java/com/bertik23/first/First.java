package com.bertik23.first;

import com.bertik23.first.registry.ModBlocks;
import com.bertik23.first.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class First implements ModInitializer {

    public static final String MOD_ID = "bertikone";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
    }
}
