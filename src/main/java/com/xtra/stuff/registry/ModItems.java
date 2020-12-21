package com.xtra.stuff.registry;

import com.xtra.stuff.XtraStuff;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems
{
    public static void registerItem()
    {
        Registry.register(Registry.ITEM, new Identifier(XtraStuff.MOD_ID, "snad"), new BlockItem(ModBlocks.SNAD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(XtraStuff.MOD_ID, "red_snad"), new BlockItem(ModBlocks.RED_SNAD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(XtraStuff.MOD_ID, "redstone_clock"), new BlockItem(ModBlocks.REDSTONE_CLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));
        Registry.register(Registry.ITEM, new Identifier(XtraStuff.MOD_ID, "detector_block"), new BlockItem(ModBlocks.DETECTOR_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));
        Registry.register(Registry.ITEM, new Identifier(XtraStuff.MOD_ID, "breaker_block"), new BlockItem(ModBlocks.BREAKER_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));
        Registry.register(Registry.ITEM, new Identifier(XtraStuff.MOD_ID, "cobblestone_generator"), new BlockItem(ModBlocks.COBBLESTONE_GENERATOR, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(XtraStuff.MOD_ID, "polished_stone"), new BlockItem(ModBlocks.POLISHED_STONE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}