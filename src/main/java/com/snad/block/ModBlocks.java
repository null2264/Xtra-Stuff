package com.snad.block;

import com.snad.Snad;

import net.minecraft.tag.Tag;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks 
{
	public static final SnadBlock SNAD = new SnadBlock();
	public static final SnadBlock RED_SNAD = new SnadBlock();

	public static final Tag<Block> TAG_SNAD = TagRegistry.block(Snad.identifier("snad"));
	
	public static void registerBlocks()
	{
		// Blocks
		Registry.register(Registry.BLOCK, new Identifier(Snad.MOD_ID, "snad"), SNAD);
		Registry.register(Registry.BLOCK, new Identifier(Snad.MOD_ID, "red_snad"), RED_SNAD);
		
		// Items
        Registry.register(Registry.ITEM, new Identifier(Snad.MOD_ID, "snad"), new BlockItem(SNAD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Snad.MOD_ID, "red_snad"), new BlockItem(RED_SNAD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}
}
